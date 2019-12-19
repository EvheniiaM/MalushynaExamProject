package profileTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class AvatarTest extends AbstractParentTest {

    private final String avatarPath1 = "/Users/user227/Downloads/avatar1.jpeg";
    private final String avatarPath2 = "/Users/user227/Downloads/avatar2.jpeg";

    @Test
    public void changeAvatar() {
        homePage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        String initialAvatarSrc = settingsPage.getAvatarSrc();
        settingsPage.addAvatar(avatarPath2);
        settingsPage.clickOnSubmitButton();

        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());

        String currentAvatarSrc = settingsPage.getAvatarSrc();
        checkExpectedResult("Avatar was not changed",!initialAvatarSrc.equals(currentAvatarSrc));

    }
}
