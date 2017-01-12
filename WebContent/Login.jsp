<%@ page language="java" %>
<html>
<head>
	<title>Iusacell :: Comisiones </title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<!--<link rel="stylesheet" type="text/css" href="estilos_exp.css">-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/comisiones.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap.min.css">
	<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	<!--<script language="JavaScript" src="tools.js"></script>-->
	<script language="JavaScript" src="crypto.js"></script>
	<script type="text/javascript">
		function gerURL(){
			return "<%=request.getContextPath() %>";
		}
		
		function window_onload(form) {
				form.usuario.value="";
				form.password.value="";
		}
		function goToAceptar() {
			var pass = $('#password').val() + '/&';
			$('#pass').val(encriptar(pass));
			$('#password').val($('pass').val);
		}
		
	</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="3" marginwidth="0" marginheight="0">
	
	<div id="head" class="container-fluid">
			<img style="float: left; margin-top: 11px; margin-right: 17px;" border="0"	src="<%=request.getContextPath() %>/images/comisiones/att_header.png" width="58" height="58">
		<h2>Comisiones</h2>
		<h2><small>Bienvenido</small></h2>
	</div>

	<div id="content" class="container-fluid">

		<form onsubmit="return startStatusCheck();" class="form-horizontal" role="form"
			action="<%=request.getContextPath()%>/LoginAction.do" name="form" method="post">
			<input name="password" id="pass" type="hidden" class="form-control"/>	
			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Usuario:</label>
				<div class="col-sm-2">
					<input name="usuario" id="usuario" type="text" maxlength="10" 
						size="25"  class="form-control"/>					
			    </div>
				<div class="col-sm-8">			
			    </div>
			</div>

			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Contraseña:</label>
				<div class="col-sm-2">
					<input name="password" id="password" type="password" 
						onkeypress="return(keyDown(event))" maxlength="50" size="25"  class="form-control"/>									
			    </div>
				<div class="col-sm-8">
		        	<input type="submit" name="btnSubmit1" id="btnSubmit1" class="btn btn-default cssButton"
						value="Entrar" alt="Entrar" onclick="goToAceptar()"/>
		      	</div>
			</div>
		</form>
		<ul>
	    	<li><font size="1">Recuerda que tu clave de usuario y contraseña son únicas e intransferibles.</font></li>
	    	<li><font size="1">Es importante que renueves tu contraseña cada 90 días.</font></li>
	    	<li><font size="1">Las actividades realizadas dentro del sistema serán registradas y monitoreadas, para efectos legales, por lo que el responsable del usuario y contraseña que sea ingresado será responsable por el manejo de la información ahí contenida.</font></li>
	  	</ul>
	</div>
</body>

</html>


