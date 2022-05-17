package stepdefinitions;

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
import io.restassured.response.Response;
import utility.ConfigFileReader;
import utility.ExcelReader;

public class PATCH_request {
	
	/**
	 * Step Definitions for PATCH request
	 * 	Variables: 	
	 * 		-	FILEPATH : getting data from given excel file
	 * 		
	 */

	private final String FILEPATH = ConfigFileReader.getProperties("patchRequestFilepath");
	private String baseUrl = null;
	private String endpoint = null;
	private String body = null;
	private int statusCode = 0;
	private int userId = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for PATCH")
	public void retrive_data_from_and_for_patch(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		/* instantiating ExcelReader class for reading data from given excel sheet */
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> getRequest = reader.getData(FILEPATH, sheetName);

		/* using row number and cell name for getting data from specific cell */
		baseUrl = getRequest.get(rowNumber).get("baseUrl");
		endpoint = getRequest.get(rowNumber).get("endpoint");
		body = getRequest.get(rowNumber).get("body");
		userId = Integer.parseInt(getRequest.get(rowNumber).get("userId"));
		statusCode = Integer.parseInt(getRequest.get(rowNumber).get("statusCode"));
	}

	@When("user call baseUrl with endpoint and userId for PATCH")
	public void user_call_base_url_with_endpoint_and_user_id_for_patch() {
		/* setting up the base-url */
		RestAssured.baseURI = baseUrl;
		/* calling patch request and extracting response from it */
		this.response = given().header("Content-type", "application/json").and().body(this.body).when()
				.patch(this.endpoint + "" + userId).then().extract().response();
	}

	@Then("verify statusCode with excel file for PATCH")
	public void verify_status_code_with_excel_file_for_patch() {
		/* verifying response status code with excel status code */
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@And("print the response body for PATCH")
	public void print_the_response_body_for_patch() {
		System.out.println("\n\nUpdatedAt: " + response.jsonPath().getString("updatedAt") + "\n\n");
	}

}
