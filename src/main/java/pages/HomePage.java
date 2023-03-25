package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	 

	WebDriver driver; 
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu; 
	
	@FindBy(linkText="Login")
	private WebElement loginOption; 
	
	@FindBy(linkText="Register")
	private WebElement registerOption; 
	
	@FindBy(name="search")
	private WebElement searchboxfield; 
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private WebElement searchbutton;
	
	@FindBy(xpath="//a[contains(text(), 'Desktops')]")
	public WebElement Desktopslink; 
	
	@FindBy(linkText="http://tutorialsninja.com/demo/index.php?route=product/category&path=20_27")
	private WebElement Maclink;
	
	public void clickOnMyAccount() { 
		myAccountDropMenu.click();
	}
	
	public void  selectLoginOption () {
		loginOption.click();
	}
	public void  selectRegisterOption () {
		registerOption.click();
	}
	public void searchBoxField(String productText) {
		searchboxfield.sendKeys(productText);
	}
	public void clickOnSearchButton() {

		searchbutton.click();
	}

   
    public void ClickOnMacLink() {
    	Maclink.click();
    }
    public void HoverOverDescktop() {
    	Actions actions = new Actions(driver); 
		actions.moveToElement(Desktopslink).build().perform();
    }
}
