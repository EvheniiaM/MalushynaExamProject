package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class InvalidLoginTest extends AbstractParentTest {
    String login, password;

    public InvalidLoginTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                        {"studentqalight2019@gmail.com", ""},
                        {"", "123456789"},
                        {"", ""},
                        {"studentqalight2019@gmail.com", "1234567890"}
                }
        );
    }

    @Test
    public void invalidLogin() {
        homePage.openPage();
        homePage.menu.clickOnEnterButton();
        homePage.loginWindow.enterLoginIntoInputLogin(login);
        homePage.loginWindow.enterPassIntoInputPassword(password);
        homePage.loginWindow.clickOnSubmitButton();

        checkExpectedResult("Allert message is not present", homePage.isAlertMessageDisplayed());
        checkExpectedResult("Enter button is not present", homePage.menu.isEnterButtonDisplayed());
    }
}
