package datadriven;

import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook   book;
	public static XSSFSheet      sheet;
	public static XSSFRow         row;
	public static XSSFCell        cell;
	public static CellStyle      style;
	
	public static int getRowCount(String xlfile,String xlSheet )throws Exception {
		fis = new FileInputStream(xlfile);
		book = new XSSFWorkbook(fis);
		sheet=book.getSheet(xlSheet);
		int row=sheet.getLastRowNum();
		
		book.close();
		fis.close();
		
		return row;	
	}
	
	public static int getCellCount(String xlfile,String xlSheet,int rowNum )throws Exception {
		fis = new FileInputStream(xlfile);
		book = new XSSFWorkbook(fis);
		sheet=book.getSheet(xlSheet);
		row=sheet.getRow(rowNum);
		int cell=row.getLastCellNum();
		
		book.close();
		fis.close();
		
		return cell;	
	}
	
	public static String getCellData(String xlfile,String xlSheet,int rowNum,int cellNum) throws Exception {
		fis = new FileInputStream(xlfile);
		book = new XSSFWorkbook(fis);
		sheet=book.getSheet(xlSheet);
		row=sheet.getRow(rowNum);
		cell =row.getCell(cellNum);
		
		String data;
		
		try {
		//	data=cell.toString();
			DataFormatter df = new DataFormatter();
			data=df.formatCellValue(cell);
		}
		catch(Exception e) {
			data = "";
		}
		book.close();
		fis.close();
	     return data;
	}
	
	public static void setCellData(String xlfile,String xlSheet,int rowNum,int cellNum,String data) throws Exception {
		File myfile = new File(xlfile);   // if file not exists then create new file
		if(!myfile.exists()) {
			fos  = new FileOutputStream(xlfile);
			book = new XSSFWorkbook();
			book.write(fos);
			
		}
		
		fis= new FileInputStream(xlfile);
		book = new XSSFWorkbook(fis);
		
		if(book.getSheetIndex(xlSheet)==-1) {     //if sheet not exist create new sheet
			book.createSheet(xlSheet);	
		}
		sheet=book.getSheet(xlSheet);
		
		if(sheet.getRow(rowNum)==null) {        //if row not exist create new row
			sheet.createRow(rowNum);
		}
		row=sheet.getRow(rowNum);	
		
		cell=row.createCell(cellNum);
	    cell.setCellValue(data);
	    
	    fos  = new FileOutputStream(xlfile); 
	    book.write(fos);
	    book.close();
	    fos.close();
	    fis.close();
		
	}
	
	public static void getredColour(String xlfile,String xlSheet,int rowNum,int cellNum)throws Exception {
		fis= new FileInputStream(xlfile);
		book = new XSSFWorkbook(fis);
		sheet =book.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell =row.getCell(cellNum);
		
		style =book.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fos  = new FileOutputStream(xlfile);
		book.write(fos);
		
	    book.close();
	    fos.close();
	    fis.close();
		
		
		
	}
	

}
