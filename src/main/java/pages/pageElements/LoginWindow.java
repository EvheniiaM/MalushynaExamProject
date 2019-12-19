package pages.pageElements;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = ".//div[@class = 'modal-content']")
public class LoginWindow extends CommonActionWithElements {

    @FindBy(xpath = ".//input[@id = 'loginModalEmail']")
    private TextInput loginInput;

    @FindBy(xpath = ".//input[@id = 'loginModalPassword']")
    private TextInput passwordInput;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private Button submitButton;

    @Step
    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(loginInput,login);
    }

    @Step
    public void enterPassIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(passwordInput, password);
    }

    @Step
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

}
