package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.menu.clickOnEnterButton();
        loginPage.enterLoginIntoInputLogin("studentqalight2019@gmail.com");
        loginPage.enterPassIntoInputPassword("123456789");
        loginPage.clickOnSubmitButton();

        checkExpectedResult("User menu button is not present", homePage.menu.isUserMenuDisplayed());
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.menu.clickOnEnterButton();
        loginPage.enterLoginIntoInputLogin("");
        loginPage.enterPassIntoInputPassword("");
        loginPage.clickOnSubmitButton();

        checkExpectedResult("Allert message is not present", loginPage.isAlertMessageDisplayed());
        checkExpectedResult("Enter button is not present", loginPage.menu.isEnterButtonDisplayed());
    }
}


