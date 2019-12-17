package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.Menu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.*;

public class SettingsPage extends ParentPage {

    @FindBy(xpath = ".//textarea[@ name = 'status']")
    private TextInput statusTextarea;

    @FindBy(xpath = ".//button[@type = 'submit']")
    private Button submitButton;

    @FindBy(xpath = ".//input[@type = 'file']")
    private FileInput avatarInput;

    @FindBy(xpath = ".//form[@enctype = 'multipart/form-data']/img")
    private Image avatarImage;

    @FindBy(xpath = ".//input[@name= 'remove_watchlist_after_rate']")
    private CheckBox removeFromWachListAfterRateCheckbox;

    @FindBy(xpath = ".//div[@class = 'alert alert-success alert-dismissible']")
    private Link successAlert;

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
