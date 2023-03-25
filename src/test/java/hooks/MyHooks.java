package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import factory.DriverFactory;
import io.cucumber.java.*;
import utils.ConfigReader;


public class MyHooks {

	WebDriver driver; 
	
	@Before
	public void setup() {
		Properties prop = ConfigReader.initializeProperties(); 
		DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory.getDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get(prop.getProperty("url"));
		Actions actions = new Actions(driver); 
	}
	

	@After
	public void tearDown() { 
		driver.quit(); 
	}

}
