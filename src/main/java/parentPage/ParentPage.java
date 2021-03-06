package parentPage;

import io.qameta.allure.Step;
import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.pageElements.WebDriverAwareDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithOurElements actionsWithOurElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    String baseUrl;
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();

        PageFactory.initElements(new WebDriverAwareDecorator(new HtmlElementLocatorFactory(webDriver), webDriver), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = baseUrl + partUrl;

    }

    @Step
    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("URL is not expected", expectedUrl, webDriver.getCurrentUrl());
        } catch (Exception e){
            logger.error("Can not get URL " + e);
            Assert.fail("Can not get URL " + e);
        }
    }
}
