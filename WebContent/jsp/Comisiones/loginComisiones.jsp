<!DOCTYPE html>
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<META name="GENERATOR" content="IBM Software Development Platform">
		<title>Distribuidores</title>
		
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/comisiones.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/cambioLookFeel.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap.min.css">
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-filestyle.js"></script>
		<script type="text/javascript">
			function gerURL(){
				return "<%=request.getContextPath() %>";
			}
		</script>
</head>
<body>
	<div id="head" class="container-fluid">
		<img style="float: left; margin-top: 11px; margin-right: 17px;" border="0"	src="<%=request.getContextPath() %>/images/comisiones/att_header.png" width="58" height="58">
		<h2>Comisiones</h2>
		<h2><small>Sistema de carga de archivos.</small></h2>
	</div>
	<div id="content" class="container-fluid">
		<form onsubmit="return startStatusCheck();" class="form-horizontal"
			action="<%=request.getContextPath()%>/cargaArchivo.do?go=cargarTxt" 
			name="form" method="post" target="target_upload" enctype="multipart/form-data" role="form" >

			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Archivo:</label>
				<div class="col-sm-10">
					<input type="text" name="archivo" id="archivo" size="40" class="filestyle"/>						
			    </div>
			</div>

			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Archivo:</label>
				<div class="col-sm-4">
					<input type="password" name="archivo" id="archivo" size="40" class="filestyle"/>						
			    </div>
				<div class="col-sm-6">
			    	  <input type="submit" name="btnSubmit1" id="btnSubmit1" class="btn btn-default cssButton"
					value="Cargar Archivo" alt="Comprobar Archivo" onclick="ejecutar()"/>
			    </div>
			</div>
			

			
		</form>
	</div>
	
	 <div  id="cargaMod" style="display: none; position:absolute; border:0px solid #666666; background-color:#ffffff; z-index:200; filter:alpha(opacity=65);
			    opacity: .65; -moz-opacity: .65; width: 100%; height: 100%; top:0px;" >
		<iframe style="position:absolute; width: 100%; height: 100%; border:0px; overflow: hidden; display: block;" src="<%= request.getContextPath() %>/jsp/clock.htm"></iframe>
	 </div>

	<div id="bockPantalla" class="cssBlockPantalla" style="display: none;"></div>	
	<div id="mensaje" class="cssMensaje" style="display: none">
		<div id="msjCabecera" class="cssMsjCabecera">
			<span class="cssAlerta">
				Alerta
			</span>
		</div>
		<div id="msjMensaje" class="cssTxtMensaje">
			<label id="mensajeAlerta" ></label>
		</div>
		<div id="msjBotones">
			<button id="bCancelar" class="cssButton" style="display: none;">Cancelar</button>
			<button id="bMensaje" class="cssButton">Aceptar</button>
		</div>
	</div>
</body>
</html>
