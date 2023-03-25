package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class Add_A_Product {
	
	WebDriver driver; 
	private HomePage homePage; 
	private ProductPage productPage; 
	
	@Given("User login Application with valid  email address {string} and valid password {string}")
	public void user_login_application_with_valid_email_address_and_valid_password(String emailText, String passwordText) {
		driver = DriverFactory.getDriver(); 
	    LoginPage loginPage = new LoginPage(driver); 
	    homePage = new HomePage(driver); 
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		loginPage.enterEmailAddress(emailText);
		loginPage.enterPassword(passwordText);
        loginPage.clickLoginButton();
	}

	@When("User hover over Descktops")
	public void user_hover_over_descktops() {
		homePage.HoverOverDescktop(); }

	@When("User click on Mac")
	public void user_click_on_mac() {
		homePage.ClickOnMacLink();
	}

	@Then("User should get valid product Mac displayed in search results")
	public void user_should_get_valid_product_mac_displayed_in_search_results() {
		productPage = new ProductPage(driver); 
		Assert.assertTrue(productPage.ProductSearchedIsDesplayed().contains("Mac"));
	}
/*
	@When("User click on iMac")
	public void user_click_on_i_mac() {
		productPage.ClickOnProductSearchedLink();
	}

	@Then("The details about the iMac are shown")
	public void the_details_about_the_i_mac_are_shown() {
	   Assert.assertTrue(productPage.ProductPageDetailsIsDesplayed().contains("iMac"));
	}

	@When("User enter {int} as the number of iMac to be purchased")
	public void user_enter_as_the_number_of_i_mac_to_be_purchased(Integer int1) {
	    productPage.EnterProductQuantity(int1);
	}

	@When("User click on Add To Card")
	public void user_click_on_add_to_card() {
	    productPage.ClickOnButtonCart();
	}

	@Then("the number of iMac choosen and the total price is shown in the items box")
	public void the_number_of_i_mac_choosen_and_the_total_price_is_shown_in_the_items_box(Integer int1) {
	
Assert.assertTrue(productPage.ProductShownInTheShoppinCart().contains(int1.toString()+"item(s)"));	} */
}

