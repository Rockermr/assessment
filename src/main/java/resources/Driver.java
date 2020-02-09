package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	  public WebDriver driver;
	public Properties prop;

public WebDriver initializeDriver() throws IOException
{
	
prop= new Properties();
FileInputStream fis=new FileInputStream("resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	driver= new ChromeDriver();
     driver.manage().window().maximize();
	
}
else
{
	System.out.println("Compatible driver not found for the browser "+browserName);
}

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
return driver;


}

public void takeScreenShot(String methodName,WebDriver driver) {
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with test method name 
       try {
			FileUtils.copyFile(scrFile, new File("screenshots\\"+methodName+".png"));
			System.out.println("***Screenshot Taken!***");
		} catch (IOException e) {
			e.printStackTrace();
		}
}
		 
public WebDriver getDriver() {
    return driver;
}	    

	}

