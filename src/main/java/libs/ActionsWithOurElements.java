package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked " + getElementName(webElement));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

//    public void clickOnElementWithWaiting(WebElement webElement) {
//        try {
//            webDriverWait_15.until(ExpectedConditions.elementToBeClickable(webElement));
//            webElement.click();
//            logger.info("Element was clicked");
//        } catch (Exception e) {
//            stopTestAndPrintMessage();
//        }
//    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement) {
            elementName = "'" + ((TypifiedElement) webElement).getName() + "'";
        }
        return elementName;
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("Is element displayed -> false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

//    public void selectValueFromDropdownList(WebElement dropDown, String value) {
//        try {
//            dropDown.click();
//            clickOnElement(".//option[text() = '" + value + "']");
//            logger.info(value + " was selected from dropdown list");
//        } catch (Exception e) {
//            stopTestAndPrintMessage();
//        }
//    }
//
//    public void selectValueFromDropdownListWithJava(WebElement dropDown, String value) {
//        try {
//            Select select = new Select(dropDown);
//            select.selectByVisibleText(value);
//            logger.info(value + " was selected from dropdown list");
//        } catch (Exception e) {
//            stopTestAndPrintMessage();
//        }
//    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }

//    public boolean isElementDisplayed(String locator) {
//        try {
//            boolean state = webDriver.findElement(By.xpath(locator)).isDisplayed();
//            logger.info("Is element displayed -> " + state);
//            return state;
//        } catch (Exception e) {
//            logger.info("Is element displayed -> false");
//            return false;
//        }
//    }


    public void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clearInput(WebElement input) {
        try {
            input.clear();
            logger.info("Input was cleared");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void setStateToButton(String xpath, String state) {
        boolean isStateSelect = state.toLowerCase().equals("select");
        boolean isStateUnselect = state.toLowerCase().equals("unselect");
        boolean isButtonSelected = (webDriver.findElement(By.xpath(xpath))).getAttribute("data-on").equals("1");

        if (isStateSelect || isStateUnselect) {
            if ((isStateSelect && isButtonSelected) || (isStateUnselect && !isButtonSelected)) {
                logger.info("Button ia already in needed state");
            } else if ((isStateSelect && !isButtonSelected) || (isStateUnselect && isButtonSelected)) {
                clickOnElement(webDriver.findElement(By.xpath(xpath)));
            }
        } else {
            logger.error("State should be only select or unselect");
            stopTestAndPrintMessage();
        }
    }

    public void setStateToButton(WebElement button, String state) {
        boolean isStateSelect = state.toLowerCase().equals("select");
        boolean isStateUnselect = state.toLowerCase().equals("unselect");
        boolean isButtonSelected = button.getAttribute("data-on").equals("1");

        if (isStateSelect || isStateUnselect) {
            if ((isStateSelect && isButtonSelected) || (isStateUnselect && !isButtonSelected)) {
                logger.info("Button ia already in needed state");
            } else if ((isStateSelect && !isButtonSelected) || (isStateUnselect && isButtonSelected)) {
                clickOnElement(button);
            }
        } else {
            logger.error("State should be only select or unselect");
            stopTestAndPrintMessage();
        }
    }


    public void acceptAlert() {
        try {
            webDriverWait_10.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
            logger.info("Alert was accepted");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

//    public void pressEnterButton() {
//        try {
//            webDriver.findElement(By.xpath(".//html")).sendKeys(Keys.ENTER);
//            logger.info("Enter button was pressed");
//        } catch (Exception e) {
//            stopTestAndPrintMessage();
//        }
//    }


}
