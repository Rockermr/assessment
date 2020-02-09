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


public class TC002 extends Driver{
	private List<String> details;
	final static Logger logger = Logger.getLogger(TC001.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url2"));
	}
	@Test(dataProvider="getData")	
	public void testcase002(String productName) throws IOException, InterruptedException, ParseException
	{
		
		
		 
		
		Flipkarthome homePage=new Flipkarthome(driver);
		Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		homePage.popupClose();
		homePage.searchProduct(productName);
		homePage.searchButton();
		Flipkartproducts prodPage=new Flipkartproducts(driver);
		prodPage.sortHighLow();
		List<Double> unsortedList=prodPage.results();
		List<Double> sortedList=prodPage.results();
		Collections.sort(sortedList, Collections.reverseOrder());
		logger.info(sortedList);
		logger.info(unsortedList);
		Assert.assertTrue(unsortedList.equals(sortedList));		
		
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
	
	Object[] data = new Object[1];
	 
	data[0]="mobile" ;
	return data;
	}

	

	
}
