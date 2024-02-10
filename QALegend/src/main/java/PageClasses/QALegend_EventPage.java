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
	
	@FindBy(id = "start_date")
	WebElement startDate;
	@FindBy(xpath = "(//td[text()='1'])[3]")
	WebElement enterStartDate;
	@FindBy(id = "end_date")
	WebElement endDate;
	@FindBy(xpath = "(//td[text()='2'])[3]")
	WebElement enterEndDate;
	@FindBy(name = "location")
	WebElement location;
    
	
	
	@FindBy(xpath = "//label[text()='All team members']")
	WebElement shareWith;
	@FindBy(xpath = "//label[text()='Repeat']")
	WebElement repeat;
	
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButton;
	
	
	@FindBy(xpath ="//h1[text()='Event calendar']")
	WebElement eventCalendarTitle;
	
	
	
	

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
public void clickOnStartDate() {
	PageUtility.clickOnElement(startDate);
}
public void enterStartDate() {
	PageUtility.clickOnElement(enterStartDate);
}
public void clickOnEndDate() {
	PageUtility.clickOnElement(endDate);
}
public void enterEndDate() {
	PageUtility.clickOnElement(enterEndDate);
}
public void inputLocation(String message) {
	PageUtility.enterText(location, "Trvm");
}


public void selectShareWith() {
	PageUtility.scrollToElement(driver, shareWith);
	PageUtility.clickOnRadioButton(shareWith);
}
public void tickCheckBoxRepeat() {
	PageUtility.clickOnCheckBox(repeat);
}
public void clickOnSave() {
	PageUtility.clickOnElement(saveButton);
}
public String getTitleOfThePage()
{

return eventCalendarTitle.getText();
	
}
}
















