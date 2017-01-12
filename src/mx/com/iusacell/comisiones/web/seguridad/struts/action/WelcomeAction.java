/*
 * Created on May 25, 2005
 *
 */
package mx.com.iusacell.comisiones.web.seguridad.struts.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

/**
 * Clase WelcomeAction redirecciona a la pagina de inicio welcome(login)
 * @author Administrator
 *
 */
public class WelcomeAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4783787386906449739L;

	public ActionForward execute(ActionMapping mapping,	ActionForm form, HttpServletRequest request,	HttpServletResponse response)	throws IOException, ServletException {
		
		String action = request.getParameter("action");
		
//		ArrayList esquemas = new ArrayList();
////		esquemas = LoginFacade.getEsquemas();
//		
//		System.out.println("Esquemas: " + esquemas != null ? "Esquemas encontrados: " +esquemas.size():"no trajo esquemas");
		
		if(action==null)
			action = "home";
			
			System.out.println("Entro a WelcomeAction");
		if(action.equals("password"))
			action = "password";
		else{
			System.out.println("Entro a WelcomeAction2");
			action = "home";
		}
		
		return (mapping.findForward(action));
			
	}
}
