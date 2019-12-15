package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {

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

    public Menu menu;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @Step
    public void openPage() {
        try {
            webDriver.get("https://kinobaza.com.ua/");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }
    }

    @Step
    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(loginInput,login);
    }

    @Step
    public void enterPassIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(passwordInput, password);
    }

    @Step
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    @Step
    public boolean isAlertMessageDisplayed(){
        return actionsWithOurElements.isElementDisplayed(alertMessage);
    }

    @Step
    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        menu.clickOnEnterButton();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(pass);
        clickOnSubmitButton();
    }

}