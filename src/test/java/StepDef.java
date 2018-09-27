
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {

	public String key = Constants.LocalHostURL;
	public String url = "";
	public String objID = "";
	public String lastName = "";
	
	//private WebDriver driver;

	RequestSpecification request;
	Response response;
	
	ExtentReports report;
	ExtentTest test;
	
	static int count = 0;
	
	@Before
	public void setUp() {
		
		count++;
		
		report = TestRunner.report;
		
		test = report.startTest("PetClinicTest" + count);
//  Sel    System.setProperty("webdriver.chrome.driver", Constants.DriverPath);		
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
	
	@After
	public void teardown() throws InterruptedException {
		
//		Thread.sleep(3000);
//		driver.close();
		report.endTest(test);
		report.flush();
		
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	////////////////GIVENS////////////////////////
	
	@Given("^Base URI is valid \"([^\"]*)\"$")
	public void base_URI_is_valid(String arg1) {
	    
		url = key + arg1;
		RestAssured.baseURI = url;
		test.log(LogStatus.INFO, "base URI set");
		
	}

	@Given("^request content-type is \"([^\"]*)\"$")
	public void request_content_type_is(String contentType) {

		request = RestAssured.given();
		
		request.header("Accept", contentType);
		test.log(LogStatus.INFO, "content-type set");
		
	}
	
	@Given("^ID is \"([^\"]*)\"$")
	public void id_is(String arg1) throws Throwable {

		objID = arg1;
		
		url += arg1;
		RestAssured.baseURI = url;
		test.log(LogStatus.INFO, "base URI set:" + url);
		
	}

//	@Given("^Last Name is \"([^\"]*)\"$")
//	public void last_Name_is(String arg1) throws Throwable {
//
//		lastName = arg1;
//		//incomplete
//		
//	}

	///////////////CRUD COMMANDS//////////////////
	
	@When("^post the request$")
	public void post_the_request() throws Throwable {

		response = request.post("/");
		test.log(LogStatus.INFO, "POST request sent");
		test.log(LogStatus.INFO, response.body().prettyPrint());
		
	}
	
	@When("^get request method is called$")
	public void get_request_method_is_called() throws Throwable {

		response = request.get("/");
		test.log(LogStatus.INFO, "GET request sent");
		
		if(!response.body().equals(null)) {
			
			test.log(LogStatus.PASS, "response content: " + response.prettyPrint());
			
		} else {
			
			test.log(LogStatus.FAIL, "Record not found");
			
		}
		
		System.out.println(response.asString());
		
	}

	@When("^I delete a record$")
	public void i_delete_a_record() throws Throwable {
		
		request.body(2);
		response = request.delete("/");
		test.log(LogStatus.INFO, "DELETE request sent");
		throw new PendingException();
		
	}

	@When("^put request method is called$")
	public void put_request_method_is_called() {
	    
		response = request.put("/");
		test.log(LogStatus.INFO, "PUT request sent");
	}

	///////////////JSON FORMATTING///////////////////
	////JSON////
	
	@When("^valid user JSON is created and passed to request body$")
	public void valid_user_JSON_is_created_and_passed_to_request_body() throws JSONException {
	    
		JSONObject requestParams = new JSONObject();
		JSONArray role = new JSONArray();
		JSONObject roles = new JSONObject();
		
		roles.put("id", 0);
		roles.put("name", "ROLE_string");

		role.put(roles);
		
		requestParams.put("username", "stringy");
		requestParams.put("password", "string");
		requestParams.put("enabled", true);
		requestParams.put("roles", role);
		
		test.log(LogStatus.INFO, "request body: " + requestParams.toString());
		request.body(requestParams.toString());
		
	}
	
	@When("^valid owner JSON is created and passed to request body$")
	public void valid_owner_JSON_is_created_and_passed_to_request_body() throws Throwable {
		throw new PendingException();
	}
	
	@When("^valid vet JSON is created and passed to request body$")
	public void valid_vet_JSON_is_created_and_passed_to_request_body() throws JSONException {

		System.out.println("vet JSON");
		
		JSONObject requestParams = new JSONObject();
		JSONArray spec = new JSONArray();
		JSONObject speci = new JSONObject();
		JSONObject speci2 = new JSONObject();
		
		speci.put("id", 0);
		speci.put("name", "radiology");
		speci2.put("id", 2);
		speci2.put("name", "surgery");
		
		spec.put(speci);
		spec.put(speci2);
		
		requestParams.put("firstName", "me");
		requestParams.put("id", 0);
		requestParams.put("lastName", "me");
		requestParams.put("specialties", spec);
		
		test.log(LogStatus.INFO, "request body: " + requestParams.toString());
		request.body(requestParams.toString());
		
	}

	@When("^valid visit JSON is created and passed to request body$")
	public void valid_visit_JSON_is_created_and_passed_to_request_body() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^valid pet JSON is created and passed to request body$")
	public void valid_pet_JSON_is_created_and_passed_to_request_body() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^valid pet types JSON is created and passed to request body$")
	public void valid_pet_types_JSON_is_created_and_passed_to_request_body() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^valid speciality JSON is created and passed to request body$")
	public void valid_speciality_JSON_is_created_and_passed_to_request_body() throws Throwable {
		
		System.out.println("spec JSON");
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("id", 7);
		requestParams.put("name", "spesh");
		
		test.log(LogStatus.INFO, "request body: " + requestParams.toString());
		request.body(requestParams.toString());
		
	}


	////JSON with ID specified////

	@When("^valid owner JSON with id \"([^\"]*)\" is created and passed to request body$")
	public void valid_owner_JSON_with_id_is_created_and_passed_to_request_body(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@When("^valid vet JSON with id \"([^\"]*)\" is created and passed to request body$")
	public void valid_vet_JSON_with_id_is_created_and_passed_to_request_body(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^valid visit JSON with id \"([^\"]*)\" is created and passed to request body$")
	public void valid_visit_JSON_with_id_is_created_and_passed_to_request_body(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^valid pet JSON with id \"([^\"]*)\" is created and passed to request body$")
	public void valid_pet_JSON_with_id_is_created_and_passed_to_request_body(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^valid pettypes JSON with id \"([^\"]*)\" is created and passed to request body$")
	public void valid_pettypes_JSON_with_id_is_created_and_passed_to_request_body(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^valid speciality types JSON with id \"([^\"]*)\" is created and passed to request body$")
	public void valid_speciality_types_JSON_with_id_is_created_and_passed_to_request_body(String arg1) throws Throwable {

		JSONObject json = new JSONObject();
		
		json.put("id", arg1);
		json.put("name", "spesh");
		
		request.body(json.toString());
		
	}

	//////////////////THENS - VERIFY//////////////////////

	@Then("^response code should read (\\d+)$")
	public void response_code_should_read(int arg1) {

		if (response.statusCode() == arg1) {
			
			test.log(LogStatus.PASS, "request status code: " +  response.statusCode());
			
		} else {
			
			test.log(LogStatus.FAIL, "expected status code: " + arg1);
			test.log(LogStatus.INFO, "unexpected status code: " + response.statusCode());
			
		}
		
	}
	
	@Then("^response body is not null$")
	public void response_body_is_not_null() {

		if (!response.body().equals(null)) {
			
			test.log(LogStatus.PASS, "Response body not null, as expected.");
			
		}
		
	}
	
}
