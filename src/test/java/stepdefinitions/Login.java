package stepdefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver; 
	private LoginPage loginPage; 
	 

	@Given("User has navigates to login page")
	public void User_has_navigates_to_login_page() {

		driver = DriverFactory.getDriver(); 
		HomePage homePage = new HomePage(driver); 
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
	}

	@When("User has entered valid email address {string}")
	public void user_has_entered_valid_email_address(String emailText) {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(emailText);
	    
	
		
	}

	@And("User has entered valid password {string}")
	public void user_has_entered_valid_password(String passwordText) {
		loginPage.enterPassword(passwordText);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	   
	}

	@Then("User should get succedfully login in")
	public void user_should_get_succedfully_login_in() {
	    
		AccountPage accountPage = new AccountPage(driver); 
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email adress into email fiels")
	public void user_enters_invalid_email_adress_into_email_fiels() {
		
		loginPage = new LoginPage(driver); 
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());

	}

	@When("User enters inavalid password {string} into password field")
	public void user_enters_inavalid_password_into_password_field(String invalidPasswordText) {
	   loginPage.enterPassword(invalidPasswordText);

	}

	@Then("User should get a warning message about credentials mismatch")
	public void user_should_get_a_warning_message_about_credentials_mismatch() {
		
	    Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter any email adress into email field")
	public void user_dont_enter_any_email_adress_into_email_field() {
		
		loginPage = new LoginPage(driver); 
		loginPage.enterEmailAddress("");

	}

	@When("User dont enter any password into password field")
	public void user_dont_enter_any_password_into_password_field() {
		loginPage.enterPassword("");

	}
	
	
}
