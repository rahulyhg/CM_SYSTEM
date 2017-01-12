// FuncionesComisiones.js


function cargarCombo(){
	var perfil = $("#perfil").val();
	var url = gerURL()+'/cargaArchivo.do?go=buscarTiposArchivo&perfil='+perfil;
	$.getJSON(url,function(data){
		var size=data.tabla.length;
		var comboCss="uno";
		$("#idTipoArchivo").empty();
		for(var i=0; i<size; i++){
			$("#idTipoArchivo").append('<option value="'+data.tabla[i].valor +'">'+data.tabla[i].descripcion +'</option>');
		}
		if(size>0){
			$('#btnSubmit1').removeAttr('disabled');
		}
		cambiarFecha();
	}); 
}

function cambiarSelectConsulta(){
	$('#resultados > tbody').empty();
	$('#btnActualizar').hide();
	$('#btnEliminar').hide();
	cambiarFecha();
}

function cambiarSelectCarga(){
	var val = $('#idTipoArchivo').val();
	$('#resultados > tbody').empty();
    $("form").trigger('reset');
    $('#idTipoArchivo').val(val);
	$('#btnGuardar').hide();
	$('#btnActualizar').hide();
	$('#btnEliminar').hide();
}

function mostrarDatos(data){
	stopWaitingGral();
	var id = $(data).find("cveRespuesta").html();
	var res = $(data).find("datos").html();
	var tabla = $(data).find("tablaDatos").html();
	var col = $(data).find("columnas").html();
	var tam = $(data).find("tam").html();
	var pag = $(data).find("pag").html();
	var tError = $(data).find("totalError").html();
	var tamReal = $(data).find("tamReal").html();
	tabla = tabla.split(('<![CDATA[')).join('');
	tabla = tabla.split((']]>')).join('');
	res = res.split(('<![CDATA[')).join('');
	res = res.split((']]>')).join('');
	res = res.split(('|')).join(' |');
			
	if($("#accion").val()=='0'){
		$('#btnGuardar').show();
		$('#btnActualizar').show();
		$('#btnEliminar').show();
		var info = '<b>El archivo contiene:</b> '+tamReal+' filas';
		if(tError > 0 && tam > 0){
			info += '<br></br>De las <b>'+tamReal+'</b> filas se encontraron <b>'+tam+'</b> filas validas.';
		}else if(tam == 0){
			info += '<br></br><b>El archivo no contiene ninguna fila valida, favor de verificarlo.</b>';
			$('#btnGuardar').hide();
			$('#btnActualizar').hide();
			$('#btnEliminar').hide();
		}else if(tError >= 100){
			info += '<br></br><b>El archivo contiene 100 o mas errores, favor de verificar el archivo antes de guardarlo.</b>';
		}
		if(tError >= 100){
			info += '<br></br><b>Los primeros 100 errores encontrados son:</b><br></br>';
		}else if(tError > 0){
			info += '<br></br><b>Los errores encontrados son:</b><br></br>';
		}
		mostrarMensaje(info+res, "archivo");	
	}
	if($("#accion").val()!='11'){
		$("#lblPaginador").html($("#pag").val()+' de '+pag);
		$("#pagTotal").val(pag);
		$("#datosTotal").val(tam);
		$('#resultados > tbody').html("");
		$('#resultados > tbody').append(tabla);
		$('#resultados > thead').html("");
		$('#resultados > thead').append("<tr><th class='titulo_colum_arh text-center'>#</th><th class='titulo_colum_arh text-center' colspan='"+col+"'>Datos</th></tr>");	
		if($('#resultados > tbody > tr').size() > 0){
			$('#btnActualizar').show();
			$('#btnEliminar').show();
		}
	}else{
		var info = '<b>Se insertaron :</b> '+(parseInt($("#datosTotal").val())-parseInt(tError))+' filas';
		
		if(tError > 0){
			info += ' de ' +$("#datosTotal").val()+ ' filas validas.';
		}
		
		if(tError >= 1000){
			info += '<br></br><b>Los primeros 1000 errores encontrados son:</b><br></br>';
		}else if(tError > 0){
			info += '<br></br><b>Los errores encontrados son:</b><br></br>';
		}
		mostrarMensaje(info+res, "archivo");
	}
}

function mostrarMensaje(mensaje, foc){
	$('#bockPantalla').show();
	$('#mensaje').show(); 
	$('#msjMensaje').html("");
	$('#msjMensaje').append(mensaje);
	$("#bMensaje").click(function(){aceptarMostrarMensaje(foc)});
}

function aceptarMostrarMensaje(foc){
	$('#mensaje').hide();
	$('#bockPantalla').hide();
	$('#'+foc).focus();
	$("#bMensaje").off();
}

function mostrarMensajeAction(mensaje, idClick){
	$('#bockPantalla').show();
	$('#mensaje').show(); 
	$('#bCancelar').show(); 
	$('#msjMensaje').html("");
	$('#msjMensaje').append(mensaje);
	$("#bMensaje").click(function(){aceptarMostrarMensajeClick(idClick)});
	$("#bCancelar").click(function(){aceptarMostrarMensaje()});
}

function aceptarMostrarMensajeClick(idClick){
	$('#mensaje').hide();
	$('#bockPantalla').hide();
	$('#'+idClick).click();
	$("#bMensaje").off();
	$("#bCancelar").off();
	$('#bCancelar').hide(); 
}

function siguiente(){
	var pag = parseInt($("#pag").val());
	var pagT = parseInt($("#pagTotal").val());
	if(pag >= pagT){
		return false;
	}
	$("#pag").val(pag+1);
	$("#accion").val(1);
	$("#tblResult").scrollTop(0);
	return true;
}

function anterior(){
	var pag = parseInt($("#pag").val());
	if(pag == 1){
		return false;
	}
	$("#pag").val(pag-1);
	$("#accion").val(2);
	$("#tblResult").scrollTop(0);
	return true;
}

function primero(){
	var pag = parseInt($("#pag").val());
	if(pag == 1){
		return false;
	}
	$("#pag").val(1);
	$("#accion").val(3);
	$("#tblResult").scrollTop(0);
	return true;
}

function ultimo(){
	var pag = parseInt($("#pag").val());
	var pagT = parseInt($("#pagTotal").val());
	if(pag >= pagT){
		return false;
	}
	$("#pag").val(pagT);
	$("#accion").val(4);
	$("#tblResult").scrollTop(0);
	return true;
}

function waitingGral(){
	document.getElementById('cargaMod').style.height=screen.availHeight-100;
	document.getElementById('cargaMod').style.width=screen.availWidth+"px";
	document.getElementById('cargaMod').style.display=""; //hmm_12042012

}

function stopWaitingGral(){
	document.getElementById('cargaMod').style.display="none"; //yoc_04092014
}

function regresarPantalla(event){
	event.preventDefault();
	history.back(1);
}

function cancelarMostrarMensajeRec(event){
	event.preventDefault();
	$('#mensajeRec').hide();
	$('#bockPantallaRec').hide();
}

function mostrarMensajeRec(event){
	event.preventDefault();
	$('#mensajeRec').show();
	$('#bockPantallaRec').show();
}