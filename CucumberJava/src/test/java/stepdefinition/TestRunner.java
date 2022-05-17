package stepdefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/pom.feature", glue = { "stepdefinitions" }, monochrome = true,
plugin = {"pretty", "html:target/reports/cucumber.html", "pretty", "json:target/reports/cucumber.json", "pretty","junit:target/reports/cucumber.xml", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner {

}
