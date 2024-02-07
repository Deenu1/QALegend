package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageUtility;

public class QALegend_LoginPage {
	WebDriver driver;
	@FindBy(id="email")
	WebElement userNamefield;
	
	@FindBy(name ="password")
    WebElement passwordField;

    @FindBy(xpath ="//button[text()='Sign in']")
    WebElement signInButton;




	public QALegend_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username)
	{
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2)); // Wait for 10 seconds
    wait.until(ExpectedConditions.visibilityOf(userNamefield)); 
    PageUtility.enterText(userNamefield, username);
		
	}

	public void enterPassword(String password) {
        PageUtility.enterText(passwordField, password);
    }

    public void clickLoginButton() 
    {
    	signInButton.click();
    }


	}


