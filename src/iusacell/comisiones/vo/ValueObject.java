
package iusacell.comisiones.vo;

public abstract class ValueObject{

    public abstract String[] getCampos();
    public abstract int[] getLongitudes();
    
    private String[] headerReporte;
    
    public String toString()
    {
        return "";
    }
    
    public ValueObject(){
    }
	/**
	 * @return the headerReporte
	 */
	public String[] getHeaderReporte() {
		return headerReporte;
	}
	/**
	 * @param headerReporte the headerReporte to set
	 */
	public void setHeaderReporte(String[] headerReporte) {
		this.headerReporte = headerReporte;
	}

}