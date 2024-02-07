package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import Utilities.PageUtility;

public class QALegend_TicketPage {
	
WebDriver driver;
 
 @FindBy(xpath = "//a[text()=' Add ticket']")
 WebElement addTickets;
 @FindBy(name = "title")
 WebElement insertTitle;
 @FindBy(id = "description")
 WebElement descriptionBox;
 @FindBy(xpath = "//label[text()='Client']")
 WebElement addClient;
 @FindBy(id = "s2id_client_id")
 WebElement clickAddClient;
 @FindBy(xpath = "//div[text()='AAAA ']")
 WebElement selectClient;
 
 @FindBy(xpath = "//button[text()=' Upload File']")
 WebElement uploadFile;
 @FindBy(xpath = "//button[text()=' Save']")
 WebElement saveButton;
 
 @FindBy(xpath = "//label[text()='Open']")
 WebElement statusOpen;

 






public QALegend_TicketPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
	public void clickOnAddTickets() {
		PageUtility.clickOnElement(addTickets);
	}
	
	public void inputTitle(String message) {
		PageUtility.enterText(insertTitle, "Ticket Test");
		}
	public void addClientTab() {
		PageUtility.clickOnElement(addClient);
	}
	public void clickOnAddClient() {
		PageUtility.clickOnElement(clickAddClient);
	}
	public void clickSelectClient() {
		PageUtility.clickOnElement(selectClient);
	}
	public void clickOnDescription() {
		PageUtility.clickOnElement(descriptionBox);
	}
	public void insertDescrition(String message) {
		PageUtility.enterText(descriptionBox, "Ticket Description");
	}
	public void clickOnFileUpload() {
		PageUtility.clickOnElement(uploadFile);
	}
	
	public void fileUpload(String filePath) {
		PageUtility.uploadFileWithRobot("C:\\Users\\Administrator\\Desktop\\JAVA\\All-Java-components-Diagram.png");
	}

	public void clickSaveButton() {
		PageUtility.clickOnElement(saveButton);
	}
	public String openStatus() {
		return PageUtility.getTextFromElement(statusOpen);
	}
}













