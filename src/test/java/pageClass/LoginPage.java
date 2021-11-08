package pageClass;

import utilities.SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

    public static WebDriver driver;
    SeleniumUtils seleniumUtils;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String userName) {
        seleniumUtils.sendkeys(userNameField, userName);
    }

    public void enterPassword(String userName) {
        seleniumUtils.sendkeys(passwordField, userName);
    }

    public String getErrorMessage(){
        return seleniumUtils.getText(errorMessage);
    }

    public void clickLoginButton() {
        seleniumUtils.click(loginButton);
    }

}
