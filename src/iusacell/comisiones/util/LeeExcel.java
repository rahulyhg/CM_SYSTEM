package iusacell.comisiones.util;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;


import iusacell.comisiones.util.Reflection;
import iusacell.comisiones.vo.ValueObject;

import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;

public class LeeExcel {
	
	Logger log = Logger.getLogger(LeeExcel.class);

	private int columnas;
	private int fila = 0;
	private int hoja;
	
	public LeeExcel(){
	}
    
    @SuppressWarnings("unchecked")
	public List<ValueObject> cargaDatos(InputStream is, ValueObject vo, boolean castingString) throws IOException, Exception {
    	List<ValueObject> lstObj =new ArrayList<ValueObject>();
		String[] campos = vo.getCampos();
		Object[] objs = null;
        POIFSFileSystem fs = new POIFSFileSystem( is );
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = null;
        HSSFRow row = null;
        try{
        	String clase = ((Class)vo.getClass()).getName();
        	Reflection ref = new Reflection(clase);
            if(wb.getNumberOfSheets()>0){
                sheet = wb.getSheetAt(hoja);
                ValueObject voNuevo = null;
                for (int idx = (fila<=0 ? 1 : fila); idx <= sheet.getLastRowNum(); idx++) {
                	voNuevo = (ValueObject)vo.getClass().newInstance();
                    row = sheet.getRow(idx);
                    for(int i=0;i<columnas;i++){
                    	objs = new Object[1];
                   		HSSFCell celda = row.getCell(i);
                   		Object objCelda = objetoCelda(celda);
                   		if(castingString){
                   			if(objCelda instanceof Double)
                   				objs[0] = String.valueOf(((Double)objCelda).longValue());
                   			else
                   				objs[0] = String.valueOf(objCelda);
                   		}else
                   			objs[0] = objCelda;
                   		String metodo = ref.getMethod("set"+campos[i]);
						ref.setValorMetodo(metodo, voNuevo, objs);
                   	}
                    lstObj.add(voNuevo);
                }
            }
        }catch(Exception e){
        	log.info("ERROR:cargaDatos()");
        	e.printStackTrace();
        }
        return lstObj;
    }
    
    public List<String> cargaDatosString(InputStream is) throws IOException, Exception {
    	List<String> lstObj = new ArrayList<String>();
        POIFSFileSystem fs = new POIFSFileSystem( is );
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = null;
        HSSFRow row = null;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        try{
            if(wb.getNumberOfSheets()>0){
                sheet = wb.getSheetAt(hoja);
                for (int idx = (fila<=0 ? 1 : fila); idx <= sheet.getLastRowNum(); idx++) {
                    row = sheet.getRow(idx);
                    columnas = getColumnas(row);
                    if(columnas>0){
                    	StringBuffer campos = new StringBuffer();
//                    	int gar = 10000;
                         for(int i=0;i<columnas;i++){
                        		HSSFCell celda = row.getCell(i);
                        		Object objCelda = objetoCelda(celda);
                        		if(objCelda instanceof Double){
                    				campos.append("|").append(df.format(objCelda));
                    			}else{
                    				String s = String.valueOf(objCelda);
                    				s = s.equals("null") || s.equals("NULL")?"":s;
                    				campos.append("|").append(s);
                    			}
//                        		if(i==gar){Util.pasarGarbageCollector();gar=gar+10000;}
                        	}
                         campos = campos.toString().equals("")?campos: new StringBuffer(campos.substring(1));
                         lstObj.add(campos.toString());
                    }
                }
            }
        }catch(Exception e){
        	log.info("ERROR:cargaDatos()");
        	e.printStackTrace();
        }
        return lstObj;
    }
    
    /**
	 * @param row
	 * @return
	 */
	private int getColumnas(HSSFRow row) {
		int col = row.getLastCellNum();
		int colum = 0;
		for(int i=0;i<col;i++){
			HSSFCell celda = row.getCell(i);
			if(celda != null){
				Object objCelda = objetoCelda(celda);
	       		if(!String.valueOf(objCelda).equals("") && !String.valueOf(objCelda).equals("null")){
	       			colum = i+1;
	       		}
			}
		}
		return colum;
	}

	public Object objetoCelda(HSSFCell cell){
        Object obj = null;
        try{
	        if(cell!=null ){
	            switch( cell.getCellType()){
	                case HSSFCell.CELL_TYPE_NUMERIC	: obj = new Double(cell.getNumericCellValue());break;
	                case HSSFCell.CELL_TYPE_STRING	: obj = cell.getRichStringCellValue().getString();break;
	                case HSSFCell.CELL_TYPE_BLANK 	: obj = new String(); break;
	                case HSSFCell.CELL_TYPE_BOOLEAN	: obj = new Boolean(cell.getBooleanCellValue());break;
	                case HSSFCell.CELL_TYPE_FORMULA	: obj = returnObject(cell);
	                returnClass(obj);
	                break;
	            }
	        }
        }catch(Exception exc){
        	log.info("ERROR:objetoCelda()");
        }
        return(obj);
    }
    
    public Object returnObject(HSSFCell cell){
        Object object = null;
        try{
        	object = new Double(cell.getNumericCellValue());
        }catch(Exception exc){
        	try{
        		object = cell.getRichStringCellValue().getString();
        	}catch(Exception e){
        		log.info("ERROR:returnObject()");
        		e.printStackTrace();
        	}
        }
        return object;
    }
    
    public String returnClass(Object obj){
        String clase = "";
        if(obj instanceof String)
            clase = "String";
        else if(obj instanceof HSSFRichTextString)
                clase = "String";
        else if(obj instanceof Double)
            clase = "Double";
        else if(obj instanceof Boolean)
            clase = "Boolean";
        return clase;
    }
    
    public boolean validateRow(HSSFRow row) throws Exception{
        return row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().equals("");
    }

	/**
	 * @return int
	 */
	public int getHoja() {
		return hoja;
	}
	/**
	 * @param hoja int
	 */
	public void setHoja(int hoja) {
		this.hoja = hoja;
	}

	/**
	 * @return int
	 */
	public int getColumnas() {
		return columnas;
	}
	/**
	 * @param columnas int
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	/**
	 * Retorna el valor de fila
	 * @return int
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Asigna fila
	 * @param fila int
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}
	
}

