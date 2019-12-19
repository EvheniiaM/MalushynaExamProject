package pages;

import org.openqa.selenium.WebDriver;
import pages.pageElements.Menu;
import pages.pageElements.MovieBlock;
import parentPage.ParentPage;

public class SearchPage extends ParentPage {

    public Menu menu;
    public MovieBlock movieBlock;

    public SearchPage(WebDriver webDriver) {
        super(webDriver, "/search");
    }
}
