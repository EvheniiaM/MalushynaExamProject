package pages.pageElements;

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

    public void clickOnSeenListButton(){
        actionsWithOurElements.clickOnElement(seenListButton);
    }

    public void clickOnWatchListButton(){
        actionsWithOurElements.clickOnElement(watchListButton);
    }
}
