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
        super(webDriver, "/");
    }

    public void openPage() {
        try {
            webDriver.get("https://kinobaza.com.ua/");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }
    }

    public void clickOnEnterButton() {
        actionsWithOurElements.clickOnElement(enterButton);
    }

    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(loginInput,login);
    }

    public void enterPassIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(passwordInput, password);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public boolean isEnterButtonDisplayed(){
        return actionsWithOurElements.isElementDisplayed(enterButton);
    }

    public boolean isAlertMessageDisplayed(){
        return actionsWithOurElements.isElementDisplayed(alertMessage);
    }

    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        clickOnEnterButton();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(pass);
        clickOnSubmitButton();
    }

}