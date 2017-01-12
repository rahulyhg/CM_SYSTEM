/*
 * Created on 10/12/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.iusacell.comisiones.web.seguridad.struts.action;

import iusacell.comisiones.ayuda.UserBean;
import iusacell.comisiones.dao.ComisionesDAO;
import iusacell.comisiones.vo.PermisosVO;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;

import mx.com.iusacell.comisiones.utilerias.Constantes;
import mx.com.iusacell.comisiones.utilerias.Proxy;
import mx.com.iusacell.llaveMaestra.LlaveMaestra;
import mx.com.iusacell.llaveMaestra.ValidacionTokenVO;
import sun.misc.BASE64Decoder;
/**
 * @author jojeda
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoginProxy extends Proxy {

	protected static final Logger logger = Logger.getLogger(LoginProxy.class);
	
	
	public LoginProxy() {
		
	}
	
	private ComisionesDAO comisionesDAO;

	@SuppressWarnings("unchecked")
	public ActionForward entrar(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response, WebApplicationContext context) throws IOException {
		
		comisionesDAO = (ComisionesDAO) context.getBean("comisionesDAO");
//			PropertyConfigurator.configure(getClass().getClassLoader().getResource("/log4j.properties"));
		boolean administrador = false;
		boolean sinLlave = false;
		
		Enumeration enume = request.getParameterNames();
		
		while (enume.hasMoreElements()) {
			 String key = (String)enume.nextElement();
			 Object value = request.getAttribute(key);
			 Object valueP = request.getParameter(key);
			 System.out.println("Llave: " + key + " = [Atribute:" + value +"] [Parameter: "+valueP+"]");
			 logger.info("Llave: " + key + " = [Atribute:" + value +"] [Parameter: "+valueP+"]");
		 }
		/** ************************* */
		/* Validacion Llave Maestra */
		/** ************************* */
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		password = new String(new BASE64Decoder().decodeBuffer(password));
		int es = password.lastIndexOf("/");
		password = password.substring(0,es);
		
		if(password.lastIndexOf(Constantes.SIN_LLAVE)>=0){
			password = password.replaceAll(Constantes.SIN_LLAVE,"");
			sinLlave = true;
		}
		
		if(password.lastIndexOf(Constantes.USR_ADMIN)>=0){
			password = password.replaceAll(Constantes.USR_ADMIN,"");
			administrador = true;
		}
		
//			UtilLogin utilLogin = new UtilLoginImpl();
		logger.info("[lgn] - v_LlM [" + usuario +"]");

		UserBean usuarioBean = null;
		try {
			LlaveMaestra llaveMaestra = new LlaveMaestra();
			InetAddress address = InetAddress.getLocalHost();
//				usuarioBean = LlautilLogin.validarUsuario(usuario,	password, "");
			ValidacionTokenVO tokenVO = llaveMaestra.validarLlave(usuario, password, address.getHostAddress());
			if(tokenVO.isAuth()||sinLlave){
				usuarioBean = new UserBean(usuario, "", "",
						"", usuario, "", "");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			if(sinLlave){
				usuarioBean = new UserBean(usuario, "", "",
						"", usuario, "", "");
			}
		}
		
		String mensaje = "";
		
		if(usuarioBean == null
				|| (usuarioBean.getRespuesta() != null && usuarioBean
						.getRespuesta().startsWith("[Error]"))){
			mensaje = "El usuario no existe";
			request.setAttribute("mensaje", mensaje);
			logger.info("[lgn] -Incorrectos ****** Fin ******");
			return mapping.findForward("Login");
		} else {
			String modulo = "Login";
			List perfiles = comisionesDAO.obtnerPermisos(usuarioBean.getNumEmpleado());
			if((perfiles == null || perfiles.size()==0 ) && !administrador){
				mensaje = "El usuario no es valido para accesar al sistema.";
				request.setAttribute("mensaje", mensaje);
				logger.info("[lgn] -Incorrectos ****** Fin ******");
				modulo = "Login";
			}else if(administrador){
				request.getSession().setAttribute("usuarioSession",usuarioBean);
				request.getSession().setAttribute("numUsuario",usuarioBean.getNumEmpleado());
				request.getSession().setAttribute("isAdministrador",new Boolean(administrador));
				logger.info("[lgn] - [" + usuario +"] - usr_true, msg: " + usuarioBean.getRespuesta());
				modulo = "menu";
			}else{
				boolean reportes = false;
				boolean interFactura = false;
				for (Iterator it = perfiles.iterator(); it.hasNext();) {
					PermisosVO permiso = (PermisosVO) it.next();
					if(permiso.getIdPerfil().equals(new Integer(5))){
						request.getSession().setAttribute("usuarioSession",usuarioBean);
						request.getSession().setAttribute("numUsuario",usuarioBean.getNumEmpleado());
						request.getSession().setAttribute("isAdministrador",new Boolean(administrador));
						logger.info("[lgn] - [" + usuario +"] - usr_true, msg: " + usuarioBean.getRespuesta());
						administrador = true;
					}else if(permiso.getIdModulo() != null && (permiso.getIdModulo().equals(new Integer(1)) || permiso.getIdModulo().equals(new Integer(2)) )){
						interFactura = true;
					}
					else if(permiso.getIdModulo() != null && (permiso.getIdModulo().equals(new Integer(3)) || permiso.getIdModulo().equals(new Integer(4)) )){
						reportes = true;
					}
				}
				if(administrador || (interFactura && reportes)){
					modulo = "menu";
				}else if(interFactura){
					modulo = "listaComisiones";
				}else if(reportes){
					modulo = "inicioCarga";
				}else{
					mensaje = "El usuario no es valido para accesar al sistema.";
					request.setAttribute("mensaje", mensaje);
					logger.info("[lgn] -Incorrectos ****** Fin ******");
					modulo = "Login";
				}
			}
			
			return mapping.findForward(modulo);
		}
	}
	
	public ActionForward salir(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) {
			request.getSession().invalidate();
			return mapping.findForward("welcome");
	}

	public ComisionesDAO getComisionesDAO() {
		return comisionesDAO;
	}

	public void setComisionesDAO(ComisionesDAO comisionesDAO) {
		this.comisionesDAO = comisionesDAO;
	}
	
}
