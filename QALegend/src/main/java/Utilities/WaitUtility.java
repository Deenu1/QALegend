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
}
