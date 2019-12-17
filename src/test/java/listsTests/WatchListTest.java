package listsTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class WatchListTest extends AbstractParentTest {

    private final String filmTitle = "Home alone";

    @Test
    public void movieDisappearsFromWatchListAfterRate(){
        homePage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnMyListsButton();

        myListsPage.checkCurrentUrl();
        myListsPage.listsMenu.clickOnWatchListButton();

        watchListPage.checkCurrentUrl();
        watchListPage.addMovieIfItIsNotInList(filmTitle);
        watchListPage.movieBlock.deleteMovieRating(filmTitle);
        watchListPage.menu.clickOnUserMenu();
        watchListPage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        settingsPage.setStateToRemoveFromWatchListAfterRateCheckbox("check");
        settingsPage.clickOnSubmitButton();
        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());
        settingsPage.menu.clickOnUserMenu();
        settingsPage.menu.clickOnMyListsButton();

        myListsPage.listsMenu.clickOnWatchListButton();
        myListsPage.movieBlock.rateFilm(filmTitle, "9");
        watchListPage.listsMenu.clickOnWatchListButton();

        checkExpectedResult("Movie is still in the watch list",!watchListPage.movieBlock.isMoviePosterDisplayed(filmTitle));
    }

    @Test
    public void movieDoesNotDisappearsFromWatchListAfterRate() {
        homePage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnMyListsButton();

        myListsPage.checkCurrentUrl();
        myListsPage.listsMenu.clickOnWatchListButton();

        watchListPage.checkCurrentUrl();
        watchListPage.addMovieIfItIsNotInList(filmTitle);
        watchListPage.movieBlock.deleteMovieRating(filmTitle);
        watchListPage.menu.clickOnUserMenu();
        watchListPage.menu.clickOnSettingsButton();

        settingsPage.checkCurrentUrl();
        settingsPage.setStateToRemoveFromWatchListAfterRateCheckbox("uncheck");
        settingsPage.clickOnSubmitButton();
        checkExpectedResult("Success alert is not present", settingsPage.isSuccessAlertDisplayed());
        settingsPage.menu.clickOnUserMenu();
        settingsPage.menu.clickOnMyListsButton();

        myListsPage.listsMenu.clickOnWatchListButton();
        myListsPage.movieBlock.rateFilm(filmTitle, "9");
        watchListPage.listsMenu.clickOnWatchListButton();

        checkExpectedResult("Movie disappeared from the list", watchListPage.movieBlock.isMoviePosterDisplayed(filmTitle));
    }
}
