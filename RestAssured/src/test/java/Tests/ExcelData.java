package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExcelData {
	@Test
	public void data() throws IOException
	{
	
	String datapath =System.getProperty("user.dir");
	datapath=datapath+"/src/test/resources/TestData.xlsx";
    System.out.println("data path is: " +datapath);
	
	File excelFile = new File(datapath);
	FileInputStream file=new FileInputStream(excelFile);
	XSSFWorkbook workbook =new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	
	String name = sheet.getRow(1).getCell(1).getStringCellValue();
	String job = sheet.getRow(1).getCell(2).getStringCellValue();
	//System.out.println("Job", +job);
	
	RestAssured.baseURI= "https://reqres.in/";
	JSONObject request = new JSONObject();
	request.put("name", name);
	request.put("job",job);
	
	RequestSpecification req=RestAssured.given();
	req.body(request.toString());
			
			Response resp =req.post("/api/users/");
	
	System.out.println("Response is  " +resp.asString());
	
	
}
}
