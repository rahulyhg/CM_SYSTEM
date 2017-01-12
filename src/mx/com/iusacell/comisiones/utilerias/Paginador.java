/*
 * Creado el 26/02/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package mx.com.iusacell.comisiones.utilerias;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class Paginador {
	/**
	 * pagina actual del paginador
	 */
	int paginador;
	/**
	 * num inicio de la pagina actual
	 */
	int inicio;
	/**
	 * num final de la pagina actual
	 */
	int fin;
	/**
	 * tamaño total de la lista
	 */
	int tamCampos;
	/**
	 * campos por pagina 
	 */
	int numXPagina;
	/**
	 * paginas totales del paginador
	 */
	int paginas;
	
	/**
	 * filas realez validas del archivo
	 */
	int contTabla;
	
	/**
	 * total de errores en el archivo
	 */
	int totalError;
	
	/**
	 * 
	 */
	public Paginador(int paginador, int tamCampos, int numXPagina) {
		//Validamos que el valor del paginador no sea cero
		this.paginador = paginador == 0 ? 1 : paginador;
		//Validamos que el valor de numXPaginas no sea cero
		this.numXPagina = numXPagina == 0 ? 1 : numXPagina;
		//Seteamos el valor del tamaños de los campos
		this.tamCampos = tamCampos;
		//Obtenemos el numero de paginas 
		this.paginas = (this.tamCampos/this.numXPagina)+1;
		//Si el numero de paginas es 0 lo ponemos a uno
		this.paginas = this.paginas == 0 ? 1 : this.paginas;
		//si el paginador es mas grande que el numero de paginas lo igualamos al numero de paginas
		this.paginador = this.paginador>this.paginas ? this.paginas : this.paginador;
		//Obtenemos el valor inicial
		this.inicio = ((this.paginador*this.numXPagina)-this.numXPagina+1);
		//Obtenemos el valor final
		this.fin = (this.paginador*this.numXPagina);
		//Inicializamos el total de Errores
		this.totalError = 0;
		//Inicializamos el total de datos validos
		this.contTabla = 0;
	}
	

	/**
	 * @return Devuelve fin.
	 */
	public int getFin() {
		return fin;
	}
	/**
	 * @param fin El fin a establecer.
	 */
	public void setFin(int fin) {
		this.fin = fin;
	}
	/**
	 * @return Devuelve inicio.
	 */
	public int getInicio() {
		return inicio;
	}
	/**
	 * @param inicio El inicio a establecer.
	 */
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	
	/**
	 * @return Devuelve numXPagina.
	 */
	public int getNumXPagina() {
		return numXPagina;
	}
	/**
	 * @param numXPagina El numXPagina a establecer.
	 */
	public void setNumXPagina(int numXPagina) {
		this.numXPagina = numXPagina;
	}
	/**
	 * @return Devuelve paginador.
	 */
	public int getPaginador() {
		return paginador;
	}
	/**
	 * @param paginador El paginador a establecer.
	 */
	public void setPaginador(int paginador) {
		this.paginador = paginador;
	}
	/**
	 * @return Devuelve paginas.
	 */
	public int getPaginas() {
		return paginas;
	}
	/**
	 * @param paginas El paginas a establecer.
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	/**
	 * @return Devuelve tamCampos.
	 */
	public int getTamCampos() {
		return tamCampos;
	}
	/**
	 * @param tamCampos El tamCampos a establecer.
	 */
	public void setTamCampos(int tamCampos) {
		this.tamCampos = tamCampos;
	}
	/**
	 * @return Devuelve totalError.
	 */
	public int getTotalError() {
		return totalError;
	}
	
	/**
	 * @param totalError El totalError a establecer.
	 */
	public void incremTotalError() {
		this.totalError++;
	}
	/**
	 * @return Devuelve contTabla.
	 */
	public int getContTabla() {
		return contTabla;
	}
	
	/**
	 * @param totalError El totalError a establecer.
	 */
	public void incremContTabla() {
		this.contTabla++;
	}
}
