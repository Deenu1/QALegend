package AutomationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.mongodb.MapReduceCommand.OutputType;

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

public class BaseClass {
	public WebDriver driver;
	FileInputStream fis;
	public Properties prop;
	public QALegend_LoginPage login_Page;
	public QALegend_HomePage home_Page;
	public QALegend_EventPage event_Page;
	public QALegend_FinancePage finance_Page;
	public QALegend_ProjectPage project_Page;
	public QALegend_ItemsPage item_Page;
	public QALegend_TimeCards timecards_Page;
	public QALegend_TicketPage ticket_Page;
	public QALegend_LeavePage leave_Page;
	public QALegend_AnnouncementPage announcement_Page;
    
	
public	final String excelFilePath="//src//main//java//TestData//TestData_Excel.xlsx";
	
	public WebDriver browserIntialization(String browserName) throws Exception
	{
		if (browserName.equalsIgnoreCase("Chrome"))
				{
	     driver = new ChromeDriver();//chrome
			
				}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();//edge
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();//firefox
		}
		else
		{
			throw new Exception("Invalid Name Exception");
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
		
	}
	@BeforeMethod
    @Parameters({"Browser"})
	public void initialization(String browser) throws Exception {
        driver = browserIntialization(browser);
        prop = new Properties();
        fis = new FileInputStream("C:\\Users\\Administrator\\git\\QALegend\\QALegend\\src\\main\\java\\TestData\\Testdata.properties");
        prop.load(fis);
        driver.get(prop.getProperty("url"));
        login_Page = new QALegend_LoginPage(driver);
        home_Page = new QALegend_HomePage(driver,prop);
        event_Page=new QALegend_EventPage(driver);
        finance_Page=new QALegend_FinancePage(driver);
        project_Page=new QALegend_ProjectPage(driver);
        item_Page=new QALegend_ItemsPage(driver);
        timecards_Page=new QALegend_TimeCards(driver);
        ticket_Page=new QALegend_TicketPage(driver);
        leave_Page=new QALegend_LeavePage(driver);
        announcement_Page=new QALegend_AnnouncementPage(driver);
        
        Thread.sleep(2000);
        login_Page.enterUserName(prop.getProperty("username"));
        login_Page.enterPassword(prop.getProperty("password"));
        login_Page.clickLoginButton();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
		Files.copy(source,new File(destinationFile));
		return destinationFile;
		
	}
	
}



