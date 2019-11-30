package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ProfilePage extends ParentPage {

    @FindBy(xpath = ".//a[contains(text(),'Інформація')]/../following-sibling::text()[1]")
    private WebElement status;

    @FindBy(xpath = ".//nav[@aria-label = 'breadcrumb']/..")
    private WebElement statusBlock;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019");
    }

    public String getStatusText() {
        String[] statusBlockText = statusBlock.getText().split("\n");
        String status = statusBlockText[statusBlockText.length - 1];
        return status;
    }
}
