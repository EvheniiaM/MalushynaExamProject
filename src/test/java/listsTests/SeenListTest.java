package listsTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SeenListTest extends AbstractParentTest {

    private final String filmTitle = "The Shawshank Redemption";
    private final String movieHrefPart = "the-shawshank-redemption";

    @Test
    public void addFilmToSeenList() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.clickOnSearchButton();
        homePage.enterFilmTitleIntoSearchForm(filmTitle);
        homePage.pressEnterOnSearchForm();

        moviesPage.setStateToMovieSeenButton(movieHrefPart, "select");
        moviesPage.clickOnListsButton();

        listsPage.clickOnMyListsButton();

        myListsPage.clickOnSeenListButton();

        seenListPage.checkCurrentUrl();
        checkExpectedResult(filmTitle + " poster is not displayed" , moviesPage.isMoviePosterDisplayed(movieHrefPart));
    }
}