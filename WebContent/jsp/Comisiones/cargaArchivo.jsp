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
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-filestyle.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/cargarArchivo.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/FuncionesCargaArchivo.js"></script>
		<script type="text/javascript">
			function gerURL(){
				return "<%=request.getContextPath() %>";
			}
		</script>
</head>
<body>
	<div id="head" class="container-fluid">
		<h2>Carga Archivo</h2>
		<div>		
			<h2 style="display: inline-block;width: 80%;"><small>La carga tendrá que ser a partir de un archivo con formato Excel (XLS) ó Planos (TXT).</small></h2>
			<h3 style="display: inline-block;width: 19%;text-align: right;">
				<a href="<%=request.getContextPath() %>/LoginAction.do?action=Salir">Salir.</a>
			</h3>
		</div>
	</div>
	<div id="content" class="container-fluid">
		<form onsubmit="return startStatusCheck();" class="form-horizontal"
			action="<%=request.getContextPath()%>/cargaArchivo.do?go=cargarTxt" 
			name="form" method="post" target="target_upload" enctype="multipart/form-data" role="form" >
			
			<input id="pag" name="pag" type="hidden" value="1" />
			<input id="pagTotal" name="pagTotal" type="hidden" value="0" />
			<input id="datosTotal" name="datosTotal" type="hidden" value="0" />
			<input id="accion" name="accion" type="hidden" value="0" />
			<input id="perfil" name="perfil" type="hidden" value="1,2" />
			
			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Tipo de Archivo:</label>
				<div class="col-sm-4">
					<select class="form-control" id="idTipoArchivo" style="width: initial;">
				  		<option value="0">::Cargando::</option>
				  	</select>							
			    </div>
				<div class="col-sm-6">
					<a onclick="mostrarMensajeRec(event)" href="#" title="Recomendaciones para la carga">
					<img alt="Recomendaciones" src="<%=request.getContextPath()%>/images/comisiones/1428443617_info_16.png"></a>
			    </div>
			</div>

			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Archivo:</label>
				<div class="col-sm-4">
					<input type="file" name="archivo" id="archivo" size="40" class="filestyle"/>						
			    </div>
				<div class="col-sm-2">
			    	  <input type="submit" name="btnSubmit1" id="btnSubmit1" class="btn btn-default cssButton" disabled
					value="Cargar Archivo" alt="Comprobar Archivo" onclick="ejecutar()"/>
			    </div>
				<div class="col-sm-2">
					<input type="submit" name="btnGuardar" id="btnGuardar" 
						class="btn btn-default cssButton" style="display: none;"
						value="Guardar Archivo" alt="Guardar Archivo" />
					<input type="submit" name="btnAceptarG" id="btnAceptarG" 
						class="btn btn-default cssButton" style="display: none;"
						value="Guardar Archivo" alt="Guardar Archivo" />
			    </div>
				<div class="col-sm-2">
					<input type="button" name="btnRegresar" id="btnRegresar" 
						class="btn btn-default cssButton" onclick="regresarPantalla(event)"
						value="Regresar" alt="Regresar" />
			    </div>
			</div>
			
			
			<div id="tblResult" class="form-group text-center">
				<div id="divtblCon" class="container-fluid table-responsive" style="font-size: 11px;">
					<table id="resultados" class="table table-bordered table-hover table-condensed" >
						<thead><tr class="titulo_colum_arh"></tr></thead>
						<tbody></tbody>
					</table>
				</div>
			</div>

			<div class="form-group" align="center">
			  	<input type="submit" name="primero" id="primero" value="Primero" 
					alt="Primero" class="btn btn-default cssButton" />
				<input type="submit" name="anterior" id="anterior" value="Anterior" 
					alt="Anterior" class="btn btn-default cssButton" />
				<label id="lblPaginador" class="control-label">1 de 1</label>
				<input type="submit" name="siguiente" id="siguiente" value="Siguiente" 
					alt="Siguiente" class="btn btn-default cssButton" />
				<input type="submit" name="ultimo" id="ultimo" value="Último" 
					alt="Ultimo" class="btn btn-default cssButton" />
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
	<div id="bockPantallaRec" class="cssBlockPantalla" style="display: none;"></div>	
	<div id="mensajeRec" class="cssMensaje" style="display: none">
		<div id="msjCabeceraRec" class="cssMsjCabecera">
			<span class="cssAlerta">
				Recomendaciones para la carga del archivo
			</span>
		</div>
		<div id="msjMensajeRec" class="cssTxtMensaje">
			<ul>
				<li>Los campos numericos no deben de llevar coma para los decimales si no punto. Ejemplo: 10.5</li>
				<li>Se recomienda que las fechas tengan el siguiente formato: dd/MM/yyyy.</li>
			</ul>
		</div>
		<div id="msjBotonesRec" align="right">
			<button id="bCancelarRec" class="cssButton" onclick="cancelarMostrarMensajeRec(event)">Aceptar</button>
		</div>
	</div>
</body>
</html>
