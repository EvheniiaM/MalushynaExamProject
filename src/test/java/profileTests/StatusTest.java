package profileTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class StatusTest extends AbstractParentTest {

    private final String statusText = "Merry Christmas " + Utils.getDateAndTimeFormated();

    @Test
    public void changeStatus() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        settingsPage.enterStatusIntoStatusTextarea(statusText);
        settingsPage.clickOnSubmitButton();

        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());

        settingsPage.menu.clickOnUserMenu();
        settingsPage.menu.clickOnProfileButton();

        profilePage.checkCurrentUrl();
        Assert.assertEquals("Status was not changed", statusText, profilePage.getStatusText());
    }

    @After
    public void deleteStatus() {
        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();
        settingsPage.deleteStatus();
    }
}