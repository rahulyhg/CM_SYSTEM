// comisiones.js

var $j = jQuery.noConflict(true);
var semAct;
var pub;
var pathUrl;

$j(document).ready(function(){
	
	semAct = getSemana();
	pathUrl = getURL();
	pub = getPublicado();

	try {
	   if(semAct!=$j("#semanaD").text()){
			$j('#eliminar,#agregar,#reprocesar,table input').hide();
		}
		if (pub == '1'){
			$j('#eliminar,#agregar,#reprocesar,table input').hide();			
		}
	}
	catch(err) {
	    //document.getElementById("demo").innerHTML = err.message;
	}

	//Estilos
	var urlCss = 'scripts/comisiones/jquery-ui-1.11.1/jquery-ui.css';
	$j.get(urlCss, function (styleCode){
		var variables = { '{$jurlPat}': 'images/comisiones' };
		
		$j.each(variables, function (key,value){
			styleCode = styleCode.split(key).join(value);
		});

		var elStyle = document.createElement('style');
		elStyle.innerHTML = styleCode;

		document.getElementsByTagName('head')[0].appendChild(elStyle);
	});
	
	//Calendarios
	$j( "#fchDate" ).datepicker({
		buttonImage: "images/calendario.gif",
		buttonImageOnly: true,
		showOn: "button",
		changeMonth: true,
		changeYear: true,
		dateFormat: "dd/mm/yy",
		buttonText: "Selecciona una fecha",
		monthNamesShort: [ "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" ]
	});

	var rutaFormacion= pathUrl+"/json/comisionesDis.do?go=anio";
	$j.getJSON(rutaFormacion,function(data){
		var size=data.tabla.length;
		var comboCss="uno";
		$j("#anio").empty();
		for(var i=0; i<size; i++){
			if(i%2==0)
				comboCss='dos';
			else
				comboCss='uno';	
			
			if(data.tabla[i].valor == (new Date()).getFullYear()){
				$j("#anio").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;" selected>'+data.tabla[i].descripcion +'</option>');
			}else{
				$j("#anio").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
			} 
		}
		
	}); 

	var rutaFormacionp= pathUrl+"/json/comisionesDis.do?go=periodo";
	$j.getJSON(rutaFormacionp,function(data){
		if(data.tabla !== undefined){
			var size=data.tabla.length;
			var comboCss="uno";
			$j("#periodo").empty();
			$j("#periodo").append('<option class="'+ comboCss+ '" value="-1"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">--Seleccione una opción--</option>');
			for(var i=0; i<size; i++){
				if(i%2==0)
					comboCss='dos';
				else
					comboCss='uno';	
				if(i==0){
					$j("#periodo").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
				}else{
					$j("#periodo").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
				} 
			}
		}
	}); 
	
	$j("#anio").change(function (){
		var rutaFormaciona= pathUrl+"/json/comisionesDis.do?go=periodo";
		var anio = $j("#anio").val();
		var comboCss="uno";
		$j("#periodo").empty();
		$j("#periodo").append('<option class="'+ comboCss+ '" value="-1"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">--Seleccione una opción--</option>');
		$j('#tblComisiones > tbody').empty();
		$j.getJSON(rutaFormaciona,{anio: anio},function(data){
			var size=data.tabla.length;
			for(var i=0; i<size; i++){
				if(i%2==0)
					comboCss='dos';
				else
					comboCss='uno';	
				if(i==0){
					$j("#periodo").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
				}else{
					$j("#periodo").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
				} 
			}
		}); 
	});
	
	$j("#periodo").change(function (){
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
		if(periodo != "" && periodo != "-1"){
			$j("#buscar").click();
		}
	});
	
	$j("#buscar").click(function (){
		var rutaFormacionb= pathUrl+"/json/comisionesDis.do?go=buscar";
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
		if(periodo == "" || periodo == "-1"){
			alert("Debe de seleccionar el periodo.");
		}else{
			$j.getJSON(rutaFormacionb,{anio: anio, periodo: periodo},function(data){
				$j('#tblComisiones > tbody').empty();
				var semanaSeleccionada = $j('#periodo').val().substr(0,1);
				if(semAct!=semanaSeleccionada){
					$j('#publicar,table input').hide();
				}
				var totalActCantidad = 0.0;
				var totalActMonto = 0.0;
				var totalRenCantidad = 0.0;
				var totalRenMonto = 0.0;
				var totalTotCantidad = 0.0;
				var totalTotMonto = 0.0;
				var size=data.tabla.length;
				var comboCss="uno";
				for(var i=0; i<size; i++){
					data.tabla[i].valor;
					var status = "";
					var desabilitado = "";
					var check = "";
					var desAgregar = "";
					var acciones = true;
					if(data.tabla[i].status == '3'){
						status = "<b>Publicado</b>";
						desabilitado = "disabled";
						check = "";
						acciones = false;
					}else{
						status = "<b>Sin publicar</b>";
					}
					
					if(data.tabla[i].semana=="-1"){
						acciones = false;	
					}
					
					fila = "<tr>";
					fila += "<td><input type='checkbox' name='"+data.tabla[i].claveDistribuidor+"' value="+data.tabla[i].claveDistribuidor+" "+desabilitado+"></td>";
					fila += "<td>"+status+"</td>";
					fila += "<td>"+data.tabla[i].claveDistribuidor+"</td>";
					fila += "<td>"+data.tabla[i].descDistribuidor+"</td>";
					fila += "<td>"+data.tabla[i].activacionesCantidad+"</td>";
					fila += "<td>$"+data.tabla[i].activacionesMonto+"</td>";
					fila += "<td>"+data.tabla[i].renovacionesCantidad+"</td>";
					fila += "<td>$"+data.tabla[i].renovacionesMonto+"</td>";
					fila += "<td>"+data.tabla[i].totalesCantidad+"</td>";
					fila += "<td>$"+data.tabla[i].totalesMonto+"</td>";
					fila += "</tr>";
					$j('#tblComisiones > tbody').append(fila);
					
					totalActCantidad += parseFloat(data.tabla[i].activacionesCantidad);
					totalActMonto += parseFloat(data.tabla[i].activacionesMonto);
					totalRenCantidad += parseFloat(data.tabla[i].renovacionesCantidad);
					totalRenMonto += parseFloat(data.tabla[i].renovacionesMonto);
					totalTotCantidad += parseFloat(data.tabla[i].totalesCantidad);
					totalTotMonto += parseFloat(data.tabla[i].totalesMonto);
				}
				
				fila = "<tr>";
				fila += "<td></td>";
				fila += "<td></td>";
				fila += "<td></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>Totales:</b></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>"+totalActCantidad+"</b></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>$"+Math.round(totalActMonto*100)/100+"</b></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>"+totalRenCantidad+"</b></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>$"+Math.round(totalRenMonto*100)/100+"</b></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>"+totalTotCantidad+"</b></td>";
				fila += "<td style='border-top: 1px solid rgb(0, 0, 0);' ><b>$"+Math.round(totalTotMonto*100)/100+"</b></td>";
				fila += "</tr>";
				$j('#tblComisiones > tbody').append(fila);
				if(semAct!=semanaSeleccionada){
					$j('#publicar,table input').hide();
				}else{
					$j('#publicar,table input').show();				
				}
			});		
		}
		 
	});
	
	$j("#exportar").click(function (){
		var rutaFormacione= pathUrl+"/json/comisionesDis.do?go=buscarExportar";
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
		if(periodo == "" || periodo == "-1"){
			alert("Debe de seleccionar el periodo.");
		}else{
			$j.getJSON(rutaFormacione,{anio: anio, periodo: periodo},function(data){
				var size=data.tabla;
				if(size > 0){
					var  rutaAux= pathUrl+"/comisionesDis.do?go=exportar&anio="+anio+"&periodo="+periodo;
					$j( "form" ).attr("method","post").attr("action",rutaAux);
					$j( "form" ).submit();
				}else{
					alert("No se encontraron registros");
				}
			});		
		}
		 
	});
	
	$j("#detalle").click(function (){
		var rutaFormaciond= pathUrl+"/json/comisionesDis.do?go=buscarExportar";
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
		if(periodo == "" || periodo == "-1"){
			alert("Debe de seleccionar el periodo.");
		}else{
			$j.getJSON(rutaFormaciond,{anio: anio, periodo: periodo},function(data){
				var size=data.tabla;
				if(size > 0){
					var  rutaAux= pathUrl+"/comisionesDis.do?go=mostrarDetalle";//&anio="+anio+"&periodo="+periodo;
					$j( "form" ).attr("method","post").attr("action",rutaAux);
					$j( "form" ).submit();
				}else{
					alert("No se encontraron registros");
				}
			});		
		}
		 
	});
	
	$j("#publicar").click(function (){
		var rutaFormacionpu= pathUrl+"/json/comisionesDis.do?go=publicar";
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
		
		
		
		if($j('#tblComisiones > tbody').find("input:checked").size()<=0){
			alert("Debe de seleccionar algun distribuidor para publicar.");
		}else{
		
			var lista = $j('#tblComisiones > tbody').find("input:checked");
			var seleccionados = "";
			for(var i =0; i< lista.size(); i++){
				seleccionados += lista[i].value + ",";
			}
			
			seleccionados = seleccionados.substring(0, seleccionados.length-1);
		
			$j.getJSON(rutaFormacionpu,{anio: anio, periodo: periodo, seleccionados: seleccionados},function(data){
				if(data.clave != '-1'){
					$j("#buscar").click();
				}else{
					alert("Error al publicar");
				}
			});		
		}
		 
	});
	
	$j("#eliminar").click(function (){
		var anio = $j("#anioD").text();
		var periodo = $j("#periodoD").text();
		
		if($j('#tblComisionesDetalle > tbody').find("input:checked").size()<=0){
			alert("Debe de seleccionar algun contrato para eliminar.");
		}else{
			var r = confirm("¿Estas seguro de querer eliminar los contratos seleccionados?");
			if(r == true){
				var lista = $j('#tblComisionesDetalle > tbody').find("input:checked");
				var seleccionados = "";
				for(var i =0; i< lista.size(); i++){
					seleccionados += lista[i].value + ",";
				}
				seleccionados = seleccionados.substring(0, seleccionados.length-1);
			
				var  rutaAux= pathUrl+"/comisionesDis.do?go=eliminarContratosDetalle";//&anio="+anio+"&periodo="+periodo;
					$j( "form" ).attr("method","post").attr("action",rutaAux);
					$j( "form" ).append("<input type='hidden' name='anioD' value='"+anio+"' >");
					$j( "form" ).append("<input type='hidden' name='periodoD' value='"+periodo+"' >");
					$j( "form" ).append("<input type='hidden' name='seleccionadosD' value='"+seleccionados+"' >");
					$j( "form" ).submit();
			}
		}
		 
	});
	
	$j("#reprocesar").click(function (){
		var anio = $j("#anioD").text();
		var periodo = $j("#periodoD").text();
		var r = confirm("¿Estas seguro de querer reprocesar los contratos?");
		if(r == true){
			var  rutaAux= pathUrl+"/comisionesDis.do?go=reprocesarDetalle";//&anio="+anio+"&periodo="+periodo;
				$j( "form" ).attr("method","post").attr("action",rutaAux);
				$j( "form" ).append("<input type='hidden' name='anioD' value='"+anio+"' >");
				$j( "form" ).append("<input type='hidden' name='periodoD' value='"+periodo+"' >");
				$j( "form" ).submit();
		}
		 
	});
	
	$j("#agregar").click(function (){
		$j('#tblComisionesAgregar > tbody').html('');
		$j("#bAgregarComisiones").click(cancelarEventoNinguno);
		$j('#bockPantallaAgregar,#agreComisiones').show();
		 
	});
	
	$j("#bbuscarComisiones").click(function (){
		var rutaFormacionC= pathUrl+"/json/comisionesDis.do?go=buscarAgregarDetalle";
		var anio = $j("#anioD").text();
		var periodo = $j("#periodoD").text();
		var contrato = $j("#contrato").val();
		
		if(contrato == ""){
			alert("Debe de acompletar los parametros para la busqueda.");
		}else{
		
			var lista = $j('#tblComisionesAgregar > tbody').find("input");
			var existen = "";
			for(var i =0; i< lista.size(); i++){
				existen += lista[i].value + ",";
			}
			
			existen = existen.substring(0, existen.length-1);
			
			var ex = existen.split(",").indexOf(contrato);
			
			if(ex < 0 || lista.size() == 0){
				$j('div.load').show();
				$j.getJSON(rutaFormacionC,{anio: anio, periodo: periodo, contrato: contrato},function(data){
					//$j('#tblComisionesAgregar > tbody').empty();
					$j('div.load').hide();
					if(data.okCode==1){
						$j("#bAgregarComisiones").click(agregarComisiones);
					}else if(data.okCode==3){
						alert('No se encontro el contrato.');
						$j("#bAgregarComisiones").click(cancelarEventoNinguno);
					}else{
						$j("#bAgregarComisiones").click(cancelarEvento);
					}
					$j('#tblComisionesAgregar > tbody').html('');
					var size=data.tabla.length;
					for(var h=0; h<size; h++){
						data.tabla[h].valor;
						var status = "";
						var desabilitado = "";
						var check = "";
						fila = "<tr>";
						fila += "<td>"+data.tabla[h].tipoVenta+"</td>";
						fila += "<td>"+data.tabla[h].contrato+"</td>";
						fila += "<td>"+data.tabla[h].fecha+"</td>";
						fila += "<td>"+data.tabla[h].claveCanal+"</td>";
						//fila += "<td>"+status+"</td>";
						fila += "</tr>";
						$j('#tblComisionesAgregar > tbody').append(fila);
						
					}
					
				});	
			}else{
				alert("Ya se realizo la busqueda de ese contrato.");
			}
		}
	});
	
});

