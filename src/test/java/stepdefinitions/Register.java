package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;


public class Register {
	
	WebDriver driver; 
	private RegisterPage registerPage; 
	
	@Given("User has navigates to Registration Account page")
	public void user_has_navigates_to_registration_account_page() {
	    driver = DriverFactory.getDriver();
	    HomePage homePage = new HomePage(driver); 
	    homePage.clickOnMyAccount();
	    homePage.selectRegisterOption();
	    
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
	   Map<String, String> dataMap = dataTable.asMap(String.class, String.class); 
	   
	   registerPage = new RegisterPage(driver); 
	   registerPage.enterFirstName(dataMap.get("FirstName"));
	   registerPage.enterLastName(dataMap.get("LastName"));
	   registerPage.enterEmail(CommonUtils.getEmailWithTimeStamp());
	   registerPage.enterTelephone(dataMap.get("Telephone"));
	   registerPage.enterPassword(dataMap.get("Password"));
	   registerPage.enterConfirmPassword(dataMap.get("Password"));
	   
	}

	@When("User enters the details into the below fields with exist email")
	public void user_enters_the_details_into_the_below_fields_with_exist_email(DataTable dataTable) {
	   Map<String, String> dataMap = dataTable.asMap(String.class, String.class); 
	   

	   registerPage = new RegisterPage(driver); 
	   registerPage.enterFirstName(dataMap.get("FirstName"));
	   registerPage.enterLastName(dataMap.get("LastName"));
	   registerPage.enterEmail(dataMap.get("E-mail"));
	   registerPage.enterTelephone(dataMap.get("Telephone"));
	   registerPage.enterPassword(dataMap.get("Password"));
	   registerPage.enterConfirmPassword(dataMap.get("Password"));
	   
	} 
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerPage.clickPrivacyPolicy();
	
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		registerPage.clickContinueButton();
	}

	@Then("User account sgould get created succefully")
	public void user_account_sgould_get_created_succefully() {
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver); 
		Assert.assertTrue(accountSuccessPage.ConfirmCreationAccount().contains("Your Account Has Been Created!"));
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage = new RegisterPage(driver); 
		registerPage.newsletterYesClick();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		registerPage = new RegisterPage(driver); 
		
	    Assert.assertTrue(registerPage.checkForWarningDuplicateEmail().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {

		registerPage = new RegisterPage(driver); 
		
	}


	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    
	    
	    registerPage = new RegisterPage(driver); 
	    Assert.assertTrue(registerPage.checkForWarninPrivatePolicyField().contains("Warning: You must agree to the Privacy Policy!"));
	    Assert.assertTrue(registerPage.checkForWarninFirstNameField().contains("First Name must be between 1 and 32 characters!")); 
	    Assert.assertTrue(registerPage.checkForWarninLastNameField().contains("Last Name must be between 1 and 32 characters!"));
	    Assert.assertTrue(registerPage.checkForWarninEmailField().contains("E-Mail Address does not appear to be valid!"));
	    Assert.assertTrue(registerPage.checkForWarninTelephoneField().contains("Telephone must be between 3 and 32 characters!"));
	    Assert.assertTrue(registerPage.checkForWarninPasswordField().contains("Password must be between 4 and 20 characters!"));

	    
	}
	
}
