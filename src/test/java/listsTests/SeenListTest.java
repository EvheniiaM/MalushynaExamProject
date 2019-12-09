package listsTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SeenListTest extends AbstractParentTest {

    private final String filmTitle = "The Shawshank Redemption";

    @Test
    public void addFilmToSeenList() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.menu.clickOnUserMenu();
        homePage.menu.clickOnMyListsButton();

        myListsPage.checkCurrentUrl();
        myListsPage.listsMenu.clickOnSeenListButton();

        seenListPage.checkCurrentUrl();
        seenListPage.setStatusNotSeenToMovieIfItIsInList(filmTitle);

        checkExpectedResult("Movie is still in the list",!moviesPage.isMoviePosterDisplayed(filmTitle));

        seenListPage.menu.clickOnSearchButton();
        seenListPage.enterFilmTitleIntoSearchForm(filmTitle);
        seenListPage.pressEnterOnSearchForm();

        moviesPage.setStateToMovieSeenButton(filmTitle, "select");
        moviesPage.menu.clickOnListsButton();

        listsPage.checkCurrentUrl();
        listsPage.clickOnMyListsButton();

        myListsPage.listsMenu.clickOnSeenListButton();

        seenListPage.checkCurrentUrl();
        checkExpectedResult(filmTitle + " poster is not displayed" , moviesPage.isMoviePosterDisplayed(filmTitle));
    }

    @After
    public void setStatusNotSeenToMovie() {
        seenListPage.setStatusNotSeenToMovieIfItIsInList(filmTitle);
    }
}