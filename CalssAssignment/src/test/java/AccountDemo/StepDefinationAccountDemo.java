package AccountDemo;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinationAccountDemo {
	 static WebDriver driver =null;

	 static AccountDemoPageFactory accountFact =null;

	@Given("^User is on AccountPage$")
	public void user_is_on_AccountPage() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shipkuma\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/shipkuma/Documents/MODULE_3/Account.html");
		accountFact = new AccountDemoPageFactory(driver);
	}

	@Then("^user verify the heading of the Form$")
	public void user_verify_the_heading_of_the_Form() {
		
		if(accountFact.getActualHeading().equals("Account Form")) {
			System.out.println("match");
		}else {
			System.out.println("not matched");
		}
		// Write code here that turns the phrase above into concrete actions

	}
	

	@When("^user enter valid data$")
	public void user_enter_valid_data() {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname("Ashin");
		accountFact.setMobile("9939033389");
		accountFact.setEmail("as@gmail.com");
		accountFact.setGender("Female");
		accountFact.setAddress("Chennai");
		accountFact.setButton();
	}

	@Then("^display success message$")
	public void display_success_message() {
		System.out.println("success");

	}


	@When("^user does not enter the name$")
	public void user_does_not_enter_the_name() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname(" ");
		Thread.sleep(1000);
	

	}

	@When("^user click the submit button$")
	public void user_click_the_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setButton();
	}

	@Then("^display the pop uop message(\\d+)$")
	public void display_the_pop_uop_message()  {
	    System.out.println("filed can't be empty");
	   
	}

	
	@Then("^display pop up  message$")
	public void display_pop_up_message() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^user does not enter the mobile number$")
	public void user_does_not_enter_the_mobile_number() {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname("Ashin");
		accountFact.setMobile("");
		accountFact.setButton();

	}
/*
	@Then("^display pop up message$")
	public void display_pop_up_message1() {
		// Write code here that turns the phrase above into concrete actions

	}*/

	@When("^user does not enter the email$")
	public void user_does_not_enter_the_email() {
		// Write code here that turns the phrase above into concrete actions

		accountFact.setFname("Ashin");
		accountFact.setMobile("9939033389");
		accountFact.setEmail("");
		accountFact.setEmail("");
	}

	/*@Then("^display the pop uop message$")
	public void display_the_pop_uop_message() {
		// Write code here that turns the phrase above into concrete actions

	}*/

	@When("^user does not enter the address$")
	public void user_does_not_enter_the_address() {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname("Ashin");
		accountFact.setMobile("9939033389");
		accountFact.setEmail("as@gmail.com");
		accountFact.setAddress("");

	}
/*
	@Then("^display the pop up message$")
	public void display_the_pop_up_message() {
		// Write code here that turns the phrase above into concrete actions

	}*/

	@When("^user enter the invalid name$")
	public void user_enter_the_invalid_name() {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname("2454");
		accountFact.setButton();

	}

	@Then("^display the error message$")
	public void display_the_error_message() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^user enter the invalid mobile number$")
	public void user_enter_the_invalid_mobile_number(DataTable arg1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		accountFact.setFname("Ashin");
		// accountFact.setMobile("1323412464");

		List<String> mobList = arg1.asList(String.class);
		String data = null;
		for (String mobNo : mobList) {
			data = mobNo;
			accountFact.getMobile().clear();
			accountFact.setMobile(mobNo);
			Thread.sleep(1000);
			accountFact.setButton();
			if (Pattern.matches("[6-9][0-9]{9}", data)) {
				System.out.println("matching");
			} else {
				driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println("not matched");
			}
		}

	}

	/*@When("^user click the submit button$")
	public void user_click_the_submit_button(DataTable arg1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

	}*/
/*
	@Then("^display the err message$")
	public void display_the_err_message() {
		// Write code here that turns the phrase above into concrete actions
	}*/

	@When("^user enters invalid email$")
	public void user_enters_invalid_email(DataTable arg1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname("Ashin");
		accountFact.setMobile("9939033389");
		List<String> eList = arg1.asList(String.class);
		String data = null;
		for (String mailList : eList) {
			data = mailList;
			accountFact.getEmail().clear();
			accountFact.setEmail(mailList);
			Thread.sleep(1000);
			accountFact.setButton();
			if (Pattern.matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+", data)) {
				System.out.println("matching");
			}else {
				driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println("not matched");
			}
		}
	}
/*
	@When("^clicks submit button$")
	public void clicks_submit_button(DataTable arg1) throws InterruptedException {
		

	}*/

	@When("^user enter invalid address$")
	public void user_enter_invalid_address(DataTable arg1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		accountFact.setFname("Ashin");
		accountFact.setMobile("9939033389");
		accountFact.setEmail("ass@gmail.com");
		accountFact.setGender("Female");
		accountFact.setAddress("$$%@^");
		accountFact.setButton();
		if(Pattern.matches("[[A-Za-z]{5,50}]",(CharSequence) accountFact.getAddress())) {
			System.out.println("matched");
			
		}else {
			driver.switchTo().alert().getText();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			System.out.println("not matched");
		}

	}

	/*@Then("^display error message$")
	public void display_error_message() {
		// Write code here that turns the phrase above into concrete actions

	}*/

}
