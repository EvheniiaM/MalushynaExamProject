package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ProfilePage profilePage;
    protected SettingsPage settingsPage;
    protected MyListsPage myListsPage;
    protected CreateListsPage createListsPage;
    protected ListsPage listsPage;
    protected SeenListPage seenListPage;
    protected MoviesPage moviesPage;
    protected WatchListPage watchListPage;

    @Before
    public void setUp() throws Exception {

        webDriver = driverInit();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        profilePage = new ProfilePage(webDriver);
        settingsPage = new SettingsPage(webDriver);
        myListsPage = new MyListsPage(webDriver);
        createListsPage = new CreateListsPage(webDriver);
        listsPage = new ListsPage(webDriver);
        seenListPage = new SeenListPage(webDriver);
        moviesPage = new MoviesPage(webDriver);
        watchListPage = new WatchListPage(webDriver);
    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
//        }else if ("ie".equalsIgnoreCase(browser)){
//            WebDriverManager.iedriver().setup();
//            return new InternetExplorerDriver();
        }else if ("opera".equalsIgnoreCase(browser)){
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }else{
            throw new Exception ("Check browser var ");
        }
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }
}
