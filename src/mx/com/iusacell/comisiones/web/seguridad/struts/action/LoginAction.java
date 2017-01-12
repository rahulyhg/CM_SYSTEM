/*
 * Created on 10/12/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.iusacell.comisiones.web.seguridad.struts.action;

import iusacell.comisiones.bo.CargaArchivoBO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;


/**
 * @author EHERNANDEZH
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5003965447400774122L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private LoginProxy loginProxy;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		String action = request.getParameter("action");
		

		if (action == null) {
			action = "Entrar";
		}
		
		System.out.println("accion="+action);
		
		loginProxy = (LoginProxy) getWebApplicationContext().getBean("loginProxy");
		
		try {
            // Set a transactional control token to prevent double posting
         //   saveToken(request);

            if(action.equals("Entrar")){
				return entrar(mapping,form,request,response);
			}else if(action.equals("Salir")){
				return salir(mapping,form,request,response);
			}
          
            return (mapping.findForward(action));
        } catch (Exception ex) {
        ex.printStackTrace();
        }
		return null;
	}

//	private String home() {
//			request.getSession().setMaxInactiveInterval(1200);
//		return new  LoginProxy().home(request,response); 
//			
//	}
	
	private ActionForward entrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		return loginProxy.entrar(mapping,form,request,response,getWebApplicationContext());
			
	}	
	private ActionForward salir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			 return loginProxy.salir(mapping,form,request,response);
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public LoginProxy getLoginProxy() {
		return loginProxy;
	}

	public void setLoginProxy(LoginProxy loginProxy) {
		this.loginProxy = loginProxy;
	}
	

}

