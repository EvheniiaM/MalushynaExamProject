package pages;

import org.openqa.selenium.WebDriver;
import pages.pageElements.Menu;
import parentPage.ParentPage;

public class MoviesPage extends ParentPage {

    public Menu menu;

    public MoviesPage(WebDriver webDriver) {
        super(webDriver, "/movies");
    }
}


