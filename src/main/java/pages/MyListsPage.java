package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class MyListsPage extends ParentPage {

    @FindBy(xpath = ".//a[@href = '/lists/create']")
    private WebElement createListButton;

    @FindBy(xpath = ".//button[@class = 'dropdown-item js-delete-item']")
    private WebElement deleteListButton;

    public Menu menu;
    public ListsMenu listsMenu;

    public MyListsPage(WebDriver webDriver, String partUrl) {
        super(webDriver, partUrl);
    }

    public MyListsPage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019/lists");
    }

    public void clickOnCreateListButton() {
        actionsWithOurElements.clickOnElement(createListButton);
    }

    public boolean isListDisplayed(String listTitle) {
        return actionsWithOurElements.isElementDisplayed(".//a[@title ='" + listTitle + "']");
    }

    public void clickOnListMenuDropDown(String listTitle) {
        actionsWithOurElements.clickOnElement(".//a[@title = '" + listTitle + "']/../../div[@class = 'dropdown float-right']");
    }

    public void clickOnDeleteListButton(){
        actionsWithOurElements.clickOnElement(deleteListButton);
    }

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
