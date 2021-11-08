package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SeleniumUtils extends TestBase {

    public static WebDriver driver;
    Logger logger = Logger.getLogger("OnlineShopping");

    public SeleniumUtils(WebDriver driver){
        this.driver = driver;
    }

    public void click(WebElement element){
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            String elementName = element.getText();
            element.click();
            logger.info(elementName+" Clicked");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String getText(WebElement element){
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            String elementName = element.getText();
            logger.info(elementName+" Fetched");
            return element.getText();
        }catch (Exception e){
            e.printStackTrace();
        }
		return null;
    }

    public void acceptAlert(){
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).accept();
            logger.info("Alert accepted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendkeys(WebElement element, String input){
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(input);
            logger.info(input+" Entered");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void switchTab() {
	    try {
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	        driver.switchTo().window(tabs2.get(1));
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
    }

    public boolean verifyExists(WebElement element) {
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            logger.info(element+" Exists");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
