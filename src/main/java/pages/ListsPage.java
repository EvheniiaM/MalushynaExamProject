package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ListsPage extends ParentPage {

    @FindBy(xpath = ".//a[@class = 'btn btn-primary btn-block']")
    private WebElement myListsButton;

    public ListsPage(WebDriver webDriver) {
        super(webDriver, "/lists");
    }

    public void clickOnMyListsButton(){
        actionsWithOurElements.clickOnElement(myListsButton);
    }
}
