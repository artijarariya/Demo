package testrunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.core.cli.Main;
import utility.ConfigFileReader;

public class ExecuteFeatures {
	/**
	 * Class for generating html report with time-stamp
	 */

	public static void main(String[] args) throws Throwable {

		String s = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		Main.main(new String[] { "-g", "stepdefinitions", ConfigFileReader.getProperties("featureFilepath"), "-p",
				"pretty", "-p", "html:target/reports" + s + "/HTML_reports.html", "-p",
				"json:target/reports" + s + "/cucumber.json", "-p",
				"junit:target/reports" + s + "/cucumber.xml"
		});

	}

}
