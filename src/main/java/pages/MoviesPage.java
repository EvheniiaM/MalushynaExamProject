package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class MoviesPage extends ParentPage {

    @FindBy(xpath = ".//a[@href = '/lists']")
    private WebElement listsButton;

    public MoviesPage(WebDriver webDriver) {
        super(webDriver, "/movies");
    }

    public void setStateToMovieSeenButton(String movieHrefPart, String expectedState){
        actionsWithOurElements.setStateToButton(".//a[@href = '/titles/"+ movieHrefPart +"']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']", expectedState);
    }

    public boolean isMoviePosterDisplayed(String movieHrefPart){
        return actionsWithOurElements.isElementDisplayed(".//a[@href = '/titles/" + movieHrefPart + "']/../div[@aria-label = 'Оцінити та/або додати в список']/div[@title = 'Бачив']");
    }

    public void clickOnListsButton(){
        actionsWithOurElements.clickOnElement(listsButton);
    }
}
