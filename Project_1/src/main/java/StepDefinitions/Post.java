package StepDefinitions;

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
import utilities.ExcelReaderFile;

public class Post {
	private String filepath = "./excelFiles/POST.xlsx";
	private String baseUrl = null;
	private String endpoint = null;
	private String body = null;
	private int statusCode = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for POST")
	public void retrive_data_from_and_for_post(String sheet_name, Integer row_number)
			throws InvalidFormatException, IOException {
		ExcelReaderFile reader = new ExcelReaderFile();
		List<Map<String, String>> getRequest = reader.getData(filepath, sheet_name);

		baseUrl = getRequest.get(row_number).get("baseUrl");
		endpoint = getRequest.get(row_number).get("endpoint");
		body = getRequest.get(row_number).get("body");
		statusCode = Integer.parseInt(getRequest.get(row_number).get("statusCode"));
	}

	@When("user call baseUrl with endpoint and userId for POST")
	public void user_call_base_url_with_endpoint_and_user_id_for_post() {
		RestAssured.baseURI = baseUrl;
		this.response = given().header("Content-type", "application/json").and().body(this.body).when()
				.post(this.endpoint).then().extract().response();
	}

	@Then("verify statusCode with excel file for POST")
	public void verify_status_code_with_excel_file_for_post() {
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@And("print the response body for POST")
	public void print_the_response_body_for_post() {
		System.out.println("\n\nCreated with id: " + response.jsonPath().getString("id"));
	}
}
