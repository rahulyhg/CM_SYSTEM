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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/comisiones/bootstrap-3.3.2-dist/css/bootstrap-datetimepicker.min.css">
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/jquery-1.11.1.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-3.3.2-dist/js/bootstrap-datetimepicker.min.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/bootstrap-filestyle.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/consultaArchivo.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath() %>/scripts/comisiones/FuncionesCargaArchivo.js"></script>
		<script type="text/javascript">
			function gerURL(){
				return "<%=request.getContextPath() %>";
			}
		</script>
		<style></style>
</head>
<body>
	<div id="head" class="container-fluid">
		<h2>Consultar archivos cargados</h2>
		<div>		
			<h2 style="display: inline-block;width: 80%;"><small>Seleccione los filtros de la consulta.</small></h2>
			<h3 style="display: inline-block;width: 19%;text-align: right;">
				<a href="<%=request.getContextPath() %>/LoginAction.do?action=Salir">Salir.</a>
			</h3>
		</div>
	</div>
	<div id="content" class="container-fluid">
		<form onsubmit="return startStatusCheck();" class="form-horizontal" name="form" method="post"
			action="<%=request.getContextPath()%>/cargaArchivo.do?go=cargarTxt" role="form" >
			
			<input id="pag" name="pag" type="hidden" value="1" />
			<input id="pagTotal" name="pagTotal" type="hidden" value="0" />
			<input id="datosTotal" name="datosTotal" type="hidden" value="0" />
			<input id="accion" name="accion" type="hidden" value="0" />
			<input id="perfil" name="perfil" type="hidden" value="1,2,3" />
			
			<div class="form-group">
			  	<label for="idTipoArchivo" class="control-label col-sm-2">Tipo de Archivo:</label>
				<div class="col-sm-10">
					<select class="form-control" id="idTipoArchivo" style="width: initial;">
				  		<option value="0">::Cargando::</option>
				  	</select>							
			    </div>
			</div>
			
			<div class="form-group">        
				<label for="idArchivo" class="control-label col-sm-2">Archivos Cargado:</label>
				<div class="col-sm-3">
					<select class="form-control" id="slcIdArchivo" name="slcIdArchivo" style="width: initial;">
				  		<option value="0">::Seleccione una un archivo::</option>
				  	</select>							
			    </div>
				<div class="col-sm-1">
		        	<input type="submit" name="btnSubmit1" id="btnSubmit1" class="btn btn-default cssButton" disabled
						value="Buscar" alt="Buscar" onclick="ejecutar()"/>
		      	</div>
				<div class="col-sm-1">
					<input type="submit" name="btnActualizar" id="btnActualizar" class="btn btn-default cssButton"
						value="Actualizar" alt="Actualizar" style="display: none;"/>
				</div>
				<div class="col-sm-3">
					<input type="submit" name="btnEliminar" id="btnEliminar" class="btn btn-default cssButton"
						value="Eliminar" alt="Eliminar" style="display: none;"/>
					<input type="submit" name="btnEliminarG" id="btnEliminarG" class="btn btn-default cssButton"
						value="Eliminar" alt="Eliminar" style="display: none;"/>
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
</body>
</html>
