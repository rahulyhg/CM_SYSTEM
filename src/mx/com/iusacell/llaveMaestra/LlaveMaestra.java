package mx.com.iusacell.llaveMaestra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class LlaveMaestra {
	
//	Logger log = Logger.getLogger(LlaveMaestra.class);
	
	final static Logger log = Logger.getLogger(LlaveMaestra.class);
	
	/**
	 *	usuario 
	 *  contrasenia
	 *  idAplicacion  
	 * 	llaveAplicacion
	 * 	ip
	 * 	numeroEmpleado
	 * 	llaveMaestra
	 * 	token
	 * @throws Exception 
	 * */
	public ValidacionTokenVO validarLlave(String usuario, String contrasenia, String ip) throws Exception{
		
		ValidacionTokenVO validacionTokenVO = null;
		log.info("Inicia proceso validarLlave()");
		try{
			//QA
//	        String urlString = "http://10.203.24.211:39008/VerificaUsuarioService/svAutenticacion";//"http://10.203.24.211:39008/VerificaUsuarioService/svAutenticacion";
//	        String llave = "hzp+e$eo+V*FepYD3+kEk7q1@X1LGY";
//	        String idApp = "39";
			//PDC
			String urlString = "http://10.188.17.250:38111/VerificaUsuarioService/svAutenticacion";
	        String llave = "Nbz)0lStEJn8*pS6sUowLyHy$jFe7s";
	        String idApp = "26";
	        
	        String usuarioLlave = "/esmfxtAcJam1PtmdnsCr3sP=/";
	        String consaeniaLlave = "/esmfxtAcJam1PtmdnsCr3sP=/"; 
	        
	        URL urlForInfWebSvc = new URL(urlString);
	        URLConnection UrlConnInfWebSvc = urlForInfWebSvc.openConnection();
	        HttpURLConnection conn = (HttpURLConnection) UrlConnInfWebSvc;
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
	        OutputStreamWriter infWebSvcReqWriter = new OutputStreamWriter(conn.getOutputStream());

			TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
			Date fechaAct = new Date();
			SimpleDateFormat isoFormat = new SimpleDateFormat("ddMMyyyyHHmm");
			
			byte[] key_ = usuarioLlave.substring(0,16).getBytes();
			
			String token = Llaveencriptar.encrypt(isoFormat.format(fechaAct)+ usuario, key_);
			String llaveAplicacion = Llaveencriptar.encrypt(llave, key_);
			
	        byte[] key2_ = llave.substring(0,16).getBytes();
	        String llaveMaestra = Llaveencriptar.encrypt(contrasenia, key2_);	        
	        
	        String infWebSvcRequestMessage = 
	        	"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.auth.iusacell.com.mx\">\n"+
				"<soapenv:Header/>\n"+
				"<soapenv:Body>\n"+
				"<ser:ValidaLlaveMaestraIusacell>\n"+
				"<ser:in0>" + usuarioLlave + "</ser:in0>\n"+
				"<ser:in1>" + consaeniaLlave + "</ser:in1>\n"+
				"<ser:in2>" + idApp + "</ser:in2>\n"+
				"<ser:in3>" + llaveAplicacion + "</ser:in3>\n"+
				"<ser:in4>" + ip + "</ser:in4>\n"+
				"<ser:in5>" + usuario + "</ser:in5>\n"+
				"<ser:in6>" + llaveMaestra + "</ser:in6>\n"+
				"<ser:in7>" + token	+ "</ser:in7>\n"+
				"</ser:ValidaLlaveMaestraIusacell>\n"+
				"</soapenv:Body>\n"+
				"</soapenv:Envelope>";
	         
	         infWebSvcReqWriter.write(infWebSvcRequestMessage);
	         infWebSvcReqWriter.flush();
	         log.info("Se envio peticion LlaveMaestra:"+infWebSvcRequestMessage);
	         
	         BufferedReader infWebSvcReplyReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));log.info("1");
	         String line;log.info("2");
	         String infWebSvcReplyString = "";log.info("3");
	         while ((line = infWebSvcReplyReader.readLine()) != null) {
	             infWebSvcReplyString = infWebSvcReplyString.concat(line);log.info("4");
	             }
	         infWebSvcReqWriter.close();log.info("5");
	         infWebSvcReplyReader.close();log.info("6");
	         conn.disconnect();log.info("7");
	         log.info("Se lee peticion LlaveMaestra");
	         
	         validacionTokenVO = mapperWsVo(infWebSvcReplyString);
	         
	         log.info("Datos Llave Maestra empleado: " + usuario + " aut: " + String.valueOf(validacionTokenVO.isAuth()) +
	         		" cambioLlave: " + validacionTokenVO.getCambioLlave() + " fechaCad: " + validacionTokenVO.getFechaCad() + " mensaje: "
					+ validacionTokenVO.getMensaje());

		}catch(Exception e){
			//throw new Exception("Error en metodo validarLlave(), error: " + e.getMessage());
			if(validacionTokenVO==null){validacionTokenVO = new ValidacionTokenVO();}
			validacionTokenVO.setAuth(false);
			validacionTokenVO.setMensaje("El usuario y/o contraseña son incorrectos. Ingréselos de nuevo.");
			log.error("Existió un error:"+e);
		}
		log.info("Termina proceso validarLlave()");
		return validacionTokenVO;
	}
	
	private ValidacionTokenVO mapperWsVo(String ws_response) throws Exception{

	     ValidacionTokenVO TokenIusacell =new ValidacionTokenVO();


	     DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	     domFactory.setNamespaceAware(true);
	     DocumentBuilder builder = domFactory.newDocumentBuilder();
	     Document body = builder.parse(new InputSource(new StringReader(ws_response)));

	     NodeList returnList = body.getElementsByTagName("soap:Body");
	     Node node = null;

	     if(returnList != null && returnList.getLength() > 0){
	      NodeList ns1List = returnList.item(0).getChildNodes();

	      if(ns1List != null && ns1List.getLength() > 0){

	       node=ns1List.item(0);
	       NodeList ns0List = node.getChildNodes();

	       if(ns0List != null && ns0List.getLength() > 0){
	        node = ns0List.item(0);
	        NodeList returnList3 = node.getChildNodes();

			     for(int j=0; j < returnList3.getLength(); j++){
		
			      Node node3 = returnList3.item(j);
		
			      if(node3.getNodeName().equals("auth") && node3.getFirstChild() != null){
			      	
			       TokenIusacell.setAuth(convierteBoleano(node3.getFirstChild().getNodeValue(), node3.getNodeName()));
			      }
			      if(node3.getNodeName().equals("cambioLlave") && node3.getFirstChild() != null){
				       TokenIusacell.setCambioLlave(node3.getFirstChild().getNodeValue());
				      }
			      if(node3.getNodeName().equals("fechaCad") && node3.getFirstChild()!= null){
				       TokenIusacell.setFechaCad(node3.getFirstChild().getNodeValue());
				      }
			      if(node3.getNodeName().equals("mensaje") && node3.getFirstChild() != null){
			       TokenIusacell.setMensaje(node3.getFirstChild().getNodeValue());
			      }
			      
			   }
	        }
	      }

	     }

	  return TokenIusacell;
	}

    private boolean convierteBoleano(String boleano,String etiqueta) throws Exception {
		try {
			return Boolean.valueOf(boleano).booleanValue();
		} catch (IllegalArgumentException e) {
			throw new Exception(
					"La respuesta del servicio no tiene el formato esperado. El Campo " + etiqueta + "no es un tipo boleano");
		} catch (Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		
		
	}	


}
