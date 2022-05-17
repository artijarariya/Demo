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

public class Put {
	private String filepath = "./excelFiles/PUT.xlsx";
	private String baseUrl = null;
	private String endpoint = null;
	private String body = null;
	private int statusCode = 0;
	private int userId = 0;
	private Response response = null;

	@Given("retrive data from {string} and {int} for PUT")
	public void retrive_data_from_and_for_put(String sheet_name, Integer row_number)
			throws InvalidFormatException, IOException {
		ExcelReaderFile reader = new ExcelReaderFile();
		List<Map<String, String>> getRequest = reader.getData(filepath, sheet_name);

		baseUrl = getRequest.get(row_number).get("baseUrl");
		endpoint = getRequest.get(row_number).get("endpoint");
		body = getRequest.get(row_number).get("body");
		userId = Integer.parseInt(getRequest.get(row_number).get("userId"));
		statusCode = Integer.parseInt(getRequest.get(row_number).get("statusCode"));
	}

	@When("user call baseUrl with endpoint and userId for PUT")
	public void user_call_base_url_with_endpoint_and_user_id_for_put() {
		RestAssured.baseURI = baseUrl;
		this.response = given().header("Content-type", "application/json").and().body(this.body).when()
				.put(this.endpoint + "" + userId).then().extract().response();
	}

	@Then("verify statusCode with excel file for PUT")
	public void verify_status_code_with_excel_file_for_put() {
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@And("print the response body for PUT")
	public void print_the_response_body_for_put() {
		System.out.println("\n\nUpdatedAt: " + response.jsonPath().getString("updatedAt") + "\n\n");
	}


}
