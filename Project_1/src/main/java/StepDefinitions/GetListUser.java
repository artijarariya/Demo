package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ExcelReaderFile;

public class GetListUser {
	private String filepath = "./excelFiles/GET.xlsx";
	private String baseUrl = null;
	private String endpoint = null;
	private String pageId = null;
	private int statusCode = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for GET_list")
	public void retrive_data_from_and(String sheet_name, Integer row_number) throws InvalidFormatException, IOException {
		ExcelReaderFile reader = new ExcelReaderFile();
		List<Map<String, String>> getRequest = reader.getData(filepath, sheet_name);

		baseUrl = getRequest.get(row_number).get("baseUrl");
		endpoint = getRequest.get(row_number).get("endpoint");
		pageId = getRequest.get(row_number).get("pageId");
		statusCode = Integer.parseInt(getRequest.get(row_number).get("statusCode"));
	}

	@When("user call baseUrl with endpoint and userId for GET_list")
	public void user_call_base_url_with_endpoint_and_user_id() {
		RestAssured.baseURI = baseUrl;
		response = given().contentType(ContentType.JSON).param("page", this.pageId).when().get(endpoint).then().extract().response();
	}

	@Then("verify statusCode and pageId with excel file for GET_list")
	public void verify_status_code_with_excel_file() {
		Assert.assertEquals(statusCode, response.statusCode());
		Assert.assertEquals(pageId, response.jsonPath().getString("page"));
	}

	@Then("print the response body for GET_list")
	public void print_the_response_body() {
		System.out.println("\n\n" + response.jsonPath().getString("data"));
	}

}
