package listsTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class SeenListTest extends AbstractParentTest {

    private final String filmTitle = "The Shawshank Redemption";

    @Test
    public void addFilmToSeenList() {
        loginPage.fillingLoginFormAndSubmitIt("studentqalight2019@gmail.com", "123456789");

        homePage.clickOnSearchButton();
//        homePage.enterFilmTitleIntoSearchForm(filmTitle);


    }

}