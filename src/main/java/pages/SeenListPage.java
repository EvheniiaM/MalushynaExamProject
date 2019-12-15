package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import pages.pageElements.MovieBlock;
import parentPage.ParentPage;

public class SeenListPage extends ParentPage {

    @FindBy(xpath = ".//div[@class = 'container d-none d-lg-block']/div/form/span/input[@class = 'form-control form-control-lg js-typehead tt-input']")
    private WebElement searchForm;

    public Menu menu;
    public ListsMenu listsMenu;
    public MovieBlock movieBlock;

    public SeenListPage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019/seenlist");
    }

    public void enterFilmTitleIntoSearchForm(String filmTitle){
        actionsWithOurElements.enterTextIntoInput(searchForm, filmTitle);
    }

    public void pressEnterOnSearchForm(){
        actionsWithOurElements.pressEnterOnForm(searchForm);
    }

    public void setStatusNotSeenToMovieIfItIsInList(String filmTitle) {
        if(movieBlock.isMoviePosterDisplayed(filmTitle.toLowerCase().replace(" ", "-"))){
            movieBlock.setStateToMovieSeenButton(filmTitle.toLowerCase().replace(" ", "-"), "unselect");
            logger.info("Status was set to 'not seen'");
            listsMenu.clickOnSeenListButton();
        }else{
            logger.info("Movie is not in list");
        }
    }
}
