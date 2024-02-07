package AutomationCore;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;
import com.mongodb.MapReduceCommand.OutputType;

public class BaseClass {
	public WebDriver driver;
public	String excelFilePath="//src//main//java//TestData//TestData_Excel.xlsx";
	@SuppressWarnings("deprecation")
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
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
		Files.copy(source,new File(destinationFile));
		return destinationFile;
		
	}
	
}



