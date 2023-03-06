package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;


public class Search {

	
	WebDriver driver; 
	private HomePage homePage; 
	@Given("User opens Application")
	public void user_opens_application() {
		 driver = DriverFactory.getDriver();
		 
		homePage = new HomePage(driver); 
		 homePage.clickOnMyAccount();
		 homePage.selectLoginOption();
		  	 
	}

	@When("User enters valid product {string} into search bow field")
	public void user_enters_valid_product_into_search_bow_field(String ValidProductText) {
	    
		HomePage homePage = new HomePage(driver);  
		homePage.searchBoxField(ValidProductText);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		homePage.clickOnSearchButton();
	
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		SearchPage searchPage = new SearchPage(driver); 
		Assert.assertTrue(searchPage.validProductDisplayed());
	}


	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
	   
            homePage.searchBoxField(invalidProductText);	
       }

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		SearchPage searchPage = new SearchPage(driver); 
		Assert.assertTrue(searchPage.noProductMatchinAlert().contains("There is no product that matches the search criteria."));
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		homePage = new HomePage(driver); 
		
	}
}
