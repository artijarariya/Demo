package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}

	public static void main(String[] args) throws IOException {
		getRowCount();
		getCellDataString(0, 0);
		getCellDataNumeric(1, 1);
	}

	public static void getRowCount() throws IOException {

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}

	public static void getCellDataString(int rowNum, int colNum) throws IOException {

		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

		System.out.println(cellData);

	}

	public static void getCellDataNumeric(int rowNum, int colNum) throws IOException {

		double cellData3 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

		System.out.println(cellData3);

	}
}
