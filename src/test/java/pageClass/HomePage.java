package pageClass;

import utilities.SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

    public static WebDriver driver;
    SeleniumUtils seleniumUtils;
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;
    
    @FindBy(xpath = "//span[input[@id='nav-search-submit-button']]")
    private WebElement searchButton;

    @FindBy(xpath = "//div/span[@class='title' and text()='Products']")
    private WebElement homePageTitle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    public boolean verifyTitle() {
    	return seleniumUtils.verifyExists(homePageTitle);
    }
    
    public void clickSearchButton(){
        seleniumUtils.click(searchButton);
    }

}
