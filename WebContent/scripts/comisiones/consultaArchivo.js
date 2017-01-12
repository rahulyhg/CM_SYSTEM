var archivo;
var files;

$( document ).ready(function() {
	$('form').on('submit', buscaDatos);
	$('#anterior').click(anterior);
	$('#siguiente').click(siguiente);
	$('#primero').click(primero);
	$('#ultimo').click(ultimo);
	$('#idTipoArchivo').change(cambiarSelectConsulta);
	$('#slcIdArchivo').change(cambiarIdArchivo);
	$('#btnActualizar').click(ejecutarActualizar);
	$('#btnEliminar').click(mostrarMensajeEliminar);
	$('#btnEliminarG').click(ejecutarEliminar);
	/*$('#fchFecha').change(cambiarFecha);
	$('#divFecha').datetimepicker({
      format: 'dd/MM/yyyy',
      language: 'es'
    }).on('changeDate',cambiarFecha);*/
    cargarCombo();
});



function buscaDatos(event){
	
	var idTipoArchivo = $("#idTipoArchivo").val();
	var fecha = $("#fchFecha").val();
	var slcIdArchivo = $("#slcIdArchivo").val();
	if(fecha == ''){
		mostrarMensaje("Favor de seleccionar la fecha de carga del archivo.", "fchFecha");
		return false;	
	}else if(slcIdArchivo == '' || slcIdArchivo == '0'){
		mostrarMensaje("Favor de seleccionar el Id del archivo cargado.", "slcIdArchivo");
		return false;
	}

	var url = gerURL()+'/cargaArchivo.do?go=buscaArchivo'
		url += '&idTipoArchivo='+ idTipoArchivo;
		url += '&idArchivo='+ $("#slcIdArchivo").val();
		url += '&pag='+$("#pag").val();
		url += '&accion='+$("#accion").val();
		
	event.stopPropagation(); // Stop stuff happening
    event.preventDefault(); // Totally stop stuff happening
	$("#resultados tbody").empty();
	waitingGral();
	$.ajax({
		url: url,
		type: "POST",
		data: {},
		cache: false,
        processData: false, // Don't process the files
        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
		success: mostrarDatos
		});
	return false;
}

function startStatusCheck(){			
	return true;
}

function cambiarIdArchivo(){
	$('#resultados > tbody').empty();
	$('#btnActualizar').hide();
	$('#btnEliminar').hide();
}

function ejecutarActualizar(event){
	event.preventDefault();
	var url = gerURL()+'/cargaArchivo.do?go=actualizarArchivo'
		
		var fo = $('<form>',{action:gerURL()+'/cargaArchivo.do?go=actualizarArchivo',method:'post'});
		var idTipoArchivo = $('<input>',{id:'idTipoArchivo',name:'idTipoArchivo',type:'hidden',value:$("#idTipoArchivo").val()});
		var idArchivo = $('<input>',{id:'idArchivo',name:'idArchivo',type:'hidden',value:$("#slcIdArchivo").val()});
		var descTipoArchivo = $('<input>',{id:'descTipoArchivo',name:'descTipoArchivo',type:'hidden',value:$("#idTipoArchivo option:selected").text()});
		var descArchivo = $('<input>',{id:'descArchivo',name:'descArchivo',type:'hidden',value:$("#slcIdArchivo option:selected").text()});

		fo.append(idTipoArchivo);
		fo.append(idArchivo);
		fo.append(descTipoArchivo);
		fo.append(descArchivo);

		$('#content').append(fo);
		fo.submit();
}

function mostrarMensajeEliminar(){
	var men = 'Se eliminaran los datos del archivo seleccionado.';
	mostrarMensajeAction(men,"btnEliminarG")
	return false;
}

function ejecutarEliminar(event){
	event.preventDefault();
	var idTipoArchivo = $("#idTipoArchivo").val();
	var slcIdArchivo = $("#slcIdArchivo").val();
	if(slcIdArchivo == '' || slcIdArchivo == '0'){
		mostrarMensaje("Favor de seleccionar el Id del archivo cargado.", "slcIdArchivo");
		return false;
	}
	var url = gerURL()+'/cargaArchivo.do?go=eliminarArchivo'
		url += '&idTipoArchivo='+ idTipoArchivo;
		url += '&idArchivo='+ slcIdArchivo;
	waitingGral();
	$.get(url,function(data){
			var id = $(data).find("cveRespuesta").html();
			if(id == '0'){
				cambiarSelectConsulta();
				mostrarMensaje("Archivo eliminado correctamente.", "slcIdArchivo");
			}else{
				mostrarMensaje("Ocurrio un error al eliminar la información seleccionada.", "slcIdArchivo");
			}
			stopWaitingGral();
		});
}



function cambiarFecha(){
	
	var url = gerURL()+'/cargaArchivo.do?go=buscaIdArchivo'
	url += '&idTipoArchivo='+ $("#idTipoArchivo").val();
		
	$.get(url, llenarSelect);
}

function llenarSelect(data){
	var id = $(data).find("cveRespuesta").html();
	if(id == '0'){
		$('#slcIdArchivo').html("");
		$('#slcIdArchivo').append("<option value='0'>No existen archivos</option>");
	}else{
		var res = $(data).find("datos").html();		
		$('#slcIdArchivo').html("");
		$('#slcIdArchivo').append("<option value='0'>::Seleccione::</option>");
		$('#slcIdArchivo').append(res);
	}
}

function ejecutar(){
	var pag = 1;
	$("#pag").val(pag);
	$("#accion").val(10);
	$("#tblResult").scrollTop(0);
	return true;
}