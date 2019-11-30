package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class CreateListsPage extends ParentPage {

    @FindBy(xpath = ".//input[@id = 'title']")
    private WebElement titleInput;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement createListButton;

    @FindBy(xpath = ".//div[@class = 'alert alert-success alert-dismissible']")
    private WebElement successAlert;

    public CreateListsPage(WebDriver webDriver) {
        super(webDriver, "/lists/create");
    }

    public void enterTitleIntoTitleInput(String title) {
        actionsWithOurElements.enterTextIntoInput(titleInput, title);
    }

    public void clickOnCreateListButton(){
        actionsWithOurElements.clickOnElement(createListButton);
    }


    public boolean isSuccessAlertDisplayed(){
        return actionsWithOurElements.isElementDisplayed(successAlert);
    }
}
