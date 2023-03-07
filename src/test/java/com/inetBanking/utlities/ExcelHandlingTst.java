package com.inetBanking.utlities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;

public class ExcelHandlingTst {

	public FileInputStream FIS;
	public FileOutputStream FO;
	public XSSFWorkbook workBook;
	public XSSFSheet workSheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	
	public String excelPath = "./TestData/TestData.xlsx";
	
	public int getRowCount(String Path,String sheetName) throws IOException {
		FIS = new FileInputStream(Path);
		workBook = new XSSFWorkbook(FIS);
		workSheet = workBook.getSheet(sheetName);
		int rowCount = workSheet.getLastRowNum();
		
		workBook.close();
		FIS.close();
		return rowCount;
	}
	
	public int getCollCount(String Path,String sheetName, int rowNumber) throws IOException {
		FIS = new FileInputStream(Path);
		workBook = new XSSFWorkbook(FIS);
		workSheet = workBook.getSheet(sheetName);
		row = workSheet.getRow(rowNumber);
		int collCount = row.getLastCellNum();
		workBook.close();
		FIS.close();
		return collCount;
	}
	
	public String getCellData(String Path,String sheetName,int rowNum, int collNum) throws IOException {
		FIS = new FileInputStream(Path);
		workBook = new XSSFWorkbook(FIS);
		workSheet = workBook.getSheet(sheetName);
		row = workSheet.getRow(rowNum);
		cell = row.getCell(collNum);
		
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue;
		
		try {
			cellValue = dataFormatter.formatCellValue(cell);
		}catch (Exception e) {
			System.out.println("No data in the cell");
			cellValue ="";
		}
		
		workBook.close();
		FIS.close();
		return cellValue;
	}
	
	public void updateCellValue(String Path,String sheetName,int rowNum, int collNum, String cellValue) throws IOException {
		
		
		FIS =new FileInputStream(Path);
		workBook = new XSSFWorkbook(FIS);
		workSheet = workBook.getSheet(sheetName);
		
		//System.out.println(workSheet.getLastRowNum());
		row = workSheet.createRow(rowNum);
		cell = row.getCell(collNum);
		cell.setCellValue(cellValue);
		FIS.close();
		
		FO = new FileOutputStream(Path);
		workBook.write(FO);
		FO.close();
	}
	
	
	public void fillCellGreenColor(String Path,String sheetName,int rowNum, int collNum) throws IOException {
		
		FO = new FileOutputStream(Path);
		workBook = new XSSFWorkbook();
		workSheet = workBook.getSheet(sheetName);
		
		System.out.println(workSheet.getLastRowNum());
		row = workSheet.getRow(rowNum);
		cell = row.getCell(collNum);
		
		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workBook.write(FO);
		workBook.close();
		FO.close();
	}
	
	public void fillCellRedColor(String Path,String sheetName,int rowNum, int collNum) throws IOException {
		
		FIS = new FileInputStream(Path);
		workBook = new XSSFWorkbook(FIS);
		workSheet = workBook.getSheet(sheetName);
		row = workSheet.getRow(rowNum);
		cell = row.getCell(collNum);
		
		style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workBook.write(FO);
		workBook.close();
		FIS.close();
	}
	
	
	public static void main(String[] args) throws IOException {
//		LoginDetails
		
		ExcelHandlingTst EL = new ExcelHandlingTst();
		//System.out.println(EL.getRowCount(EL.excelPath, "Sheet1"));
		
		//System.out.println("Cell Value : " + EL.getCellData(EL.excelPath, "Sheet1", 3, 0));
		EL.updateCellValue(EL.excelPath, "Sheet1", 3, 1, "Arvind");
	}
}

