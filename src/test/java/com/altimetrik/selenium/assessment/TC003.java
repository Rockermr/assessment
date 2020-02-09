package com.altimetrik.selenium.assessment;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
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

import resources.Driver;


public class TC003 extends Driver{
	final static Logger logger = Logger.getLogger(TC001.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url3"));
	}
	@Test(dataProvider="getData")	
	public void testcase003(String fromPlace,String toPlace) throws InterruptedException
	{		 
		
		Googlemaps webPage=new Googlemaps(driver);
		webPage.getDirections();	
		webPage.fromPlace(fromPlace);
		webPage.fromDropdown();
		webPage.toPlace(toPlace);
		webPage.toDropdown();
		
		Assert.assertTrue(webPage.getFromPlace().toLowerCase().replaceAll("\\s", "").contains(fromPlace.toLowerCase().replaceAll("\\s", "")));
		Assert.assertTrue(webPage.getToPlace().toLowerCase().replaceAll("\\s", "").contains(toPlace.toLowerCase().replaceAll("\\s", "")));
List<String> eta=webPage.eta();
		if(eta.size()>=1)
{
			logger.info("ETA"+eta.get(1));
	
}
		else
		{
			Assert.assertTrue(false);
		}
		System.out.println(webPage.eta());

		}
	@AfterTest
	public void teardown()
	{
		
		//driver.close();
		driver=null;
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
	
	Object[][] data = new Object[1][2];
	 
	data[0][0]="silk board" ;
	data[0][1]="electronic city" ;

	return data;
	}

	

	
}
