package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import pages.pageElements.MovieBlock;
import parentPage.ParentPage;

public class WatchListPage extends ParentPage {

    @FindBy(xpath = ".//div[@class = 'container d-none d-lg-block']/div/form/span/input[@class = 'form-control form-control-lg js-typehead tt-input']")
    private WebElement searchForm;

    public Menu menu;
    public ListsMenu listsMenu;
    public MovieBlock movieBlock;

    public WatchListPage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019/watchlist");
    }

    public void enterFilmTitleIntoSearchForm(String filmTitle){
        actionsWithOurElements.enterTextIntoInput(searchForm, filmTitle);
    }

    public void pressEnterOnSearchForm(){
        actionsWithOurElements.pressEnterOnForm(searchForm);
    }

    public void addMovieIfItIsNotInList(String filmTitle){
        ListsPage listsPage = new ListsPage(webDriver);
        MyListsPage myListsPage = new MyListsPage(webDriver);
        if(!movieBlock.isMoviePosterDisplayed(filmTitle)){
            menu.clickOnSearchButton();
            enterFilmTitleIntoSearchForm(filmTitle);
            pressEnterOnSearchForm();
            movieBlock.setStateToMovieWatchButton(filmTitle, "select");
            logger.info("Movie was added to watchlist");
            menu.clickOnListsButton();
            listsPage.clickOnMyListsButton();
            myListsPage.listsMenu.clickOnWatchListButton();
        }else{
            logger.info("Movie is already in the list");
        }
    }
}
