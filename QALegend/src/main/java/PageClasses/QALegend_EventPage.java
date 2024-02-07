package PageClasses;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class QALegend_EventPage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//div[@class='title-button-group']")
	WebElement addEvent;

	@FindBy(name = "title")
	WebElement addTitle;
	
	@FindBy(id = "description")
	WebElement addDescription;
	
	@FindBy(xpath ="//h4[@id='ajaxModalTitle']")
	WebElement eventTitle;
	
	
	
	

	public QALegend_EventPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	

    public void clickOnAddEvent() {
    	PageUtility.clickOnElement(addEvent);
    }
    public void inputTitle(String message) {
PageUtility.enterText(addTitle, "Automation Page");
}
     	
public void inputDescription(String message) {
		
		PageUtility.enterText(addDescription, "This is Automated Page");
    
	}


public String getTitleOfThePage()
{

return eventTitle.getText();
	
}
}
