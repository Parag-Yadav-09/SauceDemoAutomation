package pageClass;

import utilities.SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductPage extends TestBase {

    public static WebDriver driver;
    SeleniumUtils seleniumUtils;

    @FindBy(xpath = "//span[input[@id='add-to-cart-button']]")
    private WebElement addToCartButton;
    
    @FindBy(xpath = "//span[contains(@class,'offer-price')]")
    private WebElement productPrice;
    
    @FindBy(xpath = "//span[contains(@class,'a-color-price hlb-price a-inline-block a-text-bold')]")
    private WebElement productPriceOnProceedToBuyScreen; 
    
    @FindBy(xpath = "//span[a[@id='hlb-view-cart-announce']]")
    private WebElement cartButton;     

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton(){
        seleniumUtils.click(addToCartButton);
    }
    
    public String getProductPriceFromProductDetailsScreen() {
    	return seleniumUtils.getText(productPrice);
    }
    
    public String getProductPriceFromProceedToBuyScreen() {
    	return seleniumUtils.getText(productPriceOnProceedToBuyScreen);
    }
    
    public void clickCartButton(){
        seleniumUtils.click(cartButton);
    }

}
