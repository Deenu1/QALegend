package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;

public class QALegend_ProjectPage {
	WebDriver driver;
	
	@FindBy(xpath = "(//span[@class='caret'])[2]")
	WebElement statusOfProjects;
	@FindBy(xpath = "//li[text()='Completed']")
	WebElement completedProject;
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement projectExcel;
	@FindBy(xpath = "//h1[text()='Projects']")
	WebElement projectText;
	
	
	
	public QALegend_ProjectPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnProjectStatus() {
		PageUtility.clickOnElement(statusOfProjects);
	}
	public void clickOnCompletedProject() {
		PageUtility.clickOnElement(completedProject);
	}
	public void clickOnExcel() {
        PageUtility.clickOnElement(projectExcel);
	}
	public String displayProjectText() {
		 return PageUtility.getTextFromElement(projectText);
	}
}
