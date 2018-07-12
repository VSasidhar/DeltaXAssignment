package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;


public class ExcelReader {
	
	private static XSSFWorkbook  xssfworkbook ;//= new XSSFWorkbook();
	private static XSSFSheet xssfSheet ;
	static Object[][] finalDataFieldsArray = null;
/*@Test
@Parameters({ "UserDetails.xlsx", "UserDetails" })*/
	public static Object[][] readExcelData(String workBookName, String sheetName) throws IOException{
		
		File fileName =new File (System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\"+workBookName);
		FileInputStream excelFile = new FileInputStream(fileName);
	
		xssfworkbook = new XSSFWorkbook(excelFile);
		xssfSheet = xssfworkbook.getSheet(sheetName);
		
		int totalRows = xssfSheet.getPhysicalNumberOfRows();
		int totalColumns = xssfSheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=1;i<totalRows;i++){
			finalDataFieldsArray = new Object[totalColumns][];
			for(int j=0;j<totalColumns;j++){
				
				finalDataFieldsArray[j] = new Object[]{xssfSheet.getRow(i).getCell(j)};
				
			}
			
		}
		
		xssfworkbook.close();
		
		return finalDataFieldsArray;
		
	}
	

}
