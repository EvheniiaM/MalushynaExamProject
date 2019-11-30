package pages;

import org.openqa.selenium.WebDriver;
import parentPage.ParentPage;

public class SeenListPage extends ParentPage {
    public SeenListPage(WebDriver webDriver) {
        super(webDriver, "/@studentqalight2019/seenlist");
    }
}
