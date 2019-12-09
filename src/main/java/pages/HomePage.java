package pages;

import org.openqa.selenium.WebDriver;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    public Menu menu;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
}
