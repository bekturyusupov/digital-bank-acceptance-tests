package co.wedevx.digitalbank.automation.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Webdriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests.
It is built on top of Selenium/Webdriver to make your tests more readable, reusable and
maintainable by providing easy handling towards browser and advance identifiers.
*/
public class BrowserHelper {

    //wait until the element is visible
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    //wait until the element is clickable and click on it
    public static WebElement waitUntilElementClickableAndClick(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
        return  clickableElement;
    }



}
