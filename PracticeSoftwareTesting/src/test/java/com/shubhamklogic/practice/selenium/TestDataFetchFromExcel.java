package com.shubhamklogic.practice.selenium;

import java.io.FileInputStream;
import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataFetchFromExcel {

	// Apache POI Usage Example - 
	// Blog Tutorial : https://www.browserstack.com/guide/log4j-in-selenium
	// Video Tutorial : SDET QE Automation Techie chnl Apache POI Series.
	// Lib : Added External Apache POI Jar Files in Project's Build Path = https://archive.apache.org/dist/poi/release/bin/poi-bin-5.2.3-20220909.zip

	public static void main(String[] args) throws Exception {

		// ToDo: Make path generic-
		String xlFilePath = "/Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/main/resources/TestDataAllTypes/StateCapitalPopulationDetails.xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook( new FileInputStream(xlFilePath));		// 1. Create XSSFWorkBook + FileInputStream
		

		XSSFSheet sheet = workbook.getSheet("Sheet1");									// 2. Create XSSFSheet using wbook.getSheet("")

		int totalRows = sheet.getLastRowNum();											// 3. Save NumOfRows, NumOfCols using-
		int totalCols = sheet.getRow(0).getLastCellNum();								//		sheet.getLastRowNum() & getRow(0).getLastCellNum()

		for (int r = 0; r < totalRows; r++) {											// 4. Loop thru all NumOfRows, and fetch 
			XSSFRow row = sheet.getRow(r);												// 		sheet.getRow(r) in XSSFRow obj.

			for (int c = 0; c < totalCols; c++) {

				XSSFCell cell = row.getCell(c);											// 5. Loop thru all NumOfCols, and fetch and
				// cell.setCellType( CellType.STRING );									// 		row.getCell(c) in XSSFCell obj. 
				
				switch (cell.getCellType()) 
				{																		// 6. To access cell values, use - cell.getCellType()
					case STRING: {														// 		org.apache.poi.ss.usermodel.CellType.STRING 
						String str = cell.getStringCellValue();							// 		Or NUMERIC / BOOLEAN / DATE
						System.out.print( str +" | ");									// 		Then, to fetch values of Cells - 
						break;															// 		  c.getStringCellValue(), .getNumericCellValue ..
					}
					case NUMERIC: {
						Double num = cell.getNumericCellValue();
					//	System.out.print( num +" + ");					// Output :( : Nagaland | Kohima | 5.5E7 | 	Double => Scientific No. 
						
						double doubleNum = num.doubleValue();
						BigDecimal bigDec = new BigDecimal( num );
						System.out.print( bigDec +" | ");				// Output :) : Nagaland | Kohima | 55000000 |  Double => BigDecimals
						break;
					}
					case BOOLEAN: {
						Boolean bool = cell.getBooleanCellValue();
						System.out.print( bool +" | ");
						break;
					}
					// Other Methods to get Cell Values :: cell.getDateCellValue();  .getErrorCellValue();  .getLocalDateTimeCellValue();
				}
			}
			System.out.print("\n");
		}
	}
}
