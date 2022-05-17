package stepdefinitions;

import static io.restassured.RestAssured.baseURI;
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
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ConfigFileReader;
import utility.ExcelReader;

public class GET_single_user_request {

	/**
	 * Step Definitions for GET request for getting single user Variables: -
	 * FILEPATH : getting data from given excel file
	 * 
	 */

	private final String FILEPATH = ConfigFileReader.getProperties("getRequestFilepath");
	private String baseUrl = null;
	private String endpoint = null;
	private String userId = null;
	private int statusCode = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for GET")
	public void retrive_data_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		/* instantiating ExcelReader class for reading data from given excel sheet */
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> getRequest = reader.getData(FILEPATH, sheetName);

		/* using row number and cell name for getting data from specific cell */
		baseUrl = getRequest.get(rowNumber).get("baseUrl");
		endpoint = getRequest.get(rowNumber).get("endpoint");
		userId = getRequest.get(rowNumber).get("userId");
		statusCode = Integer.parseInt(getRequest.get(rowNumber).get("responseCode"));
	}

	@When("user call baseUrl with endpoint and userId for GET")
	public void user_call_base_url_with_endpoint_and_user_id() {
		/* setting up the base-url */
		RestAssured.baseURI = baseUrl;
		/* calling get request and extracting response from it */
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(baseURI)
				.addFilter(new ResponseLoggingFilter()).build();

		response = given().spec(reqSpec).contentType(ContentType.JSON).when().get(endpoint + "" + userId).then().extract().response();
	}

	@Then("verify statusCode and userId with excel file for GET")
	public void verify_status_code_with_excel_file() {
		/* verifying response status code with excel status code */
		Assert.assertEquals(statusCode, response.statusCode());
		/* verifying response user id with excel data */
		Assert.assertEquals(userId, response.jsonPath().getString("data.id"));
	}

	@Then("print the response body for GET")
	public void print_the_response_body() {
		System.out.println(
				"\n\n" + response.jsonPath().getString("data.id") + " " + response.jsonPath().getString("data.email"));
		

//		FilterableRequestSpecification requestSpec = null;
//		FilterableResponseSpecification responseSpec = (FilterableResponseSpecification) this.response;
//		FilterContext ctx = null;
//		
//		Response response = ctx.next(requestSpec, responseSpec);
//		final int statusCode = response.statusCode();
//
//		final ByteArrayOutputStream responseLog = new ByteArrayOutputStream();
//		final PrintStream stream = new PrintStream(responseLog);
//
//		ResponsePrinter.print(response, response, stream, LogDetail.ALL, true, null);
	}

}