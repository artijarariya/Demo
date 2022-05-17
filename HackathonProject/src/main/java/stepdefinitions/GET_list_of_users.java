package stepdefinitions;

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
import utility.ConfigFileReader;
import utility.ExcelReader;

public class GET_list_of_users {

	/**
	 * Step Definitions for GET request for list of users Variables: - FILEPATH :
	 * getting data from given excel file
	 * 
	 */

	private final String FILEPATH = ConfigFileReader.getProperties("getRequestFilepath");
	private String baseUrl = null;
	private String endpoint = null;
	private String pageId = null;
	private int statusCode = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for GET_list")
	public void retrive_data_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		/* instantiating ExcelReader class for reading data from given excel sheet */
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> getRequest = reader.getData(FILEPATH, sheetName);

		/* using row number and cell name for getting data from specific cell */
		baseUrl = getRequest.get(rowNumber).get("baseUrl");
		endpoint = getRequest.get(rowNumber).get("endpoint");
		pageId = getRequest.get(rowNumber).get("pageId");
		statusCode = Integer.parseInt(getRequest.get(rowNumber).get("statusCode"));
	}

	@When("user call baseUrl with endpoint and userId for GET_list")
	public void user_call_base_url_with_endpoint_and_user_id() {
		/* setting up the base-url */
		RestAssured.baseURI = baseUrl;
		/* calling get request and extracting response from it */
		response = given().contentType(ContentType.JSON).param("page", this.pageId).when().get(endpoint).then()
				.extract().response();
	}

	@Then("verify statusCode and pageId with excel file for GET_list")
	public void verify_status_code_with_excel_file() {
		/* verifying response status code with excel status code */
		Assert.assertEquals(statusCode, response.statusCode());
		/* verifying response page id with excel data */
		Assert.assertEquals(pageId, response.jsonPath().getString("page"));
	}

	@Then("print the response body for GET_list")
	public void print_the_response_body() {
		System.out.println("\n\n" + response.jsonPath().getString("data"));
	}


}