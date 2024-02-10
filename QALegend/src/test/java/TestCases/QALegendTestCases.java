package TestCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Placeholder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mongodb.internal.connection.ReplyMessage;

import AutomationCore.BaseClass;
import PageClasses.QALegend_AnnouncementPage;
import PageClasses.QALegend_EventPage;
import PageClasses.QALegend_FinancePage;
import PageClasses.QALegend_HomePage;
import PageClasses.QALegend_ItemsPage;
import PageClasses.QALegend_LeavePage;
import PageClasses.QALegend_LoginPage;
import PageClasses.QALegend_ProjectPage;
import PageClasses.QALegend_TicketPage;
import PageClasses.QALegend_TimeCards;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtility;


public class QALegendTestCases extends BaseClass {
    public WebDriver driver;
    

    
    
       
        
    @Test(priority = 1,groups = {"Regression"})
    public void loginCRM() {
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
    }
    @Test(priority = 8,groups = {"Smoketest"})
    public void addEvent() throws IOException, InterruptedException {
//    	home_Page.logOut();
//    	login_Page.enterUserName(prop.getProperty("username"));
//        login_Page.enterPassword(prop.getProperty("password"));
//        login_Page.clickLoginButton();
//        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
   
    home_Page.clickOnEventTab();
    event_Page.clickOnAddEvent();
    String event_Title=ExcelUtility.getString(1, 0, excelFilePath, "Events")+FakerUtility.randomNumberCreation();
    event_Page.inputTitle(event_Title);
    event_Page.inputDescription(ExcelUtility.getString(1, 1, excelFilePath, "Events"));
    System.out.println(FakerUtility.randomNumberCreation());
    event_Page.clickOnStartDate();
    event_Page.enterStartDate();
    event_Page.clickOnEndDate();
    event_Page.enterEndDate();
    event_Page.inputLocation(ExcelUtility.getString(1, 2, excelFilePath, "Events")+FakerUtility.randomNumberCreation());
    event_Page.selectShareWith();
    event_Page.tickCheckBoxRepeat();
    event_Page.clickOnSave();
   Assert.assertEquals(event_Page.getTitleOfThePage(),prop.getProperty("eventCalendarTitle"));
    
    }
    
    @Test(priority = 2,groups = {"Regression"})
    public void testChatBoxFunctionality() throws InterruptedException { 
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
        Thread.sleep(2000);
        home_Page.clickOnChatBox();
        home_Page.clickOnSenderMessage();
        home_Page.getReplyMessage(prop.getProperty("replyMessage"));
        home_Page.pressEnterKey();
        Assert.assertEquals(home_Page.displayRepliedMessage("placeholder"),prop.getProperty("placeholdervalue"));
        
            }
    @Test(priority = 9,groups = {"Smoketest"})
    public void incomeVsExpenses() throws InterruptedException, AWTException {
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
        Thread.sleep(2000);
        home_Page.clickOnFinance();
        home_Page.clickOnIncomeVsExpenses();
        Thread.sleep(2000);
        finance_Page.chartVisibility();
        finance_Page.clickOnSummary();
        Thread.sleep(2000);
        finance_Page.clickSummaryTable();
        Thread.sleep(2000);
        finance_Page.clickOnPrintSummary();
        finance_Page.printView();
        Assert.assertEquals(finance_Page.getTextVisible(),prop.getProperty("textvisible"));
        }
    @Test(priority = 3,groups = {"Regression"})
    public void projectStatusDropdown() throws InterruptedException {
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
        Thread.sleep(2000);
        home_Page.clickOnProject();
        project_Page.clickOnProjectStatus();
        project_Page.clickOnCompletedProject();
        project_Page.clickOnExcel();
        Assert.assertEquals(project_Page.displayProjectText(),prop.getProperty("projectText"));
        }
    @Test(priority = 4,groups = {"Smoketest"})
    public void addItems() throws InterruptedException { 
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
        Thread.sleep(2000);
        home_Page.clickOnItemsTab();
        item_Page.clickOnAddItems();
        item_Page.inputTitleField(prop.getProperty("inputTitle"));
        item_Page.inputDescriptionField(prop.getProperty("inputDescription"));
        item_Page.enterUnitTypeField(prop.getProperty("enterUnitType"));
        item_Page.enterItemRateField(prop.getProperty("enterItemRate"));
        Thread.sleep(2000);
        item_Page.pressSaveButton();
        Assert.assertEquals(item_Page.displayItem(),prop.getProperty("itemView"));
        }   
    
    @Test(priority = 10,groups = {"Regression"})
    public void clockInOrOutMembers() throws InterruptedException { 
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
       
        home_Page.clickOnTimeCards();
        Thread.sleep(2000);
        timecards_Page.clickOnClockInOrOut();
        timecards_Page.clickOnStatusOfKeerthana();
        timecards_Page.getTotalWorkHours();
        Assert.assertEquals(timecards_Page.getTotalWorkHours(),prop.getProperty("totalWorkHours"));
        
}
    @Test(priority = 5,groups = {"Smoketest"})
    public void Tickets() throws InterruptedException{ 
        home_Page.logOut();
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
         
        home_Page.clickOnTicketsTab();
        ticket_Page.clickOnAddTickets();
        ticket_Page.inputTitle(prop.getProperty("insertTitle"));
        Thread.sleep(2000);
        ticket_Page.addClientTab();
        ticket_Page.clickOnAddClient();
        ticket_Page.clickSelectClient();
        ticket_Page.clickOnDescription();
        ticket_Page.insertDescrition(prop.getProperty("insertDescription"));
        ticket_Page.clickOnFileUpload();
        Thread.sleep(2000);
        ticket_Page.fileUpload(prop.getProperty("filePath"));
        ticket_Page.clickSaveButton();
        Assert.assertEquals(ticket_Page.openStatus(),prop.getProperty("statusOpen"));
}
    @Test(priority = 7,groups = {"Regression"})
    public void applyLeave() throws InterruptedException {
    	home_Page.logOut();
    	login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
        Thread.sleep(2000);
        home_Page.clickOnLeaveTab();
        leave_Page.clickOnApplyLeave();
        leave_Page.clickOnLeaveType();
        leave_Page.selectLeaveType();
        leave_Page.radioButtonSelect();
        leave_Page.clickOnDate();
        leave_Page.clickOnSelectDate();
        leave_Page.enterReasonForLeave();
        leave_Page.clickOnApplyLeaveButton();
        Assert.assertEquals(leave_Page.leaveTextDisplay(),prop.getProperty("leaveView"));
   
        
}
    @Test(priority = 6,groups = {"Smoketest"})
    public void addAnnouncement() throws InterruptedException {
    	home_Page.logOut();
    	login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
        org.testng.Assert.assertEquals(home_Page.getUserProfileName(), prop.getProperty("userProfileName"));
        Thread.sleep(2000);
        home_Page.clickOnannouncementTab();
        announcement_Page.clickOnAddAnnouncement();
        announcement_Page.enterTitle();
        announcement_Page.enterBodyOfAnnouncement();
        announcement_Page.clickOnStartDate();
        announcement_Page.clickOnSelectStartDate();
        announcement_Page.clickOnEndDate();
        announcement_Page.clickOnSelectEndDate();
        announcement_Page.selectCheckBox();
        announcement_Page.clickFileUpload();
        Thread.sleep(2000);
        announcement_Page.uploadFile(prop.getProperty("filePath"));
        announcement_Page.clickOnAlert();
        announcement_Page.clickSave();
        Assert.assertEquals(announcement_Page.displayEditAnnouncement(),prop.getProperty("editAnnouncement"));
        }}

