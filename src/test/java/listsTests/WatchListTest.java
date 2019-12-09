package listsTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class WatchListTest extends AbstractParentTest {

    private final String filmTitle = "Home alone";

    @Test
    public void movieDisappearsFromWatchListAfterRate(){
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        settingsPage.setStateToRemoveFromWachListAfterRateCheckbox("check");
        settingsPage.clickOnSubmitButton();
        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());
        settingsPage.menu.clickOnUserMenu();
        settingsPage.menu.clickOnMyListsButton();

        myListsPage.checkCurrentUrl();
        myListsPage.listsMenu.clickOnWatchListButton();

        watchListPage.checkCurrentUrl();
        watchListPage.addMovieIfItIsNotInList(filmTitle);

        moviesPage.rateFilm(filmTitle, "2");

    }
}
