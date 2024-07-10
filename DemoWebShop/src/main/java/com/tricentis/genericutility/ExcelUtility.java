package com.tricentis.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getStringDataFromExcel(String sheetname, int rownum, int colnum) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
	}
	public boolean getBooleanDataFromExcel(String sheetname, int rownum, int colnum) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getBooleanCellValue();
	}
	public double getNumberDataFromExcel(String sheetname, int rownum, int colnum) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getNumericCellValue();
	}
	//for local date and time
	public LocalDateTime getLocalDateTimeFromExcel(String sheetname, int rownum, int colnum) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getLocalDateTimeCellValue();
	}
}
