/*
 * Created on 8/10/2009
 *
 */
package iusacell.comisiones.ayuda;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URLDecoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import iusacell.comisiones.ayuda.UserBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author hb
 *
 */
public class TokenRH {

	private static final long serialVersionUID = 1L;
	
	private static final String XML_ENCODING = "ISO-8859-1";
	
	private static final String TAG_USERS		= "users";
	private static final String TAG_USER		= "user";
	private static final String ATTR_USUARIO	= "http_impersonate";
	private static final String ATTR_NOMBRE		= "http_nombre";
	private static final String ATTR_APELLIDOS	= "http_apellidos";
	private static final String ATTR_COMPANIA	= "http_compania";
	private static final String ATTR_NUM_EMPLEA	= "http_numerodeempleado";
	private static final String ATTR_MAIL		= "http_mail";
	private static final String ATTR_IP			= "http_ip";

	private Document document;
	private Document documentoXML = null;
	private Element users = null;
	private UserBean usuarioBean;
	private String token;
	private String tokenXML;
	private String tokenEncript;
	
	private BASE64Decoder baseDec = new BASE64Decoder();
	private BASE64Encoder baseEnc = new BASE64Encoder();
	
	public TokenRH(UserBean usuarioBean) {
		super();
		generarDocumentoXML();
		generarDocumentoXML(usuarioBean);
		generaTextoXML();
		encodeBase64();
		this.token = tokenEncript;
		crearXML();
		parsearDocumento();
	}

	public TokenRH(String token) {
		super();
		this.token = token;
		crearXML();
		parsearDocumento();
	}
	
	public TokenRH(){
		
	}
	
	private void crearXML() {
        try {
        	String xmlURLDecoder = URLDecoder.decode(token,XML_ENCODING);
        	byte[]  xmlDecodeBuffer=baseDec.decodeBuffer(xmlURLDecoder);
        	String xmlDecodeBufferEnString="";
        	xmlDecodeBufferEnString = new String(xmlDecodeBuffer ,XML_ENCODING);
        	xmlDecodeBufferEnString = xmlDecodeBufferEnString.replace('?','>');
        	crearXML(xmlDecodeBufferEnString);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	
	private void crearXML(String xml) {
        try {
        	//SE CREA EL XML A PARTIR DEL STRING
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = (Document) db.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	
    private void parsearDocumento() {
        Element docEle = document.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("user");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element elemento = (Element) nl.item(i);
                obtenerAtributos(elemento);
            }
        }
    }
    
    private void obtenerAtributos(Element elemento) {
    	String usuario = elemento.getAttribute("http_impersonate");
        String nombre = elemento.getAttribute("http_nombre");
        String apellidos = elemento.getAttribute("http_apellidos");
        String compania = elemento.getAttribute("http_compania");
        String numEmpleado = elemento.getAttribute("http_numerodeempleado");
        String mail = elemento.getAttribute("http_mail");
        String ip = elemento.getAttribute("http_ip");
        usuarioBean = new UserBean(usuario, nombre, apellidos, compania, numEmpleado, mail, ip);
    }
    
    public void loginNormal(){
    	crearXML(tokenXML);
    	parsearDocumentoLogin();
    }
    private void parsearDocumentoLogin() {
        Element docEle = document.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Login");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element elemento = (Element) nl.item(i);
                obtenerAtributosLogin(elemento);
            }
        }
    }
    
    private void obtenerAtributosLogin(Element elemento) {
    	String usuario		= elemento.getAttribute("");
        String nombre		= elemento.getAttribute("Nombre");
        String apellidos	= elemento.getAttribute("");
        String compania		= elemento.getAttribute("Empresa");
        String numEmpleado	= elemento.getAttribute("NumEmp");
        if(numEmpleado!=null && numEmpleado.trim().length()>0)
        	numEmpleado	= UtilsSoap.rellenarIzquierdaConCeros(Integer.parseInt(numEmpleado), 8);
        String mail			= elemento.getAttribute("Correo");
        String ip			= elemento.getAttribute("");
        String respuesta	= elemento.getAttribute("Respuesta");
        usuarioBean = new UserBean(usuario, nombre, apellidos, compania, numEmpleado, mail, ip, respuesta);
    }

    private void generarDocumentoXML() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			documentoXML = docBuilder.newDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
		users = documentoXML.createElement(TAG_USERS);
		documentoXML.appendChild(users);
	}
    
    private void generarDocumentoXML(UserBean usuarioBean) {
		Element elemento;
		elemento = documentoXML.createElement(TAG_USER);
		elemento.setAttribute(ATTR_USUARIO, usuarioBean.getUsuario());
		elemento.setAttribute(ATTR_NOMBRE, "DESARROLLO");
		elemento.setAttribute(ATTR_APELLIDOS, "PRUEBAS PRUEBAS");
		elemento.setAttribute(ATTR_COMPANIA, "IUSACELL");
		String numEmp = usuarioBean.getUsuario().substring(2, usuarioBean.getUsuario().length());
		if(numEmp==null || numEmp.trim().length()==0) numEmp = "0";
		elemento.setAttribute(ATTR_NUM_EMPLEA, UtilsSoap.rellenarIzquierdaConCeros(Integer.parseInt(numEmp), 8));
		elemento.setAttribute(ATTR_MAIL, "desarrollo@iusacell.com.mx");
		elemento.setAttribute(ATTR_IP, usuarioBean.getIp());
		users.appendChild(elemento);
	}
    
	private void encodeBase64(){
		try{
			tokenEncript = baseEnc.encode(tokenXML.getBytes());
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	private void generaTextoXML() {
		StringWriter strWriter = null;
		XMLSerializer seliarizadorXML = null;
		OutputFormat formatoSalida = null;
		try {
			seliarizadorXML = new XMLSerializer();
			strWriter = new StringWriter();
			formatoSalida = new OutputFormat();
			//formatoSalida.setEncoding(XML_ENCODING);
			//formatoSalida.setVersion(XML_VERSION);
			formatoSalida.setIndenting(false);
			formatoSalida.setOmitXMLDeclaration(true);
			//formatoSalida.setOmitDocumentType(true);
			formatoSalida.setStandalone(true);
			seliarizadorXML.setOutputCharStream(strWriter);
			seliarizadorXML.setOutputFormat(formatoSalida);
			seliarizadorXML.serialize(documentoXML);
			strWriter.close();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
		tokenXML = strWriter.toString();
	}
	/**
	 * @return UsuarioBean
	 */
	public UserBean getUsuarioBean() {
		return usuarioBean;
	}

	/**
	 * @return String
	 */
	public String getTokenEncript() {
		return tokenEncript;
	}

	/**
	 * @param tokenXML String
	 */
	public void setTokenXML(String tokenXML) {
		this.tokenXML = tokenXML;
	}

}
