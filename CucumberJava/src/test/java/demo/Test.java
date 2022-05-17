package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.core.cli.Main;

public class Test {
public static void main(String[] args) throws Throwable {
String s = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());



// Your code to get feature file full path
try {



Main.main(new String[] { "-g", "stepdefinition",
"src\\test\\resources\\Features\\logindemo.feature",
"-p", "pretty",
"-p", "html:Extent/HtmlReports" + s + "/report.html" });



} catch (Exception e) {
e.printStackTrace();
}


}
}
