package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utiles2 {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook   book;
	public static XSSFSheet      sheet;
	public static XSSFRow         row;
	public static XSSFCell        cell;
	
	
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

}
