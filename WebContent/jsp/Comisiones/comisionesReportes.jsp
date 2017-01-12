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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap.min.css"/>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-ui-1.11.1/jquery-ui.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/comisiones/dateFormat.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/comisionesReportes.js"></script>
		<script type="text/javascript">
			function getURL(){
				return "<%=request.getContextPath() %>";
			}
			
			function getSemana(){
				return '<bean:write name="semana" />';
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
				<input style="display: none;" id="semana" name="semana" value='<bean:write name="semana" />' />
				<div class="form-group">
				  	<label for="radioMes" class="control-label col-sm-4 radio-inline">Reportes Mensuales:
				  		<input type="radio" id="radioMes" name="mesSemana" style="width: initial;margin-left: 10px;" value="0">
				  	</label>
				    <label for="radioSemana" class="control-label col-sm-4 radio-inline">Reportes Semanales:
				    	<input type="radio" id="radioSemana" name="mesSemana" style="width: initial;margin-left: 10px;" value="1">
				    </label>
				    <div class="col-sm-4"></div>
				</div>
				<div class="form-group">
				  	<label for="anio" class="control-label col-sm-2">TipoReporte:</label>
					<div class="col-sm-10">
						<select id="tipoMes" name="tipoMes" class="form-control" style="width: initial;">
					  		<option class="uno" value="-1">--Seleccione una opción--</option>
					  		<option class="dos" value="1">ACTIVACIONES</option>
					  		<option class="uno" value="2">RENOVACIONES</option>
					  		<option class="dos" value="3">CHARGE_BACK_POSPAGO</option>
					  		<option class="uno" value="4">CHARGE_BACK_RENOV_POSPAGO</option>
					  		<option class="dos" value="5">COM_DIFERIDA_ACTIVACIONES_KYH</option>
					  		<option class="uno" value="6">COM_DIFERIDA_RENOVACIONES_KYH</option>
					  		<option class="dos" value="7">DESCUENTOS_MULTILINEA</option>
					  		<option class="uno" value="8">DESCUENTOS_ADICIONAL</option>
					  		<option class="dos" value="9">DCTOS_MULTILINEA_TOTALES</option>
					  		<option class="uno" value="10">DCTOS_ADICIONAL_TOTALES</option>
					  		<option class="dos" value="11">PREPAGO_EQ_NUEVO</option>
					  		<option class="uno" value="12">PREPAGO_EQ_CAJON</option>
					  		<option class="dos" value="13">COBRANZA</option>
					  		<option class="uno" value="14">CAES_ARSA</option>
					  		<option class="dos" value="15">ADONS</option>
					  		<option class="uno" value="16">MOVIMIENTOS_ADONS</option>
					  		<option class="dos" value="17">BAJAS_ADMINISTRATIVAS</option>
					  		<option class="uno" value="18">REPORTE_RESIDUALES</option>
					  	</select>
					  	<select id="tipoSemana" name="tipoSemana" class="form-control" style="width: initial; display: none;">
					  		<option class="uno" value="-1">--Seleccione una opción--</option>
					  		<option class="dos" value="1">ACTIVACIONES</option>
					  		<option class="uno" value="2">RENOVACIONES</option>
					  		<option class="dos" value="3">BAJAS_ACTIVACIONES</option>
					  		<option class="uno" value="4">BAJAS_RENOVACIONES</option>
					  		<option class="dos" value="5">COBRANZA</option>
					  		<option class="uno" value="6">PREPAGO</option>
					  		<option class="dos" value="7">REPORTE_PORTABILIDAD</option>
					  	</select>								
				    </div>
				</div>
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
						<select id="periodo" name="periodo" class="form-control" style="width: initial; display: none;">
					  		<option class="uno" value="-1">--Seleccione una opción--</option>
					  	</select>
					  	<select id="mesPeriodo" name="mesPeriodo" class="form-control" style="width: initial;">
					  		<option class="uno" value="-1">--Seleccione una opción--</option>
					  	</select>							
				    </div>
					<div class="col-sm-2">

					</div>
					<div class="col-sm-2">
						<input type="button" style='margin-top: 10px' class='cssButtonRedInd btn btn-default cssButton' id="exportar" value="Exportar a Excel"/>
					</div>
					<div class="col-sm-3">

					</div>
				</div>
				<div id="tbldivComisiones" class="form-group text-center">
					<div id="tblResult" class="form-group text-center">
						<div id="divtblCon" class="container-fluid table-responsive" style="font-size: 11px;">
							<table id="resultados" class="table table-bordered table-hover table-condensed" >
								<thead><tr class="titulo_colum_arh"></tr></thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
