package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.PageUtility;

public class QALegend_LoginPage {
	WebDriver driver;
	@FindBy(name = "email")
	WebElement userNamefield;
	
	@FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signInButton;




	public QALegend_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void enterUserName(String username)
	{
		PageUtility.enterText(userNamefield, username);
	}

	public void enterPassword(String password) {
        PageUtility.enterText(passwordField, password);
    }

    public void clickLoginButton() {
    	signInButton.click();
    }


	}


