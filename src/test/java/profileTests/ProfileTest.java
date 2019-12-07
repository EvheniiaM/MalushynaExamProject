package profileTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ProfileTest extends AbstractParentTest {

    private final String statusText = "Merry Christmas";
    private final String avatarPath1 = "/Users/user227/Downloads/avatar1.jpeg";
    private final String avatarPath2 = "/Users/user227/Downloads/avatar2.jpeg";

    @Test
    public void changeStatus() {

        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        settingsPage.deleteStatus();
        settingsPage.enterStatusIntoStatusTextarea(statusText);
        settingsPage.clickOnSubmitButton();

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnProfileButton();

        Assert.assertEquals("Status was not changed", statusText, profilePage.getStatusText());
    }
//    @After
//    public void deleteStatus(){
//        homePage.clickOnUserButton();
//        homePage.clickOnProfileButton();
//        settingsPage.deleteStatus();
//    }

    @Test
    public void changeAvatar() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();

        String firstAvatarSrc = settingsPage.getAvatarSrc();
        settingsPage.addAvatar(avatarPath1);
        settingsPage.clickOnSubmitButton();
        String secondAvatarSrc = settingsPage.getAvatarSrc();

        Assert.assertEquals("Avatar was not changed", false, firstAvatarSrc.equals(secondAvatarSrc));
        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());

    }
}