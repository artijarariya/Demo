package stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ConfigFileReader;
import utility.ExcelReader;

public class DELETE_request {

	/**
	 * Step Definitions for DELETE request Variables: - FILEPATH : getting data from
	 * given excel file
	 * 
	 */

	private final String FILEPATH = ConfigFileReader.getProperties("deleteRequestFilepath");
	private String baseUrl = null;
	private String endpoint = null;
	private int statusCode = 0;
	private int userId = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for DELETE")
	public void retrive_data_from_and_for_delete(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		/* instantiating ExcelReader class for reading data from given excel sheet */
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> getRequest = reader.getData(FILEPATH, sheetName);

		/* using row number and cell name for getting data from specific cell */
		baseUrl = getRequest.get(rowNumber).get("baseUrl");
		endpoint = getRequest.get(rowNumber).get("endpoint");
		userId = Integer.parseInt(getRequest.get(rowNumber).get("userId"));
		statusCode = Integer.parseInt(getRequest.get(rowNumber).get("statusCode"));
	}

	@When("user call baseUrl with endpoint and userId for DELETE")
	public void user_call_base_url_with_endpoint_and_user_id_for_delete() {
		/* setting up the base-url */
		RestAssured.baseURI = baseUrl;
		/* calling delete request and extracting response from it */

		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(baseURI)
				.addFilter(new ResponseLoggingFilter()).build();

		this.response = given().spec(reqSpec).header("Content-type", "application/json").when().delete(this.endpoint + "" + userId)
				.then().extract().response();
	}

	@Then("verify statusCode with excel file for DELETE")
	public void verify_status_code_with_excel_file_for_delete() {
		/* verifying response status code with excel status code */
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@And("print the response body for DELETE")
	public void print_the_response_body_for_delete() {
		System.out.println("\n\nDELETED SUCCESSFULLY\n\n");
	}

}
