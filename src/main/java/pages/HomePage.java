package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//a[@id='navbarDropdownUser']")
    private WebElement smileButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSmileButtonDisplayed(){
        try{
            return smileButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
