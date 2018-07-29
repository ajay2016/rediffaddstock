package runner;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)

@CucumberOptions(
	
		//location of feature file and step definition file and plug in for reports
	features = {"src\\test\\java\\features\\"},
	glue = {"stepdefinitions\\"},
	monochrome = true,	
	tags = {"@Staging"},
	plugin = {"pretty", "html:target/cucumber-html", "json:target/cucumber-json/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extents/report.html"}
	
)


public class Runner extends AbstractTestNGCucumberTests {

}
