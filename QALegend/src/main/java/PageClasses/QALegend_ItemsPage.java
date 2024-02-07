package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_ItemsPage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()=' Add item']")
	WebElement addItems;
	
	@FindBy(name ="title")
	WebElement inputTitle;
	@FindBy(id = "description")
	WebElement inputDescription;
	@FindBy(name = "unit_type")
	WebElement enterUnitType;
	@FindBy(name = "item_rate")
	WebElement enterItemRate; 
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveButton;
	@FindBy(xpath = "//h1[text()=' Items']")
	WebElement itemView;
	
	
	
	
	
	public QALegend_ItemsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnAddItems() {
		PageUtility.clickOnElement(addItems);
	}
	
	public void inputTitleField(String msg) {
		PageUtility.enterText(inputTitle, msg);
	}
	public void inputDescriptionField(String msg) {
		PageUtility.enterText(inputDescription, msg);
	}
	public void enterUnitTypeField(String msg) {
		PageUtility.enterText(enterUnitType, msg);
	}
	public void enterItemRateField(String msg) {
		PageUtility.enterText(enterItemRate,msg);
		
	}
	public void pressSaveButton() {
		PageUtility.clickOnElement(saveButton);
	}
	public String displayItem() {
		return PageUtility.getTextFromElement(itemView);
	}
}













