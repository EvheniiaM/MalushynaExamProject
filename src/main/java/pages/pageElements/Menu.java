package pages.pageElements;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;

@FindBy(xpath = ".//a[@class = 'navbar-brand']/..")
public class Menu extends CommonActionWithElements {

    @FindBy(xpath = ".//a[@class = 'navbar-brand']")
    private Link logoButton;

    @FindBy(xpath = ".//a[@class = 'nav-link' and @href = '/posts']")
    private Link postsButton;

    @FindBy(xpath = ".//a[@id = 'navbarDropdownTitles']")
    private Select allMoviesDropdown;

    @FindBy(xpath = ".//a[@href= '/reviews']")
    private Link reviewsButton;

    @FindBy(xpath = ".//a[@href= '/trailers']")
    private Link trailerButton;

    @FindBy(xpath = ".//a[@href= '/lists']")
    private Link listsButton;

    @FindBy(xpath = ".//a[@href= '/forum']")
    private Link forumButton;

    @FindBy(xpath = ".//a[@id = 'js-showSearchBar']")
    private Button searchButton;

    @FindBy(xpath = ".//a[@href= '/notifications']")
    private Link notificationsButton;

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


    @Step
    public void clickOnListsButton(){
        actionsWithOurElements.clickOnElement(listsButton);
    }

    @Step
    public void clickOnEnterButton() {
        actionsWithOurElements.clickOnElement(enterButton);
    }

    @Step
    public void clickOnUserMenu() {
        actionsWithOurElements.clickOnElement(userMenu);
    }

    @Step
    public void clickOnProfileButton() {
        actionsWithOurElements.clickOnElement(profileButton);
    }

    @Step
    public void clickOnSettingsButton() {
        actionsWithOurElements.clickOnElement(settingsButton);
    }

    @Step
    public void clickOnMyListsButton() {
        actionsWithOurElements.clickOnElement(myListsButton);
    }

    @Step
    public void clickOnSearchButton(){
        actionsWithOurElements.clickOnElement(searchButton);
    }

    @Step
    public boolean isEnterButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(enterButton);
    }

    @Step
    public boolean isUserMenuDisplayed() {
        return actionsWithOurElements.isElementDisplayed(userMenu);
    }
}
