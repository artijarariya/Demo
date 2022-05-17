package TestRunnerF;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/Page.feature", glue = { "pagestepdef" },
plugin= {"pretty","html:target/cucumberReports/report.html","json:target/cucumberReports/report.json"})

public class PageRunner {

}
