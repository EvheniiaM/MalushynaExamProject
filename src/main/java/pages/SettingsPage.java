package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = ".//div[@class = 'alert alert-success alert-dismissible']")
    private WebElement successAlert;


    public SettingsPage(WebDriver webDriver) {
        super(webDriver, "/settings/profile");
    }

    public void enterStatusIntoStatusTextarea(String status) {
        actionsWithOurElements.enterTextIntoInput(statusTextarea, status);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void addAvatar(String filePath){
        actionsWithOurElements.enterTextIntoInput(avatarInput, filePath);
    }

    public String getAvatarSrc(){
        return avatarImage.getAttribute("src");
    }

    public boolean isSuccessAlertDisplayed(){
        return actionsWithOurElements.isElementDisplayed(successAlert);
    }

    public void deleteStatus() {
        actionsWithOurElements.clearInput(statusTextarea);
        clickOnSubmitButton();
    }
}
