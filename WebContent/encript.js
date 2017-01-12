// encript.js

// newFunction
function newFunction(palabra) {

	
	
	var caCPass = new Array(palabra.length);
	var iAux = 0;
	var caPass = new Array(palabra.length);
	var iaXPass = new Array(palabra.length);			  
	var iaX = new Array(5,6,3,9,10,2,11,8,1,3,4,5,6,7,8,
					  4,3,2,3,4,5,8,7,6,5,4,3,2,3,4,5,
					  6,7,8,1,2,3,4,5,7,6,5,4,3,2,8,7,
					  6,5,4,3,4,5,6,9,8,7,6,5,1,3,2,6,
					  5,8,4,6,9,3,2,4,5,6,7,8,4,5,7,8,9);		 
					  
		// quitar espacios en blanco
		for (int i = 0; i < palabra.length; i++) {
			if (caPass[i] != ' ') {
				caCPass[iAux] += caPass[i];
				iAux++;
			}
		}
		
		// codificar arreglo
		for(int i = 0; i < iAux; i++) {
			iaXPass[i] = (int) caCPass[i] + iaX[i];
			caCPass[i] = (char) iaXPass[i];      
		}	
		
		alert ("el valor encode es: +"caCPass);					   
}