<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<META name="GENERATOR" content="IBM Software Development Platform">
		<title>Distribuidores</title>
		
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/comisiones.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/inicio.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/cambioLookFeel.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap.min.css">
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-filestyle.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/FuncionesCargaArchivo.js"></script>
		<script type="text/javascript">
			function gerURL(){
				return "<%=request.getContextPath() %>";
			}
		</script>
</head>
	<body>
		<div id="head" class="container-fluid">
			<img style="float: left; margin-top: 11px; margin-right: 17px;" border="0"	src="<%=request.getContextPath() %>/images/comisiones/att_header.png" width="58" height="58">
			<h2>Menu Comisiones</h2>
			<div>		
			<h2 style="display: inline-block;width: 80%;"><small>Seleccione una opci&oacute;n.</small></h2>
			<h3 style="display: inline-block;width: 19%;text-align: right;">
				<a href="<%=request.getContextPath() %>/LoginAction.do?action=Salir">Salir.</a>
			</h3>
		</div>
		</div>
		<div id="content">
			
			<div id="menu"><!--
				<form id="formCargar" class="form-horizontal" name="form" method="post" 
					action="<%=request.getContextPath() %>/inicioCarga.do?go=inicio" 
					role="form" >
					<input type="submit" class="btn btn-default cssButton btnMenu"
						value="Reportes" alt="Reportes" id="btnCargar" />
				</form>
				--><form id="formConsultar" class="form-horizontal" name="form" method="post"
					action="<%=request.getContextPath() %>/comisionesDis.do?go=inicio" 
					role="form" >
					<input type="submit" class="btn btn-default cssButton btnMenu"
						value="InterFactura" alt="InterFactura" id="btnConsultar"/>
				</form>
				<form id="formConsultar" class="form-horizontal" name="form" method="post"
					action="<%=request.getContextPath() %>/comisionesReportes.do?go=inicio" 
					role="form" >
					<input type="submit" class="btn btn-default cssButton btnMenu"
						value="Reportes" alt="Reportes" id="btnReportes"/>
				</form>
				<!--  a id="carga" href=>Carga</a -->
				<!-- a id="consulta" href=>Consulta</a -->
			</div>
			
		</div>
	</body>
</html>
