package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_AnnouncementPage {
	
WebDriver driver;
@FindBy(xpath = "//a[text()=' Add announcement']")
WebElement addAnnouncement;
 @FindBy(id = "title")
 WebElement enterTitle;
 
 @FindBy(xpath = "//div[@class='note-editable panel-body']")
 WebElement textBody;
 
 @FindBy(id = "start_date")
 WebElement startDate;
 
 @FindBy(xpath = "(//td[text()='1'])[1]")
 WebElement selectStartDate;
 
 @FindBy(id = "end_date")
 WebElement endDate;
 
 @FindBy(xpath = "(//td[text()='3'])[1]")
 WebElement selectEndDate;
 
 @FindBy(id = "share_with_members")
 WebElement checkBox;
 
 @FindBy(xpath = "//button[text()=' Upload File']")
 WebElement uploadFile;
 
 @FindBy(xpath = "//span[text()='×']")
 WebElement alertMark;
 @FindBy(xpath = "//button[text()=' Save']")
 WebElement saveButton;



@FindBy(xpath = "//h1[text()='Edit announcement']")
WebElement editAnnouncement;



public QALegend_AnnouncementPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	public void clickOnAddAnnouncement() {
		PageUtility.clickOnElement(addAnnouncement);
	}
	public void enterTitle() {
		PageUtility.enterText(enterTitle, "Test Automation");
	}
	public void enterBodyOfAnnouncement() {
		PageUtility.enterText(textBody, "Test cases should be Automated");
	}
	public void clickOnStartDate() {
		PageUtility.clickOnElement(startDate);
	}
	public void clickOnSelectStartDate() {
		PageUtility.clickOnElement(selectStartDate);
	}
	public void clickOnEndDate() {
		PageUtility.clickOnElement(endDate);
	}
	public void clickOnSelectEndDate() {
		PageUtility.clickOnElement(selectEndDate);
	}
	public void selectCheckBox() {
		PageUtility.clickOnCheckBox(checkBox);
	}
	public void clickFileUpload(){
		PageUtility.scrollToElement(driver, uploadFile);
		PageUtility.clickOnElement(uploadFile);
	}
	public void uploadFile(String filePath) {
		PageUtility.uploadFileWithRobot("C:\\Users\\Administrator\\Desktop\\JAVA\\All-Java-components-Diagram.png");
	}
	public void clickOnAlert() {
		PageUtility.clickOnElement(alertMark);
	}
	public void clickSave() {
		PageUtility.scrollToElement(driver,saveButton);
		PageUtility.clickOnElement(saveButton);
	}
	
	public String displayEditAnnouncement() {
		return PageUtility.getTextFromElement(editAnnouncement);
	}
}











