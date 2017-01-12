/**
 * 28/10/2009
 */
package iusacell.comisiones.util;

import iusacell.comisiones.util.Reflection;
import iusacell.comisiones.vo.ValueObject;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * @author ESM
 *
 */
public class GeneraExcelReportes{
	

    public GeneraExcelReportes(String nameSheet) {
    	this.nameSheet = nameSheet;
	}
    
	private HSSFWorkbook workBook = null;
    private HSSFSheet[] sheets = null;
    private HSSFRow row = null;
    private HSSFCell cell = null;
    private HSSFCellStyle headerStyle = null;
    private HSSFCellStyle detailStyle = null;
    private String nameSheet = null;
    private int cellIdx = 0;
    private int rowIdx = 0;
    private int sheetIdx = 0;
    private int numberCell = 65500;
    private int[] columWidth = null;
    
	@SuppressWarnings("unchecked")
	public void reporteExcel(List lst, ValueObject vo) throws Exception{
		try{
			Reflection ref = new Reflection(vo.getClass().getName());
			if(lst!=null){
				double numberSheets = Math.ceil((double)lst.size()/(double)numberCell);
				createSheets((int)numberSheets);
			}
			nextRow();
			writeHeader(vo.getCampos());
			ValueObject objectList = null;
			String[] campos = vo.getCampos();
			for (int x=0; lst!=null && x<lst.size(); x++) {
				objectList = (ValueObject)lst.get(x);
				nextRow();
				for (int y=0; campos!=null && y<campos.length; y++) {
					String metodo = ref.getMethod("get"+campos[y]);
					Object valor = ref.getValorMetodo(metodo, objectList);
					if(detailStyle!=null)
						cell.setCellStyle(detailStyle);
					cell = row.createCell(y);
					write(valor);
				}
				if(x>numberCell){
					writeHeader(vo.getCampos());//vo.getHeaderReporte()
					nextSheet();
				}
			}
		}catch(Exception exc){
			throw new Exception("ERROR_EXCEL");
		}
	}
	
	public void write(OutputStream out) throws Exception{
		workBook.write(out);
	}
	
	public void setup() throws Exception {
		//if (outputStream == null) throw new Exception("El flujo no fué asignado");
		workBook = new HSSFWorkbook();
	}

	private void createSheets(int numberSheets) throws Exception{
		sheets = new HSSFSheet[numberSheets];
		for (int idx = 0; idx < numberSheets; idx++) {
		    //sheets[idx] = workBook.createSheet(nameSheet.substring(0, nameSheet.length()-4)+idx);
			//DataSheet's name max length: 31
			int longitudMax =  31-String.valueOf(idx).length();
			if(nameSheet.length()>longitudMax){
				nameSheet = nameSheet.substring(0,longitudMax).concat(String.valueOf(idx+1));
			}else{
				nameSheet = nameSheet.concat(String.valueOf(idx+1));
			}
			sheets[idx] = workBook.createSheet(nameSheet);
		}
	}
	
	private void nextSheet() throws Exception{
        sheetIdx++;
        rowIdx=0;
    }

    private void nextRow() throws Exception{
        row = sheets[sheetIdx].createRow(rowIdx++);
        cellIdx = (short) 0;
    }
    
    private void writeHeader(String[] values) throws Exception{
        for (int idx = 0; values!=null && idx < values.length; idx++) {
        	writeWidth(idx);
            writeHeader(values[idx]);
        }
    }
    
    /**
	 * 
	 */
	private void writeWidth(int idx) {
		if(columWidth != null){
        	for (int i = 0; i < columWidth.length; i++) {
        		if(i == idx && columWidth[idx] > 0){
        			sheets[sheetIdx].setColumnWidth(idx,columWidth[idx]);
        		}
			}
        }
	}

	private void writeHeader(String header) throws Exception{
        cell = row.createCell(cellIdx++);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        if(headerStyle!=null)
        	cell.setCellStyle(headerStyle);
        cell.setCellValue(new HSSFRichTextString(header));
    }

    private void write(Object obj) throws Exception{
    	if(obj instanceof String)
        	cell.setCellValue(new HSSFRichTextString((String)obj));
        else if(obj instanceof Integer)
        	cell.setCellValue(((Integer)obj).intValue());
        else if(obj instanceof Double)
        	cell.setCellValue(((Double)obj).doubleValue());
        else if(obj instanceof Boolean)
        	cell.setCellValue(((Boolean)obj).booleanValue());
        else if(obj instanceof Date)
        	cell.setCellValue((Date)obj);
    }
    
    public HSSFCellStyle getStyle() throws Exception{
   		return(workBook!=null ? workBook.createCellStyle() : null);
    }
    
    public HSSFFont getFont() throws Exception{
   		return(workBook!=null ? workBook.createFont() : null);
    }

	/**
	 * @param headerStyle the headerStyle to set
	 */
	public void setHeaderStyle(HSSFCellStyle headerStyle) {
		this.headerStyle = headerStyle;
	}

	/**
	 * @param detailStyle the detailStyle to set
	 */
	public void setDetailStyle(HSSFCellStyle detailStyle) {
		this.detailStyle = detailStyle;
	}

	/**
	 * @return Devuelve columWidth.
	 */
	public int[] getColumWidth() {
		return columWidth;
	}
	/**
	 * @param columWidth El columWidth a establecer.
	 */
	public void setColumWidth(int[] columWidth) {
		this.columWidth = columWidth;
	}
}
