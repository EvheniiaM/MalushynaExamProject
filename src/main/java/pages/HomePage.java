package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

//    @FindBy(xpath = ".//a[@id='navbarDropdownUser']")
//    private WebElement userButton;
//
//    @FindBy(xpath = ".//a[@href='https://kinobaza.com.ua/@studentqalight2019']")
//    private WebElement profileButton;

//    @FindBy(xpath = ".//a[@href='/settings/profile']")
//    private WebElement settingsButton;
//
//    @FindBy(xpath = ".//a[@href='https://kinobaza.com.ua/@studentqalight2019/lists']")
//    private WebElement myListsButton;

    @FindBy(xpath = ".//a[@id = 'js-showSearchBar']")
    private WebElement searchButton;

    @FindBy(xpath = ".//div[@class = 'container d-none d-lg-block']/div/form/span/input[@class = 'form-control form-control-lg js-typehead tt-input']")
    private WebElement searchForm;

    public Menu menu;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

//    public void clickOnUserButton() {
//        actionsWithOurElements.clickOnElement(userButton);
//    }

//    public void clickOnUserButtonWithWaiting() {
//        actionsWithOurElements.clickOnElementWithWaiting(userButton);
//    }

//    public void clickOnProfileButton() {
//        actionsWithOurElements.clickOnElement(profileButton);
//    }

//    public void clickOnSettingsButton() {
//        actionsWithOurElements.clickOnElement(settingsButton);
//    }
//
//    public void clickOnMyListsButton() {
//        actionsWithOurElements.clickOnElement(myListsButton);
//    }

//    public boolean isUserButtonDisplayed() {
//        return actionsWithOurElements.isElementDisplayed(userButton);
//    }

    public void clickOnSearchButton(){
        actionsWithOurElements.clickOnElement(searchButton);
    }

    public void clickOnSearchForm(){
        actionsWithOurElements.clickOnElement(searchForm);
    }

    public void enterFilmTitleIntoSearchForm(String filmTitle){
        actionsWithOurElements.enterTextIntoInput(searchForm, filmTitle);
//        searchForm.sendKeys(Keys.ENTER);
    }

//    public void selectFilmFromSearchDropDown(String filmTitle){
//        actionsWithOurElements.selectValueFromDropdownListWithJava(searchForm, filmTitle);
//    }

    public void pressEnterOnSearchForm(){
        try{
        searchForm.sendKeys(Keys.ENTER);
        logger.info("Enter button was pressed");
            }catch (Exception e) {
                    logger.error("Can not work with this element");
                }
    }

//    public void pressEnterButton(){
//        actionsWithOurElements.pressEnterButton();
//    }



}
