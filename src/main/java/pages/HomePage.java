package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LoginWindow;
import pages.pageElements.Menu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//div[@class = 'alert alert-danger']")
    private Link alertMessage;

    public Menu menu;
    public LoginWindow loginWindow;

    public HomePage(WebDriver webDriver) {
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
    public boolean isAlertMessageDisplayed(){
        return actionsWithOurElements.isElementDisplayed(alertMessage);
    }

    @Step
    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        menu.clickOnEnterButton();
        loginWindow.enterLoginIntoInputLogin(login);
        loginWindow.enterPassIntoInputPassword(pass);
        loginWindow.clickOnSubmitButton();
    }
}
