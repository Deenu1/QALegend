package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_LeavePage {
	
WebDriver driver;

@FindBy(xpath = "//a[text()=' Apply leave']")
WebElement applyLeave;

@FindBy(id = "s2id_leave_type_id")
WebElement leaveType;

@FindBy(id = "select2-results-3")
WebElement casualLeave;

@FindBy(id = "duration_single_day")
WebElement singleDay;

@FindBy(xpath = "//label[text()='Date']")
WebElement dateLabel;

@FindBy(xpath = "//td[text()='1']")
WebElement selectDate;

@FindBy(id = "reason")
WebElement reasonForLeave;

@FindBy(xpath = "//button[text()=' Apply leave']")
WebElement applyLeaveButton;

@FindBy(xpath = "//h1[text()='Leave']")
WebElement leaveView;





public QALegend_LeavePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void clickOnApplyLeave() {
	PageUtility.clickOnElement(applyLeave);
}

public void clickOnLeaveType() {
	PageUtility.clickOnElement(leaveType);
}
public void selectLeaveType() {
	
	PageUtility.clickOnElement(casualLeave);
}
public void radioButtonSelect() {
	PageUtility.clickOnRadioButton(singleDay);
}
	public void clickOnDate() {
		PageUtility.clickOnElement(dateLabel);
	}
	public void clickOnSelectDate() {
		PageUtility.clickOnElement(selectDate);;
	}
	public void enterReasonForLeave() {
		PageUtility.enterText(reasonForLeave, "Family Event");
	}
	public void clickOnApplyLeaveButton() {
		PageUtility.clickOnElement(applyLeaveButton);
	}
	public String leaveTextDisplay() {
		return PageUtility.getTextFromElement(leaveView);
	}
}













