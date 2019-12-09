package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class WatchListPage extends ParentPage {

    @FindBy(xpath = ".//div[@class = 'container d-none d-lg-block']/div/form/span/input[@class = 'form-control form-control-lg js-typehead tt-input']")
    private WebElement searchForm;

    public Menu menu;
    public ListsMenu listsMenu;

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
        MoviesPage moviesPage = new MoviesPage(webDriver);
        ListsPage listsPage = new ListsPage(webDriver);
        if(!moviesPage.isMoviePosterDisplayed(filmTitle)){
            menu.clickOnSearchButton();
            enterFilmTitleIntoSearchForm(filmTitle);
            pressEnterOnSearchForm();
            moviesPage.setStateToMovieWatchButton(filmTitle, "select");
            menu.clickOnListsButton();
            listsPage.clickOnMyListsButton();
            listsPage.listsMenu.clickOnWatchListButton();
        }else{
            return;
        }



    }
}
