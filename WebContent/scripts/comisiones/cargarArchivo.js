var archivo;
var files;

$( document ).ready(function() {
	$( ":file" ).on('change', prepareUpload);
	$('form').on('submit', uploadFiles);
	$('#anterior').click(anterior);
	$('#siguiente').click(siguiente);
	$('#primero').click(primero);
	$('#ultimo').click(ultimo);
	$('#btnGuardar').click(mostrarMensajeGuardar);
	$('#btnAceptarG').click(ejecutarGuardar);
	$('#btnActualizar').click(mostrarMensajeActualizar);
	$('#btnActualizarG').click(ejecutarActualizar);
	$('#idTipoArchivo').change(cambiarSelectCarga);
	$(":file").filestyle({buttonText: "Find file"});
	cargarCombo();
});

function prepareUpload(event){
  $('#resultados > tbody').empty();
  files = event.target.files;
  archivo = document.getElementById("archivo");
  $('#btnGuardar').hide();
  $('#btnActualizar').hide();
}

function ValidaCarga(file,ext){	
 
	extArray = new Array(ext); 
	allowSubmit = false; 
			
	if (!file) return; 
	while (file.indexOf("\\") != -1) file = file.slice(file.indexOf("\\") + 1); 
		ext = file.slice(file.indexOf(".")).toLowerCase(); 
			
	n=file.split("."); 
			
	for(var x = 0 ; x < n.length ; x++){
		ext = n[x];
	}
			
	for (var i = 0; i < extArray.length; i++) { 
		if (extArray[i] == ext) { 
			return true;
		} 
	} 	
	return false;
			
}

function uploadFiles(event){
	var idArchivo = 0;
	if(archivo==null || archivo.value==undefined ||archivo.value==""){
		mostrarMensaje("Selecciona un Archivo", "archivo");
		return false;
	}
	if($("#idArchivo").size()>0){
		idArchivo = $("#idArchivo").val();
	}
	var valTxt = ValidaCarga(archivo.value,"txt");
	var valExcel = ValidaCarga(archivo.value,"xls");
	if(valTxt || valExcel){ 
		var metodo = '';
		if(valTxt){metodo = 'cargarTxt';}else{metodo = 'cargarExcel'}
		var url = gerURL()+'/cargaArchivo.do?go='+metodo;
			url += '&idTipoArchivo='+$("#idTipoArchivo").val();
			url += '&pag='+$("#pag").val();
			url += '&accion='+$("#accion").val();
			url += '&idArchivo='+idArchivo;
		event.stopPropagation(); // Stop stuff happening
	    event.preventDefault(); // Totally stop stuff happening
			 
		var data = new FormData();
		$.each(files, function(key, value){
			data.append('archivo', value);
		});
		if($("#accion").val()!='11'){
			$("#resultados tbody").empty();		
		}
		waitingGral();
		$.ajax({
			url: url,
			type: "POST",
			data: data,
			cache: false,
	        processData: false, // Don't process the files
	        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
			success: mostrarDatos,
			});
		return true;
	}else{ 
		mostrarMensaje("La extensi\u00F3n del archivo es incorrecta, ya que debe de ser .xls o .txt", "archivo");
		return false;
	}
}



function startStatusCheck(){			
	if(archivo==null || archivo.value==undefined ||archivo.value==""){
		mostrarMensaje("Selecciona un Archivo", "archivo");
		return false;
	}
	if(ValidaCarga(archivo.value)){ 
		var url = getUrl();
		//var aT = $(archivo).prop('files')[0];
		//waitingGral();
		//$.get(url, {archivo:archivo}, mostrarDatos);
		return false;
	}else{ 
		return false;
	}
}

function ejecutar(){
	var pag = 1;
	$("#pag").val(pag);
	$("#accion").val(0);
	$("#tblResult").scrollTop(0);
	return true;
}

function ejecutarGuardar(){
	var pag = 1;
	$("#pag").val(pag);
	$("#accion").val(11);
	$("#tblResult").scrollTop(0);
	return true;
}

function ejecutarActualizar(){
	var pag = 1;
	$("#pag").val(pag);
	$("#accion").val(11);
	$("#tblResult").scrollTop(0);
	return true;
}

function mostrarMensajeGuardar(){
	waitingGral();
	var url = gerURL()+'/cargaArchivo.do?go=validarCargado';
		url += '&idTipoArchivo='+$("#idTipoArchivo").val();
	$.get(url,function(data){
		var id = $(data).find("cveRespuesta").html();
			if(id == '-1'){
				var men = 'Se cargara un nuevo archivo con <b>'+$("#datosTotal").val()+'</b> filas validas encontradas en el archivo.';
				mostrarMensajeAction(men,"btnAceptarG");
			}else{
				var men = '<b>Ya se ha cargado un archivo hoy</b>.<br><br> Se cargara un nuevo archivo con <b>'+$("#datosTotal").val()+'</b> filas validas encontradas en el archivo.';
				mostrarMensajeAction(men,"btnAceptarG")
			}
			stopWaitingGral();
	});
	
	return false;
}

function mostrarMensajeActualizar(){
	var men = 'Se cargaran las <b>'+$("#datosTotal").val()+'</b> filas validas encontradas en el archivo y se borrará la información que fue cargada anterior mente.';
	mostrarMensajeAction(men,"btnActualizarG")
	return false;
}