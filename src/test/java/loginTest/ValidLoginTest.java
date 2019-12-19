package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class ValidLoginTest extends AbstractParentTest {
    String login, password;

    public ValidLoginTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                        {"studentqalight2019@gmail.com", "123456789"},
                        {"  studentqalight2019@gmail.com   ", "123456789"},
                        {"STUDENTQALIGHT2019@GMAIL.COM", "123456789"},
                }
        );
    }

    @Test
    public void validLogin() {
        homePage.openPage();
        homePage.menu.clickOnEnterButton();
        homePage.loginWindow.enterLoginIntoInputLogin(login);
        homePage.loginWindow.enterPassIntoInputPassword(password);
        homePage.loginWindow.clickOnSubmitButton();

        checkExpectedResult("User menu button is not present", homePage.menu.isUserMenuDisplayed());
    }
}


