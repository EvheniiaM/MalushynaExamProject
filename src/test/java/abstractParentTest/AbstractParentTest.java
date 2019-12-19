package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected HomePage homePage;
    protected ProfilePage profilePage;
    protected SettingsPage settingsPage;
    protected MyListsPage myListsPage;
    protected CreateListsPage createListsPage;
    protected ListsPage listsPage;
    protected SeenListPage seenListPage;
    protected MoviesPage moviesPage;
    protected WatchListPage watchListPage;
    protected SearchPage searchPage;

    protected Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws Exception {

        webDriver = driverInit();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage = new HomePage(webDriver);
        profilePage = new ProfilePage(webDriver);
        settingsPage = new SettingsPage(webDriver);
        myListsPage = new MyListsPage(webDriver);
        createListsPage = new CreateListsPage(webDriver);
        listsPage = new ListsPage(webDriver);
        seenListPage = new SeenListPage(webDriver);
        moviesPage = new MoviesPage(webDriver);
        watchListPage = new WatchListPage(webDriver);
        searchPage = new SearchPage(webDriver);
    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if ("opera".equalsIgnoreCase(browser)){
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }else{
            throw new Exception ("Check browser var ");
        }
    }

    @After
    public void tearDown(){
//        webDriver.quit();
    }
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }
        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }
        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }
        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };

    @Step
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }
}
