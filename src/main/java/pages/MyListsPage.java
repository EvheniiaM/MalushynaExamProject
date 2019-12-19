package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import pages.pageElements.MovieBlock;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;

public class MyListsPage extends ParentPage {

    @FindBy(xpath = ".//a[@href = '/lists/create']")
    private Button createListButton;

    @FindBy(xpath = ".//button[@class = 'dropdown-item js-delete-item']")
    private Button deleteListButton;

    public Menu menu;
    public ListsMenu listsMenu;
    public MovieBlock movieBlock;

    public MyListsPage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019/lists");
    }

    @Step
    public void clickOnCreateListButton() {
        actionsWithOurElements.clickOnElement(createListButton);
    }

    @Step
    public boolean isListDisplayed(String listTitle) {
        return actionsWithOurElements.isElementDisplayed(".//a[@title ='" + listTitle + "']");
    }

    @Step
    public void clickOnListMenuDropDown(String listTitle) {
        actionsWithOurElements.clickOnElement(".//a[@title = '" + listTitle + "']/../../div[@class = 'dropdown float-right']");
    }

    @Step
    public void clickOnDeleteListButton(){
        actionsWithOurElements.clickOnElement(deleteListButton);
    }

    @Step
    public void deleteListUntilPresent(String listTitle) {
        int counter = 0;
        ListsPage listsPage = new ListsPage(webDriver);
        while (isListDisplayed(listTitle)){
            clickOnListMenuDropDown(listTitle);
            clickOnDeleteListButton();
            actionsWithOurElements.acceptAlert();
            logger.info(counter +1 + " list was deleted");
            listsPage.clickOnMyListsButton();
            if (counter > 100) {
                Assert.fail("There more then 100 lists");
            }
            counter++;
        }
    }
}
