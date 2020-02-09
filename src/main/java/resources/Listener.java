package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;


public class Listener implements ITestListener 					
{
	final static Logger logger = Logger.getLogger(Listener.class.getName());



	public void onTestSuccess(ITestResult result) {
		logger.info("***** Success "+result.getName()+" has Passed *****");
		String methodName=result.getName().toString().trim();
getScreenshot(result, "Pass",methodName);       
		
	}

	public void onTestFailure(ITestResult result) {
		
		logger.error("***** Error "+result.getName()+" has failed *****");
		String methodName=result.getName().toString().trim();
		getScreenshot(result, "Fail",methodName);       

		
		
	}
	  

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



	public static String timestamp() {
		
		
	    return new SimpleDateFormat("dd-MM-yyyy hh-mm-ss a").format(new Date());
	}
	
	public void getScreenshot(ITestResult result,String status,String methodName)
	{          Object currentClass = result.getInstance();
    
		WebDriver webDriver = ((Driver) currentClass).getDriver();
        Shutterbug.shootPage(webDriver, ScrollStrategy.WHOLE_PAGE).withName(methodName+"_"+timestamp()+"_"+status+".png").save();

		

	}

   
}		