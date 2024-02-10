package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
public static void waitForAnElementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public static void waitForAnElementToBeVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public static void waitForAFrame(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
}

public static void waitForTitleToContain(WebDriver driver, String title) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); //Waits until the title of the web page contains the specified text.
    wait.until(ExpectedConditions.titleContains(title));
}

public static void waitForURLToBe(WebDriver driver, String url) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); //Waits until the URL of the web page matches the specified URL.
    wait.until(ExpectedConditions.urlToBe(url));
}

public static void waitForInvisibilityOfElement(WebDriver driver, WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); //Waits until the specified element becomes invisible.
    wait.until(ExpectedConditions.invisibilityOf(element));
}

public static void waitForAlert(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); //Waits until an alert is present.
    wait.until(ExpectedConditions.alertIsPresent());
}
}