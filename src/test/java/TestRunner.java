
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.relevantcodes.extentreports.ExtentReports;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")

public class TestRunner {

	public static ExtentReports report = new ExtentReports(Constants.ReportLoc, true);
	
}