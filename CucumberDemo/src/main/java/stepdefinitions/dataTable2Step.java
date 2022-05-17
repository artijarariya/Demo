package stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dataTable2Step {

	@Given("user is on registration page")
	public void user_is_on_registration_page() {
		System.out.println("User navigates on registration page");

	}

	@When("user enters following user details")
	public void user_enters_following_user_details(DataTable dataTable) {
		List<List<String>> userList = dataTable.asLists(String.class);
		for (List<String> e : userList) {
			System.out.println(e);
		}
	}

	@When("user enters following user details with collumns")
	public void user_enters_following_user_details_with_collumns(DataTable dataTable) {
		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
		// System.out.println(userMap);
		for (Map<String, String> e : userList) {
			System.out.println(e.get("firstname"));
			System.out.println(e.get("lastname"));
			System.out.println(e.get("email"));
			System.out.println(e.get("phone"));
			System.out.println(e.get("location"));
		}

	}

	@And("click on OK button")
	public void click_on_ok_button() {

	}

	@Then("registration is successful")
	public void registration_is_successful() {
		System.out.println("User registration is successful");

	}

}
