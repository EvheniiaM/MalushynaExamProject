package pages.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = ".//div[@itemtype = 'http://schema.org/Movie']")
public class MovieBlock extends CommonActionWithElements {

//    @FindBy(xpath = ".//a[@class = 'poster-wrapper']")
//    private Image poster;
//
//    @FindBy(xpath = ".//div[@title = 'Перегляну пізніше']")
//    private Button watchButton;
//
//    @FindBy(xpath = ".//div[@title = 'Улюблений']")
//    private Button favoriteButton;
//
//    @FindBy(xpath = ".//div[@title = 'Бачив']")
//    private Button seenButton;
//
//    @FindBy(xpath = ".//div[@title = 'Не цікавить']")
//    private Button blacklistButton;
//
//    @FindBy(xpath = ".//div[@title = 'Додати до списку']")
//    private Button addToListButton;
//
//    @FindBy(xpath = ".//i[@data-value = '10']")
//    private Button rating10;
//
//    @FindBy(xpath = ".//button[@title = 'Видалити оцінку']")
//    private Button deleteRatingButton;


    public void setStateToMovieSeenButton(String filmTitle, String expectedState) {
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']", expectedState);
    }

    public void setStateToMovieWatchButton(String filmTitle, String expectedState) {
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Перегляну пізніше']", expectedState);
    }

    public boolean isMoviePosterDisplayed(String filmTitle) {
        return actionsWithOurElements.isElementDisplayed(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']");
    }

    public void rateFilm(String filmTitle, String rating) {
        actionsWithOurElements.clickOnElement(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../../div[@itemprop = 'aggregateRating']/div/div/i[@data-value = '" + rating + "']");
    }

    public void deleteMovieRating(String filmTitle) {
        WebElement deleteRatingButton = webDriver.findElement(By.xpath(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../../div[@itemprop = 'aggregateRating']/div/div/button"));
        boolean isRatingSet = actionsWithOurElements.isElementDisplayed(deleteRatingButton);
        if (isRatingSet) {
            actionsWithOurElements.clickOnElement(deleteRatingButton);
            System.out.println("Rating was deleted");
        } else {
            System.out.println("Rating is not set");
        }
    }

}
