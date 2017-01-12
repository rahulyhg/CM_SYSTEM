/*
 * Created on 24/11/2009
 *
 */
package iusacell.comisiones.ayuda;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import iusacell.comisiones.util.Reflection;
import iusacell.comisiones.vo.ValueObject;

import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author jarcos
 */
public class UtilXML {
	
	private String XML_ENCODING	= "ISO-8859-1";
	private String XML_VERSION	= "1.0";
	
	private BASE64Encoder baseEnc = new BASE64Encoder();
	private BASE64Decoder baseDec = new BASE64Decoder();
	private List<Node> lstNodes = null;
	
	public UtilXML() {
		lstNodes = new ArrayList<Node>();
	}
	
	public Document createDocument(String xml) throws Exception{
		Document document = null;
        try {
        	//SE CREA EL XML A PARTIR DEL STRING
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = (Document) db.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
            throw new Exception(pce.getMessage());
        } catch (SAXException se) {
            se.printStackTrace();
            throw new Exception(se.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new Exception(ioe.getMessage());
        }
        return document;
    }
	
	public Document createDocument(File file) throws Exception{
		Document document = null;
	    try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            document = docBuilder.parse(file);
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
        return document;
	}
	
	public Document createDocument(InputStream is) throws Exception{
		Document document = null;
	    try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            document = docBuilder.parse(is);
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
        return document;
	}
	
	public Document createDocument() throws Exception{
    	Document documentoXML = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			documentoXML = docBuilder.newDocument();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return documentoXML;
	}
	
	public String generaTextoXML(Document document) throws Exception{
		StringWriter strWriter = null;
		XMLSerializer seliarizadorXML = null;
		OutputFormat formatoSalida = null;
		String tokenXML = null;
		try {
			seliarizadorXML = new XMLSerializer();
			strWriter = new StringWriter();
			formatoSalida = new OutputFormat();
			formatoSalida.setEncoding(XML_ENCODING);
			formatoSalida.setVersion(XML_VERSION);
			formatoSalida.setIndenting(true);
			formatoSalida.setOmitXMLDeclaration(false);
			formatoSalida.setOmitDocumentType(true);
			formatoSalida.setStandalone(false);
			seliarizadorXML.setOutputCharStream(strWriter);
			seliarizadorXML.setOutputFormat(formatoSalida);
			seliarizadorXML.serialize(document);
			strWriter.close();
		} catch (IOException ioEx) {
			throw new Exception(ioEx.getMessage());
		}
		tokenXML = strWriter.toString();
		return tokenXML;
	}
	
	public String getValorByElement(String cadXML, String tag)  throws Exception{
		String valor = "";
		try {
			Document document = createDocument(cadXML);
			NodeList nl = document.getElementsByTagName(tag);
			if(nl.getLength()>0){
				Node node = (Node)nl.item(0);
				NodeList nl1 = node.getChildNodes();
				if(nl1.getLength()>0){
					Node node1 = (Node)nl1.item(0);
					valor = node1.getNodeValue();
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		valor = valor!=null ? valor : "";
		return valor;
	}
	
	public void recorrerRama(Node nodo) throws Exception{
		try{
			if(nodo!=null){
				NodeList nl = nodo.getChildNodes();
				if(nl.getLength()>0){
			        for(int i=0;i<nl.getLength();i++){
			        	Node node = nl.item(i);
			        	if(node.getNodeName()!=null && !node.getNodeName().startsWith("#")){
							lstNodes.add(node);
			        	}
			        	recorrerRama(node);
			        }
				}
			}
		}catch(Exception exc){
			throw new Exception(exc.getMessage());
		}
	}
	
	public String decodeBase64(String tokenXMLEncript) throws Exception{
		String xmlDecode = null;
		try{
			byte[] xmlDecodeBuffer  = baseDec.decodeBuffer(tokenXMLEncript);
			xmlDecode = new String(xmlDecodeBuffer ,XML_ENCODING);
		}catch(Exception exc){
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return xmlDecode;
	}
	
	@SuppressWarnings("unchecked")
	public ValueObject generateVO(String xml, ValueObject vo) throws Exception{
		ValueObject returnvo = null;
		try{
			Object[] objs = null;
			String clase = ((Class)vo.getClass()).getName();
		    Reflection ref = new Reflection(clase);
		    returnvo = (ValueObject)vo.getClass().newInstance();
		    for(int i=0; vo!=null && vo.getCampos()!=null && i<vo.getCampos().length; i++){
		    	objs = new Object[1];
		    	String valor = getValorByElement(xml, vo.getCampos()[i]);
		    	objs[0] = valor;
		    	String metodo = ref.getMethod("set"+vo.getCampos()[i]);
		    	ref.setValorMetodo(metodo, returnvo, objs);
		    }
		}catch(Exception exc){
			throw new Exception();
		}
		return returnvo;
	}

	public void setBaseEnc(BASE64Encoder baseEnc) {
		this.baseEnc = baseEnc;
	}

	public BASE64Encoder getBaseEnc() {
		return baseEnc;
	}
}
