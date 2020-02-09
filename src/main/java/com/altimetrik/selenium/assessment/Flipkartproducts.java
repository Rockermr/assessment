package com.altimetrik.selenium.assessment;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkartproducts {
	public WebDriver driver;
public WebDriverWait wait;
	public Flipkartproducts(WebDriver driver) {           
		this.driver = driver; 
		 wait = new WebDriverWait(driver,30);

		PageFactory.initElements(driver,this );

		}
	  
	  
	  
	  @FindBy(xpath = "//div[@class='_3ywJNQ']/div[4]")
	  private WebElement priceHLSort;
	  

	  @FindBy(xpath = "//div[@class='_3ywJNQ']/div[3]")
	  private WebElement priceLHSort;
	  

	
	  
	
	 

	  @FindBy(css = "div[class='_1vC4OE _2rQ-NK']")
	  private List<WebElement> results;

	  @FindBy(xpath = "//div[@class='_1vC4OE _2rQ-NK']")
	  private WebElement result;
 
	  
	 
	 public void sortHighLow()
	 {priceHLSort.click();
		 
	 }
	 
	 public void sortLowHigh()
	 {priceLHSort.click();
		 
	 }
	 
	 public List<Double> results() throws InterruptedException, ParseException
	 {		PageFactory.initElements(driver,this );
Thread.sleep(1000);
		 List<Double> searchResults=new ArrayList<Double>();
		 for(WebElement element:results)
		 {
			 String bigNumber = element.getText().substring(1);
				NumberFormat format = NumberFormat.getInstance(Locale.US);
				Number number = format.parse(bigNumber);

			searchResults.add(number.doubleValue());
		 }
		 return searchResults;
	 }
	 
	 
}
	

	


