package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class MyListsPage extends ParentPage {

    @FindBy(xpath = ".//a[@href = '/lists/create']")
    private WebElement createListButton;

    @FindBy(xpath = ".//button[@class = 'dropdown-item js-delete-item']")
    private WebElement deleteListButton;

    @FindBy(xpath = ".//a[@class = 'btn btn-primary btn-block']")
    private WebElement myListsButton;

    @FindBy(xpath = ".//a[@href = 'https://kinobaza.com.ua/@studentqalight2019/seenlist']")
    private WebElement seenListButton;

    public MyListsPage(WebDriver webDriver, String partUrl) {
        super(webDriver, partUrl);
    }

    public MyListsPage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019/lists");
    }

    public void clickOnCreateListButton() {
        actionsWithOurElements.clickOnElement(createListButton);
    }

    public void clickOnMyListsButton(){
        actionsWithOurElements.clickOnElement(myListsButton);
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
        MyListsPage myListsPage = new MyListsPage(webDriver);
        ListsPage listsPage = new ListsPage(webDriver);
        while (isListDisplayed(listTitle)){
            myListsPage.clickOnListMenuDropDown(listTitle);
            myListsPage.clickOnDeleteListButton();
            // добавить нажатие на ENTER!!!!!!!!!!!!!!!!!!!!!!!!!!!
            listsPage.clickOnMyListsButton();
            logger.info(counter + " list was deleted");
            if (counter > 100) {
                Assert.fail("There more then 100 lists");
            }
            counter++;
        }
    }

    public void clickOnSeenListButton(){
        actionsWithOurElements.clickOnElement(seenListButton);
    }
}
