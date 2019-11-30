package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.clickOnEnterButton();
        loginPage.enterLoginIntoInputLogin("studentqalight2019@gmail.com");
        loginPage.enterPassIntoInputPassword("123456789");
        loginPage.clickOnSubmitButton();

        checkExpectedResult("User button is not present", homePage.isUserButtonDisplayed());
    }

    @Test
    public void unValidLogin(){
        loginPage.openPage();
        loginPage.clickOnEnterButton();
        loginPage.enterLoginIntoInputLogin("");
        loginPage.enterPassIntoInputPassword("");
        loginPage.clickOnSubmitButton();

        checkExpectedResult("Allert message is not present", loginPage.isAlertMessageDisplayed());
        checkExpectedResult("Enter button is not present", loginPage.isEnterButtonDisplayed());
    }
}


//
//    @Test
//    public void clearAvatar(){
//        loginPage.openPage();
//        loginPage.clickOnEnterButton();
//        loginPage.enterLoginIntoInputLogin("studentqalight2019@gmail.com");
//        loginPage.enterPassIntoInputPassword("123456789");
//        loginPage.clickOnSubmitButton();
//        homePage.clickOnUserButton();
//        homePage.clickOnSettingsButton();
//        settingsPage.clearAvatar();
//        settingsPage.clickOnSubmitButton();
//
//    }


