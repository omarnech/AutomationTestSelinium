package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
WebDriver driver; 
	
	public ProductPage (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']/h2")
	private WebElement productSearchedName; 
	@FindBy(xpath="http://tutorialsninja.com/demo/index.php?route=product/product&path=20_27&product_id=41")
	private WebElement productSearchedLink; 
	@FindBy(id="input-quantity")
	private WebElement productQuatityToBeChoosenBoxs; 
	@FindBy (id="button-cart")
	private WebElement buttonCart; 
	@FindBy (xpath="//div[@class='col-sm-4']/h1")
	private WebElement productPageDetailsDesplayed; 
	
	@FindBy (xpath="//i[@class='fa fa-shopping-cart']//following-sibling::span")
	private WebElement shoppingCartProduct; 
	public String ProductSearchedIsDesplayed() {
		return productSearchedName.getText(); 	}


    public void ClickOnProductSearchedLink() { 
    	productSearchedLink.click();
    }
    public void EnterProductQuantity(Integer int1) {
    	productQuatityToBeChoosenBoxs.clear(); 
    	productQuatityToBeChoosenBoxs.sendKeys(int1.toString());
    	}
    public void ClickOnButtonCart() { 
    	buttonCart.click();
    }
    public String ProductPageDetailsIsDesplayed() {
		return productPageDetailsDesplayed.getText(); 	}

    public String ProductShownInTheShoppinCart() {
		return shoppingCartProduct.getText(); 	}
    }