package profileTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ProfileTest extends AbstractParentTest {

    private final String statusText = "Merry Christmas " + Utils.getDateAndTimeFormated();
    private final String avatarPath1 = "/Users/user227/Downloads/avatar1.jpeg";
    private final String avatarPath2 = "/Users/user227/Downloads/avatar2.jpeg";

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

    @Test
    public void changeAvatar() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        String initialAvatarSrc = settingsPage.getAvatarSrc();
        settingsPage.addAvatar(avatarPath1);
        settingsPage.clickOnSubmitButton();

        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());

        String currentAvatarSrc = settingsPage.getAvatarSrc();
        checkExpectedResult("Avatar was not changed",!initialAvatarSrc.equals(currentAvatarSrc));

    }
}