package AccountDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sun.corba.se.spi.orbutil.fsm.Input;

public class AccountDemoPageFactory {

	WebDriver driver;

	public AccountDemoPageFactory(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public AccountDemoPageFactory() {

	}
 
	@FindBy(xpath="/html/body/center/h1")
	@CacheLookup
	String actualHeading;
	
	public String getActualHeading() {
		return actualHeading;
	}

	public void setActualHeading(String actualHeading) {
		this.actualHeading = actualHeading;
	}

	@FindBy(id = "txtN")
	@CacheLookup
	WebElement fname;

	@FindBy(name = "phno")
	@CacheLookup
	WebElement mobile;

	@FindBy(id = "txtEi")
	@CacheLookup
	WebElement email;

	@FindBy(name = "gender")
	@CacheLookup
	WebElement gender;

	@FindBy(xpath = "//textarea[@rows='6']")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.ID, using = "btn")
	@CacheLookup
	WebElement button;

	// getters and setters

	// Setters

	public void setFname(String name) {
		fname.sendKeys(name);
	}

	public void setMobile(String mobileNo) {
		mobile.sendKeys(mobileNo);
		
	}

	public void setEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void setGender(String genderTxn) {
		gender.click();
	}

	public void setAddress(String addressTxn) {
		address.sendKeys(addressTxn);
	}

	public void setButton() {
		button.click();
	}

	// Getters
	public WebElement getFname() {
		return fname;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getButton() {
		return button;
	}
}
