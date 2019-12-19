package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class ListsPage extends ParentPage {

    @FindBy(xpath = ".//a[@class = 'btn btn-primary btn-block']")
    private WebElement myListsButton;

    public Menu menu;
    public ListsMenu listsMenu;

    public ListsPage(WebDriver webDriver) {
        super(webDriver, "/lists");
    }

    @Step
    public void clickOnMyListsButton(){
        actionsWithOurElements.clickOnElement(myListsButton);
    }
}
