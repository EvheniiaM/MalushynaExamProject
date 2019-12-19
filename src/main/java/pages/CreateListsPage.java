package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.Menu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CreateListsPage extends ParentPage {

    @FindBy(xpath = ".//input[@id = 'title']")
    private TextInput titleInput;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private Button createListButton;

    @FindBy(xpath = ".//div[@class = 'alert alert-success alert-dismissible']")
    private Link successAlert;

    public Menu menu;

    public CreateListsPage(WebDriver webDriver) {
        super(webDriver, "/lists/create");
    }

    @Step
    public void enterTitleIntoTitleInput(String title) {
        actionsWithOurElements.enterTextIntoInput(titleInput, title);
    }

    @Step
    public void clickOnCreateListButton(){
        actionsWithOurElements.clickOnElement(createListButton);
    }

    @Step
    public boolean isSuccessAlertDisplayed(){
        return actionsWithOurElements.isElementDisplayed(successAlert);
    }
}
