package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class SettingsPage extends ParentPage {

    @FindBy(xpath = ".//textarea[@ name = 'status']")
    private WebElement statusTextarea;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = ".//input[@type = 'file']")
    private WebElement avatarInput;

    @FindBy(xpath = ".//form[@enctype = 'multipart/form-data']/img")
    private WebElement avatarImage;

    @FindBy(xpath = ".//input[@name= 'remove_watchlist_after_rate']")
    private WebElement removeFromWachListAfterRateCheckbox;

    @FindBy(xpath = ".//div[@class = 'alert alert-success alert-dismissible']")
    private WebElement successAlert;

    public Menu menu;

    public SettingsPage(WebDriver webDriver) {
        super(webDriver, "/settings/profile");
    }

    @Step
    public void enterStatusIntoStatusTextarea(String status) {
        actionsWithOurElements.enterTextIntoInput(statusTextarea, status);
    }

    @Step
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    @Step
    public void addAvatar(String filePath){
        actionsWithOurElements.enterTextIntoInput(avatarInput, filePath);
    }

    public String getAvatarSrc(){
        return avatarImage.getAttribute("src");
    }

    @Step
    public boolean isSuccessAlertDisplayed(){
        return actionsWithOurElements.isElementDisplayed(successAlert);
    }

    @Step
    public void deleteStatus() {
        try {
            statusTextarea.clear();
            clickOnSubmitButton();
            logger.info("Status was cleared");
        }catch (Exception e){
            logger.error("Can not work with element");
        }
    }

    @Step
    public void setStateToRemoveFromWatchListAfterRateCheckbox(String expectedState){
        actionsWithOurElements.setStateToCheckBox(removeFromWachListAfterRateCheckbox, expectedState);
    }
}
