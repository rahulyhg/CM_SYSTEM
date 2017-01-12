<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<META name="GENERATOR" content="IBM Software Development Platform">
		<title>Distribuidores</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/comisiones.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/cambioLookFeel.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/sweetalert.css"/>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-ui-1.11.1/jquery-ui.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/comisiones/dateFormat.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/comisiones.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/sweetalert.min.js"></script>
		<script type="text/javascript">
			function getURL(){
				return "<%=request.getContextPath() %>";
			}

			function getSemana(){
				return '<bean:write name="semana" />';
			}
			
			function getPublicado(){
				return '';
			}

		</script>
</head>
	<body>
		<div id="head" class="container-fluid">
			<img style="float: left; margin-top: 11px; margin-right: 17px;" border="0"	src="<%=request.getContextPath() %>/images/comisiones/att_header.png" width="58" height="58">
			<h2>Comisiones</h2>
			<div>		
				<h2 style="display: inline-block;width: 80%;"><small></small></h2>
				<h3 style="display: inline-block;width: 19%;text-align: right;">
					<a href="<%=request.getContextPath() %>/LoginAction.do?action=Salir">Salir.</a>
				</h3>
			</div>
		</div>
		<div id="content" class="container-fluid">
			<form action="<%=request.getContextPath() %>/generarReporte.do" method="post" enctype="multipart/form-data" class="form-horizontal">
				<input style="display: none;" id="semana" name="semana" value='<bean:write name="semana" />'/>
				<div class="form-group">
				  	<label for="anio" class="control-label col-sm-2">Año:</label>
					<div class="col-sm-10">
						<select id="anio" name="anio" class="form-control" style="width: initial;">
					  		<option class="uno" value="2014" selected="selected">2014</option>
							<option class="dos" value="2013">2013</option>
							<option class="uno" value="2012">2012</option>
					  	</select>							
				    </div>
				</div>
				<div class="form-group">
				  	<label for="periodo" class="control-label col-sm-2">Periodo:</label>
					<div class="col-sm-3">
						<select id="periodo" name="periodo" class="form-control" style="width: initial;">
					  		<option class="uno" value="-1">--Seleccione una opción--</option>
					  	</select>							
				    </div>
					<div class="col-sm-2">
						<input id="detalle" type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' value="Detalle"/>
					</div>
					<div class="col-sm-2">
						<input type="button" style='margin-top: 10px; display: none;' class='cssButtonRedInd btn btn-default cssButton' id="buscar" value="Buscar"/>
						<input type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' id="exportar" value="Exportar a Excel"/>
					</div>
					<div class="col-sm-3">
						<input type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' id="publicar" value="Publicar"/>
					</div>
				</div>
				<div id="tbldivComisiones" class="form-group text-center">
					<div id="divtblCon" class="container-fluid" style="font-size: 11px;">
						<table id="tblComisiones" class='contenedor_tabla table table-bordered table-hover table-condensed' >
							<thead>
								<tr>
									<th class='titulo_colum_arh'  rowspan="2" style="width: 44px;text-align: center;">Publicar</th>
									<th class='titulo_colum_arh'  rowspan="2" style="width: 60px;text-align: center;">Status</th>
									<th class='titulo_colum_arh'  colspan="2" style="text-align: center;">Distribuidor</th>
									<th class='titulo_colum_arh'  colspan="2" style="text-align: center;">Activaciones</th>
									<th class='titulo_colum_arh'  colspan="2" style="text-align: center;">Renovaciones</th>
									<th class='titulo_colum_arh'  colspan="2" style="text-align: center;">Total</th>
								</tr>
								<tr>
									<th class='titulo_colum_arh' style="width: 60px;text-align: center;">Clave</th>
									<th class='titulo_colum_arh' style="width: 210px;text-align: center;">Descripcion</th>
									<th class='titulo_colum_arh' style="width: 80px;text-align: center;">Cantidad</th>
									<th class='titulo_colum_arh' style="width: 100px;text-align: center;">Monto</th>
									<th class='titulo_colum_arh' style="width: 80px;text-align: center;">Cantidad</th>
									<th class='titulo_colum_arh' style="width: 100px;text-align: center;">Monto</th>
									<th class='titulo_colum_arh' style="width: 80px;text-align: center;">Cantidad</th>
									<th class='titulo_colum_arh' style="width: 100px;text-align: center;">Monto</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
				<div id="bockPantallaAgregar" class="cssBlockPantalla" style="display: none;"></div>	
				<div id="pantallaAgregar" class="cssMensaje" style="display: none">
					<div id="msjAgregar" class="cssMsjCabecera">
						<span class="cssAlerta">
							Agregar
						</span>
					</div>
					<div id="msjMensaje" class="cssTxtMensaje">
						<img src='<%=request.getContextPath() %>/images/lookfeel/warning.png' alt="">
						<label id="mensajeAlerta"></label>
						<br><br>
						<button id="bMensaje" class="cssButton" onclick="$('#mensaje').hide();$('#bockPantalla').hide();">Aceptar</button>
					</div>
					<div id="msjBotones"></div>
				</div> 
			</form>
			<div id="bockPantallaAgregar" class="cssBlockPantalla" style="display: none;"></div>
			<div id="agreComisiones" class="cssMensaje" style="display: none; width: 600px; left: 439px;border-radius: 10px; top: 70px;">
				<div id="msjCabeceraComisiones" class="cssMsjCabecera">
					<span class="cssAlerta">
						<label id="mensajeTituloComisiones">Agregar</label>
					</span>
				</div>
				<div id="msjMensajeComisiones" class="cssTxtMensaje" style="overflow-y: auto;">
					<div id="cuerpoEditar">
						<table class="texto_arh_gris_9pt" style="padding-left: 10px;width: 99%;">
							<tr style="padding:5px;">
								<td><label>Distribuidor:</label></td>
								<td><input type="text" id="distribuidor" name="distribuidor" class="text_big" maxlength="5" style="text-align: left; width: 50px;font-size: 8pt;" disabled="disabled"/></td>
							</tr>
							<tr style="padding:5px;"></tr>
							<tr style="padding:5px;">
								<td><label>Contrato:</label></td>
								<td><input type="text" id="contrato" name="contrato" class="text_big" 
										maxlength="127" style="text-align: left; width: 230px;font-size: 8pt;"
										onkeypress="return validaContrato(event);"/></td>
							</tr>
							<tr style="padding:5px;">
								<td><label>Fecha:</label></td>
								<td>
									<input type="text" id="fchDate" name="fchDate" class="text_big" style="text-align: left; width: 90px;font-size: 8pt;" disabled="disabled"/>
									<input type="text" id="fecha" name="fecha" style="display: none;"/>
								</td>
							</tr>
						</table>
						<br>
						<button id="bbuscarComisiones" class="cssButton">Buscar</button>
						<br>
						<table id="tblComisionesAgregar" class='contenedor_tabla' >
							<thead>
								<tr>
									<th align='center' class='titulo_colum_arh'  style="width: 80px;">Acción</th>
									<th align='center' class='titulo_colum_arh'  style="width: 90px;">Contrato</th>
									<th align='center' class='titulo_colum_arh'  style="width: 120px;">Fecha</th>
									<th align='center' class='titulo_colum_arh'  style="width: 90px;">Esn</th>
									<th align='center' class='titulo_colum_arh'  style="width: 90px;">Mdn</th>
									<th align='center' class='titulo_colum_arh'  style="width: 90px;">Status</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
						</div>
						<br>
						<button id="bCancelarComisiones" class="cssButton" onclick="$('#agreComisiones').hide();$('#bockPantallaAgregar').hide();return false;">Cancelar</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button id="bAgregarComisiones" class="cssButton">Agregar</button>
						<button id="bEliminarComisiones" class="cssButton">Eliminar</button>
				</div>
				<div id="msjBotonesEmpresa"></div>
	 		</div>
		</div>
	</body>
</html>
