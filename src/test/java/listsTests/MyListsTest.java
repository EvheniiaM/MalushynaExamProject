package listsTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class MyListsTest extends AbstractParentTest {

    private final String listTitle = "Christmas selection" + Utils.getDateAndTimeFormated();

    @Test
    public void createList() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.clickOnUserButton();
        homePage.clickOnMyListsButton();

        myListsPage.checkCurrentUrl();
//        myListsPage.deleteListUntilPresent(listTitle);
        myListsPage.clickOnCreateListButton();

        createListsPage.checkCurrentUrl();
        createListsPage.enterTitleIntoTitleInput(listTitle);
        createListsPage.clickOnCreateListButton();

        checkExpectedResult("Success alert is not present", createListsPage.isSuccessAlertDisplayed());

        homePage.clickOnUserButton();
        homePage.clickOnMyListsButton();

        checkExpectedResult("Can not find list" , myListsPage.isListDisplayed(listTitle));
    }

    @After
    public void deleteList(){
        myListsPage.deleteListUntilPresent(listTitle);
    }
}