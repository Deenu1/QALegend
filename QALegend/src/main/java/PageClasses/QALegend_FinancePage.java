package PageClasses;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class QALegend_FinancePage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[text()='Chart']")
	WebElement chart;
	
	@FindBy(xpath = "//a[text()='Summary']")
	WebElement summaryOfChart;
	@FindBy(id = "income-vs-expenses-summary-table")
	WebElement summaryTable;

	@FindBy(xpath = "//span[text()='Print']")
	WebElement printSummary;
	
	
	@FindBy(xpath = "//body[@class='dt-print-view']")
	WebElement printView;
	
	@FindBy(xpath = "//h4[text()='Income vs Expenses']")
	WebElement textvisible;
	
	
	
	
	public QALegend_FinancePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	
	public void chartVisibility() {
		PageUtility.isElementDisplayed(chart);
		
	}
	 public void clickOnSummary() {
		 PageUtility.clickOnElement(summaryOfChart);
		  }
	 public void clickSummaryTable() {
		 PageUtility.clickOnElement(summaryTable);
	 }
    public void clickOnPrintSummary() {
    	PageUtility.clickOnElement(printSummary);
    }
    
    public void printView() {
    	PageUtility.isElementDisplayed(printView);
    }
    public String getTextVisible()
	{
		return PageUtility.getTextFromElement(textvisible);
		
	
	}
}