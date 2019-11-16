package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//a[@href = '/login']")
    private WebElement enterButton;

    @FindBy(xpath = ".//div[@class = 'modal-dialog']")
    private WebElement enterWindow;

    @FindBy(xpath = ".//input[@id = 'loginModalEmail']")
    private WebElement loginInput;

    @FindBy(xpath = ".//input[@id = 'loginModalPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = ".//div[@class = 'alert alert-danger']")
    private WebElement alertMessage;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("https://kinobaza.com.ua/");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }
    }

    public void clickOnEnterButton() {
        enterButton.click();
        logger.info("Enter button was clicked");
    }

    public void enterLoginIntoInputLogin(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
        logger.info(login + " was inputed into input login");
    }

    public void enterPassIntoInputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        logger.info(password + " was inputed into input Password");
    }

    public void clickOnSubmitButton() {
        submitButton.click();
        logger.info("Submit button was clicked");
    }

    public boolean isEnterButtonDisplayed(){
        try{
            return enterButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isAlertMessageDisplayed(){
        try{
            return alertMessage.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}