<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="mx.com.iusacell.comisiones.web.seguridad.struts.action.*"%>
<%@ page import="mx.com.iusacell.comisiones.utilerias.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/fsj-html.tld" prefix="fsj" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Welcome to My World   &raquo; html</title>

<meta name="generator" content="WordPress 2.7.1" /> <!-- leave this for stats -->

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/comisiones.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/error.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styless/fin.css" />
	<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>


<script>
	function Salir()
        	{
        			history.current = "";
        			parent.document.location = "LoginAction.do?action=Salir";
        	}
</script>
</head>

<body>

	<div id="head" class="container-fluid">
		<h2>Comisiones a Distribuidores</h2>
		<h2><small>Area de Sistemas IUSACELL</small></h2>
	</div>

	<html:form method="post" action="LoginAction" > 
		<bean:define id="LoginForm" name="LoginForm" type="mx.com.iusacell.comisiones.web.seguridad.struts.action.LoginForm"/>
		<div id="wrapper">
			<div id="page">  
				<div id="content">
    				<div class="post" id="post-419">
						<logic:present name="mensaje">
							<div class="entry">
        						<h2><a href="#" onclick="Salir()" rel="bookmark" title="Salir de la pagina">Se presentaron los siguientes errores al inicio.</a></h2>
		    					<span><bean:write name="mensaje"/></span>
	  						</div>
		    			</logic:present>
					</div>
	  			</div>
			</div>
		</div>
	</html:form>
</body>
</html>