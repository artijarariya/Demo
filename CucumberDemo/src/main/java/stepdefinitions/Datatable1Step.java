package stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Datatable1Step {
	@Given("user navigate to the login page")
	public void user_navigate_to_the_login_page() {
	    
	}
	@When("user click register")
	public void user_click_register() {
	    
	}
	@When("user enter self details as")
	public void user_enter_self_details_as(io.cucumber.datatable.DataTable dataTable) {
	    System.out.println("print data:"+dataTable.asLists().get(1).get(0));
	    System.out.println("print data:"+dataTable.asLists().get(1).get(1));
	    System.out.println("print data:"+dataTable.asLists().get(2).get(0));
	    System.out.println("print data:"+dataTable.asLists().get(2).get(1));
	}
	
	@When("user enter self details as Map")
	public void user_enter_self_details_as_map(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
		// System.out.println(userMap);
		for (Map<String, String> e : userList) {
			System.out.println(e.get("username"));
			System.out.println(e.get("password"));
			
			
		}
	}
	@When("click submit button")
	public void click_submit_button() {
	}
	@Then("meassage displayed successfully creation of email")
	public void meassage_displayed_successfully_creation_of_email() {
	   
	}
}
