package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//a[@id='navbarDropdownUser']")
    private WebElement userButton;

    @FindBy(xpath = ".//a[@href='https://kinobaza.com.ua/@studentqalight2019']")
    private WebElement profileButton;

    @FindBy(xpath = ".//a[@href='/settings/profile']")
    private WebElement settingsButton;

    @FindBy(xpath = ".//a[@href='https://kinobaza.com.ua/@studentqalight2019/lists']")
    private WebElement myListsButton;

    @FindBy(xpath = ".//a[@id = 'js-showSearchBar']")
    private WebElement searchButton;

//    @FindBy(xpath = ".//form[@role = 'search']")
    @FindBy(xpath = ".//div[@class = 'container d-lg-none']/form/span/input[2]")
    private WebElement searchForm;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public void clickOnUserButton() {
        actionsWithOurElements.clickOnElement(userButton);
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

    public boolean isUserButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(userButton);
    }

    public void clickOnSearchButton(){
        actionsWithOurElements.clickOnElement(searchButton);
    }

//    public void clickOnSearchForm(){
//        actionsWithOurElements.clickOnElement(searchForm);
//    }

//    public void enterFilmTitleIntoSearchForm(String filmTitle){
//        actionsWithOurElements.enterTextIntoInput(searchForm, filmTitle);
//    }

}
