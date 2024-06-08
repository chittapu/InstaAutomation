package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static File file;
	static FileInputStream fis;
	static XSSFWorkbook wbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;

	public static int getRowNum(String filePath, String Sheetnum) throws InvalidFormatException, IOException {
		file = new File(filePath);
		fis = new FileInputStream(file);
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet(Sheetnum);
		int rowNum = sheet.getLastRowNum();

		return rowNum;

	}

	public static int getCellNum(String filePath, String Sheetnum, int rownum)
			throws InvalidFormatException, IOException {
		file = new File(filePath);
		wbook = new XSSFWorkbook(file);
		sheet = wbook.getSheet(Sheetnum);
		row = sheet.getRow(rownum);

		int cellNum = row.getLastCellNum();

		return cellNum;

	}

	public static String getCellValue(String filePath, String Sheetnum, int rownum, int cellnum)
			throws InvalidFormatException, IOException {
		file = new File(filePath);
		wbook = new XSSFWorkbook(file);
		sheet = wbook.getSheet(Sheetnum);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		DataFormatter formate = new DataFormatter();
		String cellValue = formate.formatCellValue(cell);
		fis.close();
		wbook.close();
		return cellValue;

	}

}