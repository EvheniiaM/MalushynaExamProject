package pages.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;

@FindBy(xpath = ".//a[@class = 'navbar-brand']/..")
public class Menu extends CommonActionWithElements {

//    @FindBy(xpath = ".//a[@class = 'navbar-brand']")
//    private Link logoButton;
//
//    @FindBy(xpath = ".//a[@class = 'nav-link' and @href = '/posts']")
//    private Link postsButton;
//
//    @FindBy(xpath = ".//a[@id = 'navbarDropdownTitles']")
//    private Select allMoviesDropdown;
//
//    @FindBy(xpath = ".//a[@href= '/reviews']")
//    private Link reviewsButton;
//
//    @FindBy(xpath = ".//a[@href= '/trailers']")
//    private Link trailerButton;

    @FindBy(xpath = ".//a[@href= '/lists']")
    private Link listsButton;

//    @FindBy(xpath = ".//a[@href= '/forum']")
//    private Link forumButton;

//    @FindBy(xpath = ".//a[@href= '/notifications']")
//    private Link notificationsButton;

    @FindBy(xpath = ".//a[@href = '/login']")
    private Button enterButton;

    @FindBy(xpath = ".//a[@id='navbarDropdownUser']")
    private Select userMenu;

    @FindBy(xpath = ".//a[@href='https://kinobaza.com.ua/@studentqalight2019']")
    private Link profileButton;

    @FindBy(xpath = ".//a[@href='/settings/profile']")
    private Link settingsButton;

    @FindBy(xpath = ".//a[@href='https://kinobaza.com.ua/@studentqalight2019/lists']")
    private Link myListsButton;

    public void clickOnEnterButton() {
        actionsWithOurElements.clickOnElement(enterButton);
    }

    public void clickOnUserMenu() {
        actionsWithOurElements.clickOnElement(userMenu);
    }

    public void clickOnProfileButton() {
        actionsWithOurElements.clickOnElement(profileButton);
    }

    public void clickOnSettingsButton() {
        actionsWithOurElements.clickOnElement(settingsButton);
    }

    public void clickOnMyListsButton() {
        actionsWithOurElements.clickOnElement(myListsButton);
    }

    public boolean isEnterButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(enterButton);
    }

    public boolean isUserMenuDisplayed() {
        return actionsWithOurElements.isElementDisplayed(userMenu);
    }
}
