package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;


public class ExcelReader {
	
	private static XSSFWorkbook  xssfworkbook ;
	private static HSSFWorkbook  hssfworkbook ;//= new XSSFWorkbook();
	private static XSSFSheet xssfSheet ;
	private static HSSFSheet hssfSheet ;

	static Object[][] finalDataFieldsArray = null;
/*@Test
@Parameters({ "UserDetails.xlsx", "UserDetails" })*/
	public static Object[][] readExcelData(String workBookName, String sheetName) throws IOException{
		
		 String[][] dataFieldsArray = null;
         /*Object[][] finalDataFieldsArray = null;
         Object[] dataArray = null;*/
		
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\"+workBookName);
		try {
		FileInputStream inputDate = new FileInputStream(file);
		xssfworkbook = new XSSFWorkbook(inputDate);
		xssfSheet = xssfworkbook.getSheetAt(0);
		
		int totalNoOfRows = xssfSheet.getPhysicalNumberOfRows();
		int totalNoOfCols = xssfSheet.getRow(0).getPhysicalNumberOfCells();
		
		if (xssfSheet.getRow(0).getCell(totalNoOfCols - 1).toString()==null)
        {
            totalNoOfCols = totalNoOfCols - 1;
        }
		
		dataFieldsArray = new String[totalNoOfRows-1][totalNoOfCols] ;
        for (int rowCounter = 1; rowCounter < totalNoOfRows; rowCounter++)
        {
           
//            dataFieldsArray = new String[totalNoOfCols][];
            for (int colCounter = 0; colCounter <= totalNoOfCols-1; colCounter++)
            {
                if (null != xssfSheet.getRow(rowCounter).getCell(colCounter))
                {
                     String    cellValue = xssfSheet.getRow(rowCounter).getCell(colCounter).toString().trim();
                    
                   /* dataArray = new Object[] {xssfSheet.getRow(0).getCell(colCounter).toString().trim(), cellValue };
                    dataFieldsArray[colCounter] = dataArray;*/
                     dataFieldsArray[rowCounter-1][colCounter] =cellValue; 
                     
                }
                else
                {
                    //dataArray = new Object[] {/*xssfSheet.getRow(0).getCell(colCounter).toString().trim(),*/ "" };
                    dataFieldsArray[rowCounter-1][colCounter] =""; 
                }
            }
            
//            finalDataFieldsArray = copyArray(finalDataFieldsArray, dataFieldsArray);
            //Object[] dataArray1 = new Object[] { paramKey, paramValue };


        }
		}catch (FileNotFoundException e){
			 
		Assert.fail(" File Not Found Exception");

			e.printStackTrace();

			}

		catch (IOException e){

			Assert.fail(" IO Exception");

			e.printStackTrace();

			}
		
		xssfworkbook.close();
		
		return dataFieldsArray;
		
	}
	
	private static Object [][] copyArray(Object[][] sourceArray,Object[] targetArray )
	{
		Object [][] localDataArray;
		int currArrSize=0;
		if(sourceArray !=null)
		{
			currArrSize=sourceArray.length;	
			localDataArray=new Object[currArrSize+1][];			
			java.lang.System.arraycopy(sourceArray,0,localDataArray,0,currArrSize);
		}
		else
		{
			localDataArray=new Object[currArrSize+1][];
		}	
	
		localDataArray[currArrSize]=targetArray;					
		sourceArray=localDataArray;
		return sourceArray;
	}
	
	

}
