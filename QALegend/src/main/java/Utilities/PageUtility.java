package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	static WebDriver driver;
	public static void clickOnElement(WebElement element)
	{
		element.click();
	}
	public static void enterText(WebElement element, String value)
	{
		 element.sendKeys(value);
	}

	public static String getTextFromElement(WebElement element)
	{
	return element.getText();
	}
	public static void clearText(WebElement element)
	{
	element.clear();
	}
	public static void navigateBack(WebDriver driver)
	{
	driver.navigate().back();
	}
	public static String getAttributeValue(WebElement element,String attributeName)
	{
	return element.getAttribute(attributeName);
	}
	public static void acceptAlert(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
	public static void rightClickOnElement(WebDriver driver,WebElement element)
	{
	Actions actions= new Actions(driver);
	actions.contextClick(element).build().perform();
	}
	public static void rightClick(WebDriver driver)
	{
	Actions actions= new Actions(driver);
	actions.contextClick().build().perform();
	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public static void scrollToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,800)");
	}
	public static void clickUsingJavaScript(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}

	public static void selectDropdown(WebElement element, String visibleText) {
		
		Select staticDropdown = new Select(element);
		staticDropdown.selectByVisibleText(visibleText);
		
}
	public static void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }	
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public static void pressKey(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).build().perform();
    }

    public static void keyDown(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key).build().perform();
    }

    public static void keyUp(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key).build().perform();
    }
    public static void doubleClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }
    public static void clickAndHold(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public static void pressEnterKey(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }
    
        public static void clickOnRadioButton(WebElement radioButton) {
            radioButton.click();
        }
    
    public static void uploadFileWithRobot(String filePath) {
        try {
           
            Robot robot = new Robot();

            
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

           
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);

            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public static void clickOnCheckBox(WebElement checkBox) {
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }
    
}





