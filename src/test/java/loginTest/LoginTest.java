package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        homePage.openPage();
        homePage.menu.clickOnEnterButton();
        homePage.loginWindow.enterLoginIntoInputLogin("studentqalight2019@gmail.com");
        homePage.loginWindow.enterPassIntoInputPassword("123456789");
        homePage.loginWindow.clickOnSubmitButton();

        checkExpectedResult("User menu button is not present", homePage.menu.isUserMenuDisplayed());
    }

    @Test
    public void invalidLogin() {
        homePage.openPage();
        homePage.menu.clickOnEnterButton();
        homePage.loginWindow.enterLoginIntoInputLogin("");
        homePage.loginWindow.enterPassIntoInputPassword("");
        homePage.loginWindow.clickOnSubmitButton();

        checkExpectedResult("Allert message is not present", homePage.isAlertMessageDisplayed());
        checkExpectedResult("Enter button is not present", homePage.menu.isEnterButtonDisplayed());
    }


}


