package pages.pageElements;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//a[@href = 'https://kinobaza.com.ua/@studentqalight2019/watchlist']/..")
public class ListsMenu extends CommonActionWithElements{

    @FindBy(xpath = ".//a[@href = 'https://kinobaza.com.ua/@studentqalight2019/watchlist']")
    private Link watchListButton;

    @FindBy(xpath = ".//a[@href = 'https://kinobaza.com.ua/@studentqalight2019/seenlist']")
    private Link seenListButton;

    @FindBy(xpath = ".//.//a[@href = 'https://kinobaza.com.ua/@studentqalight2019/watchlist']/../a[@href = 'https://kinobaza.com.ua/@studentqalight2019/lists']")
    private Link myListsButton;

    @Step
    public void clickOnSeenListButton(){
        actionsWithOurElements.clickOnElement(seenListButton);
    }

    @Step
    public void clickOnWatchListButton(){
        actionsWithOurElements.clickOnElement(watchListButton);
    }
}
