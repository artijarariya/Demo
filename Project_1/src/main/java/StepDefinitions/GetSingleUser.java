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

public class GetSingleUser {
	
	private String filepath = "./excelFiles/GET.xlsx";
	private String baseUrl = null;
	private String endpoint = null;
	private String userId = null;
	private int statusCode = 0;
	private Response response = null;
	
	
	@Given("retrive data from {string} and {int} for GET")
	public void retrive_data_from_and_for_get(String sheet_name, Integer row_number) throws InvalidFormatException, IOException {
		ExcelReaderFile reader = new ExcelReaderFile();
		List<Map<String, String>> getRequest = reader.getData(filepath, sheet_name);

		baseUrl = getRequest.get(row_number).get("baseUrl");
		endpoint = getRequest.get(row_number).get("endpoint");
		userId = getRequest.get(row_number).get("userId");
		statusCode = Integer.parseInt(getRequest.get(row_number).get("responseCode"));
	}

	@When("user call baseUrl with endpoint and userId for GET")
	public void user_call_base_url_with_endpoint_and_user_id_for_get() {
		RestAssured.baseURI = baseUrl;
		response = given().contentType(ContentType.JSON).when().get(endpoint + "" + userId).then().extract().response();
	}

	@Then("verify statusCode and userId with excel file for GET")
	public void verify_status_code_and_user_id_with_excel_file_for_get() {
		Assert.assertEquals(statusCode, response.statusCode());
		Assert.assertEquals(userId, response.jsonPath().getString("data.id"));
	}

	@Then("print the response body for GET")
	public void print_the_response_body_for_get() {
		System.out.println("\n\n" + response.jsonPath().getString("data.id") + " " + response.jsonPath().getString("data.email"));
	}


}
