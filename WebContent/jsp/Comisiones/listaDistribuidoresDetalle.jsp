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
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-ui-1.11.1/jquery-ui.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/comisiones/dateFormat.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/comisiones.js"></script>
		<script type="text/javascript">
			function getURL(){
				return "<%=request.getContextPath() %>";
			}

			function getSemana(){
				return '<bean:write name="semana" />';
			}
			
			function getPublicado(){
				return '<bean:write name="publicado" />';
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
					<div class="col-sm-1"></div>
					<label for="anioD" class="control-label col-sm-1" style="text-align: left;">Año: </label>
					<label for="anioD" id="anioD" class="control-label col-sm-2" style="text-align: left;"><bean:write name="anioD" /></label>
					<label for="semanaD" class="control-label col-sm-1" style="text-align: left;">Semana: </label>
					<label for="semanaD" id="semanaD" class="control-label col-sm-2" style="text-align: left;"><bean:write name="semanaD" /></label>
					<label for="mesD" class="control-label col-sm-1" style="text-align: left;">Mes: </label>
					<label for="mesD" id="mesD" class="control-label col-sm-2" style="text-align: left;"><bean:write name="mesD" /></label>
					<div class="col-sm-1">
						<a style="color: blue; font-size: large;" href="<%=request.getContextPath() %>/comisionesDis.do?go=inicio">Regresar.</a>
						<label for="periodoD" id="periodoD" style="text-align: left; display: none;"><bean:write name="periodoD" /></label>
					</div>
					<div class="col-sm-1"></div>
				</div>
				<div class="form-group">
					<div class="col-sm-1">
					</div>
					<div class="col-sm-2">
						<input type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' id="eliminar" value="Eliminar"/>
					</div>
					<div class="col-sm-2">
						<input type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' id="reprocesar" value="Re-Procesar"/>
					</div>
					<div class="col-sm-4">
					</div>
					<div class="col-sm-2" align="right">
						<input type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' id="agregar" value="Agregar"/>
					</div>
					<div class="col-sm-1" style="padding-top: 15px;">
					</div>
				</div>
				<div id="tbldivComisiones" class="form-group text-center">
					<div id="divtblCon" class="container-fluid" style="font-size: 11px; width: 1100px;">
						<table id="tblComisionesDetalle" class='contenedor_tabla table table-bordered table-hover table-condensed' >
							<thead>
								
								<tr>
									<th class='titulo_colum_arh' style="text-align: center;width: 64px;">Eliminar</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 77px;">Clave Canal</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 76px;">Mes Activ</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 84px;">Semana Venta</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 86px;">Contrato</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 109px;">ESN</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 65px;">Telefono</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 77px;">Fecha Activ</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 57px;">Plazo</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 65px;">Comision</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 57px;">Renta</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 110px;">Desc Multimedia</th>
									<th class='titulo_colum_arh' style="text-align: center;width: 110px;">Desc Adicional</th>
								</tr>
							</thead>
							<tbody>
								<logic:iterate name="listaDetalle" id="detalleVO" >
									<tr>
										<td style="width: 64px;"><input type='checkbox' name='<bean:write name="detalleVO"  property="contrato" />' value='<bean:write name="detalleVO"  property="contrato" />' ></td>
										<td style="width: 77px;"><bean:write name="detalleVO"  property="cveCanal" /></td>
										<td style="width: 76px;"><bean:write name="detalleVO"  property="mesActiv" /></td>
										<td style="width: 84px;"><bean:write name="detalleVO"  property="semanaVenta" /></td>
										<td style="width: 86px;"><bean:write name="detalleVO"  property="contrato" /></td>
										<td style="width: 109px;"><bean:write name="detalleVO"  property="esn" /></td>
										<td style="width: 65px;"><bean:write name="detalleVO"  property="telefono" /></td>
										<td style="width: 77px;"><bean:write name="detalleVO"  property="fechaActiv" /></td>
										<td style="width: 57px;"><bean:write name="detalleVO"  property="plazo" /></td>
										<td style="width: 65px;"><bean:write name="detalleVO"  property="comision" /></td>
										<td style="width: 57px;"><bean:write name="detalleVO"  property="renta" /></td>
										<td style="width: 110px;"><bean:write name="detalleVO"  property="descMultimedia" /></td>
										<td style="width: 110px;"><bean:write name="detalleVO"  property="descAdicional" /></td>
									</tr>
								</logic:iterate>
							</tbody>
						</table>
					</div>
				</div>
			</form>
			<div id="bockPantallaAgregar" class="cssBlockPantalla" style="display: none;"></div>
			<div id="agreComisiones" class="cssMensaje" style="border-radius: 10px; left: 50%; margin: 0 0 0 -300px; top: 25%; width: 600px;display: none;">
				<div id="msjCabeceraComisiones" class="cssMsjCabecera">
					<span class="cssAlerta">
						<label id="mensajeTituloComisiones">Agregar</label>
					</span>
				</div>
				<div id="msjMensajeComisiones" class="cssTxtMensaje" style="overflow-y: auto;">
					<div id="cuerpoEditar" style="height: 150px;">
						<table class="texto_arh_gris_9pt" style="padding-left: 10px;width: 99%;">
							<tr style="padding:5px;">
								<td><label>Contrato:</label></td>
								<td><input type="text" id="contrato" name="contrato" class="text_big" 
										maxlength="127" style="text-align: left; width: 230px;font-size: 8pt;"
										onkeypress="return validaContrato(event);"/></td>
							</tr>
						</table>
						<br>
						<input type="button"  id="bbuscarComisiones" class='cssButtonRedInd btn btn-default cssButton' value="Buscar" />
						<br>
						<table id="tblComisionesAgregar" class='contenedor_tabla' style="width: 100%">
							<thead>
								<tr>
									<th align='center' class='titulo_colum_arh'>Tipo Venta</th>
									<th align='center' class='titulo_colum_arh'>Contrato</th>
									<th align='center' class='titulo_colum_arh'>Fecha</th>
									<th align='center' class='titulo_colum_arh'>Cve Canal</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
						</div>
						<br>
						<input type="button"  id="bCancelarComisiones" class='cssButtonRedInd btn btn-default cssButton' onclick="$('#agreComisiones').hide();$('#bockPantallaAgregar').hide();return false;" value="Cancelar"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button"  id="bAgregarComisiones" class='cssButtonRedInd btn btn-default cssButton' value="Agregar"/>
						<div id="cargando" class="load"><img alt="cargando" src="<%=request.getContextPath() %>/gifs/comisiones/ajax-loader.gif"/></div>
				</div>
				<div id="msjBotonesEmpresa"></div>
	 		</div>
		</div>
	</body>
</html>
