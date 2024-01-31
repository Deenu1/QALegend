package TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegend_LoginPage;

public class QALegendTestCases extends BaseClass 
{
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void initialization(String browser) throws Exception
	{
    driver = browserIntialization(browser);
    
    fis = new  FileInputStream("C:\\Users\\anagh\\QA_Legend\\src\\main\\java\\TestData\\testdata.properties");
    prop = new Properties();
    prop.load(fis);
    driver.get(prop.getProperty("url"));
	}

	public WebDriver browserIntialization(String browser) {
		// TODO Auto-generated method stub
		return null;
	}
	@Test(dataProvider = "login_Details")
    public void loginScenario(String username, String password) {
        driver.navigate().to("url");
        QALegend_LoginPage loginPage = new QALegend_LoginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        
    }

    @DataProvider(name = "login_Details")
    public Object[][] loginCRM() {
        return new Object[][]{{"admin@admin.com", "12345678"}}; //two-dimensional array with one row and two columns.
    }
}




