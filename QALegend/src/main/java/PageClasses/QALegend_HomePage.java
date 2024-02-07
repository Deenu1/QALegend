package PageClasses;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import dev.failsafe.internal.util.Assert;

public class QALegend_HomePage {
    WebDriver driver;
    Properties properties;
    
    @FindBy(xpath = "//span[@class='topbar-user-name']")
    WebElement userProfileName;
    
    @FindBy(xpath = "//a[text()=' Sign Out']")
    WebElement signOutUser;
    
    @FindBy(xpath="//img[@class='dashboard-image']")
    WebElement logo;
    
    @FindBy(xpath = "//span[text()='Events']")
    WebElement eventTab;
    
   @FindBy(id="js-chat-min-icon")
   WebElement chatBox;
    
   @FindBy(xpath = "(//strong[text()='Saumia Alex'])[1]")
   WebElement senderMessage;
   
   @FindBy(name="reply_message")
   WebElement replyMessage;
   
   @FindBy(xpath = "//span[text()='Finance']")
	WebElement financeTab;
	 
   @FindBy(xpath = "//span[text()='Income vs Expenses']")
	WebElement incomeVsExpensesTab;
    
   @FindBy(xpath = "//span[text()='Projects']")
   WebElement projectTab;
   @FindBy(xpath = "//span[text()='All Projects']")
   WebElement allProjects;
   
   @FindBy(xpath = "//span[text()='Items']")
   WebElement itemsTab;
   
   @FindBy(xpath = "//span[text()='Time cards']")
   WebElement timeCardsTab;
   
   @FindBy(xpath = "//span[text()='Tickets']")
   WebElement ticketsTab;
   
   @FindBy(xpath = "//i[@class='fa fa-sign-out font-16']")
   WebElement leaveTab;
   
   @FindBy(xpath = "//span[text()='Announcements']")
   WebElement announcementTab;
   
   @FindBy(xpath = "//textarea[@placeholder='Write a message...']")
   WebElement placeholderReplyMsg;
   
  
    
  
   public QALegend_HomePage(WebDriver driver,Properties prop) {
        this.driver = driver;
        //this.prop=prop;
        PageFactory.initElements(driver, this);
    }
    

	public void logOut() {
        PageUtility.clickOnElement(userProfileName);
        PageUtility.clickOnElement(signOutUser);
    }
    
    public String getUserProfileName() {
        String userName = PageUtility.getTextFromElement(userProfileName);
        return userName;
    }
    public void navigateToHomePage() {
        
        PageUtility.clickOnElement(logo);
    }
    public void clickOnEventTab() {
    	PageUtility.clickOnElement(eventTab);
    }
public void clickOnChatBox() {
	PageUtility.clickOnElement(chatBox);
}
public void clickOnSenderMessage() {
	PageUtility.clickOnElement(senderMessage);
}
public void getReplyMessage(String message) {
    PageUtility.enterText(replyMessage, message);
    
}

public String displayRepliedMessage(String placeholder) {
    return PageUtility.getAttributeValue(placeholderReplyMsg,placeholder);
}
 
   public void pressEnterKey() {
	   PageUtility.pressEnterKey(driver);
   }
	
	public void clickOnFinance() {
		PageUtility.clickOnElement(financeTab);
	}
	public void clickOnIncomeVsExpenses() {
		PageUtility.moveToElement(driver, incomeVsExpensesTab);
		PageUtility.clickOnElement(incomeVsExpensesTab);
	}
	
	public void clickOnProject() {
		PageUtility.clickOnElement(projectTab);
		PageUtility.clickOnElement(allProjects);
	}
	public void clickOnItemsTab() {
		PageUtility.clickOnElement(itemsTab);
	}
	public void clickOnTimeCards() {
		PageUtility.clickOnElement(timeCardsTab);
	}

public void clickOnTicketsTab() {
	PageUtility.clickOnElement(ticketsTab);
}

	public void clickOnLeaveTab() {
		PageUtility.scrollToElement(driver,leaveTab);
		PageUtility.clickOnElement(leaveTab);
	}
	public void clickOnannouncementTab() {
		PageUtility.scrollToElement(driver, announcementTab);
		PageUtility.clickOnElement(announcementTab);
	}
	
}
    












