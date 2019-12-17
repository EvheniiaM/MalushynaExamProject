package listsTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class MyListsTest extends AbstractParentTest {

    private final String listTitle = "Christmas selection" + Utils.getDateAndTimeFormated() ;

    @Test
    public void createList() {
        homePage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnMyListsButton();

        myListsPage.checkCurrentUrl();
        myListsPage.deleteListUntilPresent(listTitle);
        myListsPage.clickOnCreateListButton();

        createListsPage.checkCurrentUrl();
        createListsPage.enterTitleIntoTitleInput(listTitle);
        createListsPage.clickOnCreateListButton();
        checkExpectedResult("Success alert is not displayed" , createListsPage.isSuccessAlertDisplayed());

        listsPage.menu.clickOnUserMenu();
        listsPage.menu.clickOnMyListsButton();

        checkExpectedResult("Can not find created list" , myListsPage.isListDisplayed(listTitle));
    }

    @After
    public void deleteList(){
        myListsPage.deleteListUntilPresent(listTitle);
    }
}