package stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/datatable1.feature", glue = { "stepdefinitions" },
plugin= {"pretty","html:target/cucumberReports/report.html","json:target/cucumberReports/report.json"})

//tags={"@Smoke"}
//tags={"@hooks or @hooks1"}
//tags={"@hooks and @hooks1"}

public class TestRunner {

}