function cancelarEventoNinguno(event){
	alert('No se ha seleccionado ningun contrato valido.');
	event.preventDefault();
}

function cancelarEvento(event){
	alert('No se puede insertar por que ya hay una activacion/renovacion anterior');
	event.preventDefault();
}

function agregarComisiones(){
	var anio = $j("#anioD").text();
	var periodo = $j("#periodoD").text();
	var contrato = $j("#contrato").val();
	var r = confirm("¿Estas seguro de querer agregar el contrato seleccionado?");
	if(r == true){
		var  rutaAux= pathUrl+"/comisionesDis.do?go=agregarContratoDetalle";//&anio="+anio+"&periodo="+periodo;
			$j( "form" ).attr("method","post").attr("action",rutaAux);
			$j( "form" ).append("<input type='hidden' name='anioD' value='"+anio+"' >");
			$j( "form" ).append("<input type='hidden' name='periodoD' value='"+periodo+"' >");
			$j( "form" ).append("<input type='hidden' name='contrato' value='"+contrato+"' >");
			$j( "form" ).submit();
	}
}

function agregar(distribuidor){
	$j("#distribuidor").val(distribuidor);
	$j("#bAgregarComisiones").show();
	$j("#bEliminarComisiones").hide();
	$j("#bockPantallaAgregar").show();
	$j("#agreComisiones").show();
	$j('#tblComisionesAgregar > tbody').empty();
	$j("#mensajeTituloComisiones").text("Agregar");
	
	var mesS = $j("#periodo").val().substring($j("#periodo").val().length-2,$j("#periodo").val().length);
	var anio = $j("#periodo").val().substring($j("#periodo").val().length-6,$j("#periodo").val().length-2);
	
	var mes = parseInt(mesS)-1;
	
	var firstDay = new Date(anio,mes, 1);
	var lastDay = new Date(anio, mesS, 0);
	
	$j("#fchDate").datepicker( "option", "minDate", firstDay );
	$j("#fchDate").datepicker( "option", "maxDate", lastDay );
}

function eliminar(distribuidor){
	$j("#distribuidor").val(distribuidor);
	$j("#bAgregarComisiones").hide();
	$j("#bEliminarComisiones").show();
	$j('#tblComisionesAgregar > tbody').empty();
	$j("#bockPantallaAgregar").show();
	$j("#agreComisiones").show();
	$j("#mensajeTituloComisiones").text("Eliminar");
}


function validaContrato(event) {
	var c = $j("#"+event.target.id).val();
	var val = false;
	var t = c.length;
	var key = event.keyCode || event.which;
    var tecla = String.fromCharCode(key).toLowerCase();
    var especiales = [32, 62, 8, 9, 36, 35, 46];

    var tecla_especial = false;
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }
    if(t >= 0 && t < 50){//numeros
    	val = validarTexto(tecla,"0123456789,");
    }else if(t >= 30){//fuera de rango 
    	val = false;
    }

    if(!val && !tecla_especial){
    	 return false;
    }else{
    	return true;
    }
	
}

function validarTexto(valor,caracteres){
	if(caracteres.indexOf(valor) == -1 ){
		return false;
	}else{
		return true;
	}
}
