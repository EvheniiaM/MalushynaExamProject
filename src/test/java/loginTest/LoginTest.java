package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.clickOnEnterButton();
        loginPage.enterLoginIntoInputLogin("studentqalight2019@gmail.com");
        loginPage.enterPassIntoInputPassword("123456789");
        loginPage.clickOnSubmitButton();

        checkExpectedResult("Smile button is not present", homePage.isSmileButtonDisplayed());
    }

}
