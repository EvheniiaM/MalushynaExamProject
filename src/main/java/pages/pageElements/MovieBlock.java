package pages.pageElements;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
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

    protected Logger logger = Logger.getLogger(getClass());

    @Step
    public void setStateToMovieSeenButton(String filmTitle, String expectedState) {
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']", expectedState);
    }

    @Step
    public void setStateToMovieWatchButton(String filmTitle, String expectedState) {
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Перегляну пізніше']", expectedState);
    }

    @Step
    public boolean isMoviePosterDisplayed(String filmTitle) {
        return actionsWithOurElements.isElementDisplayed(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']");
    }

    @Step
    public void rateFilm(String filmTitle, String rating) {
        actionsWithOurElements.clickOnElement(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../../div[@itemprop = 'aggregateRating']/div/div/i[@data-value = '" + rating + "']");
    }

    @Step
    public void deleteMovieRating(String filmTitle) {
        WebElement deleteRatingButton = webDriver.findElement(By.xpath(".//a[@href = '/titles/" + filmTitle.toLowerCase().replace(" ", "-") + "']/../../div[@itemprop = 'aggregateRating']/div/div/button"));
        boolean isRatingSet = actionsWithOurElements.isElementDisplayed(deleteRatingButton);
        if (isRatingSet) {
            actionsWithOurElements.clickOnElement(deleteRatingButton);
            logger.info("Rating was deleted");
        } else {
            logger.info("Rating is not set");
        }
    }

}
