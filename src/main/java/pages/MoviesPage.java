package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.ListsMenu;
import pages.pageElements.Menu;
import parentPage.ParentPage;

import java.awt.*;

public class MoviesPage extends ParentPage {


//    @FindBy(xpath = ".//a[@href = '/titles/"+ filmTitle +"']/../../div[@itemprop = 'aggregateRating']/div[4]/div/button[@title = 'Видалити оцінку']")
//    private WebElement deleteRatingButton;

    public Menu menu;

    public MoviesPage(WebDriver webDriver) {
        super(webDriver, "/movies");
    }

    public void setStateToMovieSeenButton(String filmTitle, String expectedState){
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']", expectedState);
    }

    public void setStateToMovieWatchButton(String filmTitle, String expectedState){
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Перегляну пізніше']", expectedState);
    }

    public boolean isMoviePosterDisplayed(String filmTitle){
        return actionsWithOurElements.isElementDisplayed(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']");
    }

//    public void isDeleteRatingButtonDisplayed(String filmTitle){
//        actionsWithOurElements.isElementDisplayed( ".//a[@href = '/titles/"+ filmTitle +"']/../../div[@itemprop = 'aggregateRating']/div[4]/div/button[@title = 'Видалити оцінку']");
//    }

    public void rateFilm(String filmTitle, String rating){
        actionsWithOurElements.clickOnElement(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-" ) +"']/../../div[@itemprop = 'aggregateRating']/div[5]/div/i[@data-value = '" + rating + "']");
    }

//    public String getFilmHrefPart(String filmTitle){
//        return filmTitle.toLowerCase().replace(" ", "-");
//    }
}
