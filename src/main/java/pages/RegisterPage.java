package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver; 
	public RegisterPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="input-firstname")
	private WebElement firstnamefield; 
	
	@FindBy (id="input-lastname")
	private WebElement lastnamefield; 
	
	@FindBy (id="input-email")
	private WebElement emailfield; 
	
	@FindBy (id="input-telephone")
	private WebElement telephonefield; 
	
	@FindBy (id="input-password")
	private WebElement passwordfield; 
	
	@FindBy (name="agree")
	private WebElement privacypolicyfield; 
	
	@FindBy (id="input-confirm")
	private WebElement confirmpasswordfield; 
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement clickcontinuebutton; 
	
	@FindBy(xpath="//input[@name='newsletter']")
	private WebElement newsletteryes; 
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement warningduplicateemail; 
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement alertprivacypolicy;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement alertfirstnamerequired;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement alertlastnamerequired;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement alertemailrequired;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement alerttelephonerequired;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement alertpasswordrequired;
	
	
	
	public void  enterFirstName (String firstNameText) {
		firstnamefield.sendKeys(firstNameText);
	}
	public void  enterLastName (String lastNameText) {
		lastnamefield.sendKeys(lastNameText);
	}
	public void  enterEmail (String emailAdressText) {
		emailfield.sendKeys(emailAdressText);
	}
	public void  enterTelephone (String telephoneText) {
		telephonefield.sendKeys(telephoneText);
	}
	public void  enterPassword (String passwordText) {
		passwordfield.sendKeys(passwordText);
	}
	
	public void  enterConfirmPassword (String passwordText) {
		confirmpasswordfield.sendKeys(passwordText);
	}
	public void  clickPrivacyPolicy () {
		privacypolicyfield.click();
	}
	public void  clickContinueButton () {
		clickcontinuebutton.click();
	}
	public void  newsletterYesClick () {
		newsletteryes.click();
	}
	
	public String  checkForWarningDuplicateEmail() {
		return warningduplicateemail.getText();
	}
	
	public String  checkForWarninPrivatePolicyField() {
		return alertprivacypolicy.getText();
	}
	public String  checkForWarninFirstNameField() {
		return alertfirstnamerequired.getText();
	}
	public String  checkForWarninLastNameField() {
		return alertlastnamerequired.getText();
	}
	public String  checkForWarninEmailField() {
		return alertemailrequired.getText();
	}
	public String  checkForWarninTelephoneField() {
		return alerttelephonerequired.getText();
	}
	public String  checkForWarninPasswordField() {
		return alertpasswordrequired.getText();
	}
	
}
