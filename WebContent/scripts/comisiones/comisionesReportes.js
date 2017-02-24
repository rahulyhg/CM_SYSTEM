// comisiones.js

var $j = jQuery.noConflict(true);
var semAct;
var pub;
var pathUrl;

$j(document).ready(function(){
	semAct = getSemana();
	pathUrl = getURL();

	try {
	   if(semAct!=$j("#semanaD").text()){
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
	
	$j('input[name=mesSemana][value=0]').click();

	var rutaFormacion= pathUrl+"/json/comisionesReportes.do?go=anio";
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

	$j.getJSON(pathUrl+"/json/comisionesReportes.do?go=periodo",function(data){
		cargarPeriodo(data);
	}); 
	
	$j.getJSON(pathUrl+"/json/comisionesReportes.do?go=mes",function(data){
		cargarPeriodoMes(data);
	}); 
	
	$j('input[name=mesSemana]').click(function(){
		var val = this.value;
		if(val=="0"){
			$j("#periodo").hide();
			$j('#mesPeriodo').show();
			$j('#tipoMes').show();
			$j('#tipoSemana').hide();
		}else{
			$j("#periodo").show();
			$j('#mesPeriodo').hide();
			$j('#tipoMes').hide();
			$j('#tipoSemana').show();
		}
	});
	
	$j("#anio").change(function (){
		$j("#periodo,#tblComisiones > tbody").empty();
		$j("#periodo").append('<option class="uno" value="-1"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">--Seleccione una opción--</option>');
		$j.getJSON(pathUrl+"/json/comisionesReportes.do?go=periodo",{anio: $j("#anio").val()},function(data){
			cargarPeriodo(data);
		}); 
		$j.getJSON(pathUrl+"/json/comisionesReportes.do?go=mes",{anio: $j("#anio").val()},function(data){
			cargarPeriodoMes(data);
		});
	});
	
	$j("#periodo").change(function (){
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
	});
	
	/*$j("#exportar").click(function (e){
		
		e.preventDefault();
		e.stopPropagation();
		
		var anio = $j("#anio").val();
		var periodo = $j("#periodo").val();
		var mesPeriodo = $j('#mesPeriodo').val();
		var mesSemana = $j('input[name=mesSemana]:checked').val();
		var tipoMes = $j('#tipoMes').val();
		var tipoSemana = $j('#tipoSemana').val();
		
		var url = pathUrl+'/json/comisionesReportes.do?go=buscarExportar';
		url += '&mesPeriodo='+ mesPeriodo;
		url += '&periodo='+ periodo;
		url += '&anio='+ anio;
		url += '&mesSemana='+ mesSemana;//tipoMes // tipoSemana
		url += '&tipoMes='+ tipoMes;
		url += '&tipoSemana='+ tipoSemana;
		
		if(mesSemana == ""){
			alert("Debe seleccionar reportes Mensuales o semanales.");
		}else if(mesSemana == "0" && (tipoMes == "" || tipoMes == "-1")){
			alert("Debe de seleccionar el tipo reporte.");
		}else if(mesSemana == "0" && (mesPeriodo == "" || mesPeriodo == "-1")){
			alert("Debe de seleccionar el mes.");
		}else if(mesSemana == "1" && (tipoSemana == "" || tipoSemana == "-1")){
			alert("Debe de seleccionar el tipo reporte.");
		}else if(mesSemana == "1" && (periodo == "" || periodo == "-1")){
			alert("mes semana: "+mesSemana);
			alert("periodo: "+periodo);
			//alert("Debe de seleccionar la semana.");
		}else{
			$j.getJSON(url,function(data){
				var size=data.tabla;
				if(size > 0){
					var rutaAux = pathUrl+'/comisionesReportes.do?go=exportar';
					rutaAux += '&mesPeriodo='+ mesPeriodo;
					rutaAux += '&periodo='+ periodo;
					rutaAux += '&anio='+ anio;
					rutaAux += '&mesSemana='+ mesSemana;
					rutaAux += '&tipoMes='+ tipoMes;
					rutaAux += '&tipoSemana='+ tipoSemana;
					$j( "form" ).attr("method","post").attr("action",rutaAux);
					$j( "form" ).submit();
				}else{
					alert("No se encontraron registros");
				}
			});		
		}
		 
	
		
	});*/
	
	/*$j("#exportar").click(function (e){
		e.preventDefault();
		
	});*/
	
});

function cargarPeriodo(data){
	if(typeof data.tabla != 'undefined'){
		//var size=data.tabla.length;
		//var size = 12;
		//Changed to load more weeks
		var size = 53;
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
}

function cargarPeriodoMes(data){
	if(typeof data.tabla != 'undefined'){
		//var size=data.tabla.length;
		var size = 12;
		var comboCss="uno";
		$j("#mesPeriodo").empty();
		$j("#mesPeriodo").append('<option class="'+ comboCss+ '" value="-1"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">--Seleccione una opción--</option>');
		for(var i=0; i<size; i++){
			if(i%2==0)
				comboCss='dos';
			else
				comboCss='uno';	
			if(i==0){
				$j("#mesPeriodo").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'" style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
			}else{
				$j("#mesPeriodo").append('<option class="'+ comboCss+ '" value="'+data.tabla[i].valor +'"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;"  style="color: #000000;font:  Verdana;font-family: Verdana;font-size: 8pt;">'+data.tabla[i].descripcion +'</option>');
			} 
		}
	}
}

function mostrarMensaje(mensaje, foc){
	$j('#bockPantalla').show();
	$j('#mensaje').show(); 
	$j('#msjMensaje').html("");
	$j('#msjMensaje').append(mensaje);
	$j("#bMensaje").click(function(){aceptarMostrarMensaje(foc)});
}

function aceptarMostrarMensaje(foc){
	$j('#mensaje').hide();
	$j('#bockPantalla').hide();
	$j('#'+foc).focus();
	$j("#bMensaje").off();
}

function waitingGral(){
	document.getElementById('cargaMod').style.height=screen.availHeight-100;
	document.getElementById('cargaMod').style.width=screen.availWidth+"px";
	document.getElementById('cargaMod').style.display=""; //hmm_12042012

}

function stopWaitingGral(){
	document.getElementById('cargaMod').style.display="none"; //yoc_04092014
}
