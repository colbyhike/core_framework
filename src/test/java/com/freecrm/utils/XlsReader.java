package com.freecrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XlsReader {
	
	static Workbook book;
	static Sheet sheet;

	public static String Test_Data_Sheet_Path_for_Suites = System.getProperty("user.dir"+"\\src\\test\\java\\com\\freecrm\\xls\\Suite.xls");
	
	public XlsReader(String string) {
		// TODO Auto-generated constructor stub
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file =null;
		try{
			file = new FileInputStream("Test_Data_Sheet_Path_for_Suites");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}try{
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet("Test Suite");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}


}
