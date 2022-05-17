package utils;

import java.io.IOException;

public class ExcelUtilsDemo {
	
 public static void main(String[] args) throws IOException {
	  String projectPath = System.getProperty("user.dir");
	ExcelUtils excel = new ExcelUtils(projectPath+"/src/test/resources/excelfile/data.xlsx","Sheet1");
	excel.getCellDataNumeric(1, 2);
	excel.getRowCount();
	
}
}
