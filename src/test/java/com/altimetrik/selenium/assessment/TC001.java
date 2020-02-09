package com.altimetrik.selenium.assessment;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.Driver;


public class TC001 extends Driver{
	final static Logger logger = Logger.getLogger(TC001.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{

		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url1"));
	}
	@Test(dataProvider="getData")	
	public void testcase001(String companyName) throws IOException
	{
		
		
		Guru99 webPage=new Guru99(driver);
		try {
			Assert.assertEquals(driver.getTitle(), "Web Table Elements");
			logger.info("Title Successfully Validated");
			
		} catch (Throwable e) {
		
			logger.error("Title Validation Failed!", e);
			Assert.fail();
		}
		Iterator<String> iterator=webPage.companyFinder(companyName).iterator();
		if(iterator.hasNext())
		{
		logger.info("Match Found");
		logger.info("Name: "+iterator.next());
		logger.info("Group: "+iterator.next());
		String prevClose=iterator.next();
		String currClose=iterator.next();
		logger.info("Previous Close: "+prevClose);
		logger.info("Current Price: "+currClose);	
		int prevCloseDecimal=prevClose.length()-prevClose.indexOf(".")-1;
		int currCloseDecimal=currClose.length()-currClose.indexOf(".")-1;


if((prevCloseDecimal==1||prevCloseDecimal==prevClose.length())&&(currCloseDecimal==1||currCloseDecimal==currClose.length()))
		{
	logger.info("Price Format is correct");
	
		}
else
{
	
	logger.error("Price Format is incorrect");

		Assert.fail();

	

}
		}
		else
		{
			logger.error("No Match Found");

Assert.fail();			
	
			
		}
		
		}
	@AfterTest
	public void teardown()
	{
		
		//driver.close();
		driver=null;
		
	}
	
	@DataProvider
	public Object[] getData()
	{
	
	Object[] data = new Object[2];
	 
	data[0]="Sun Pharma." ;
	data[1]="Kajaria Ceramics";
	


	return data;
	}


  


    

}