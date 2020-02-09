package com.altimetrik.selenium.assessment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkarthome {
	public WebDriver driver;

	public Flipkarthome(WebDriver driver) {           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	  @FindBy(css =  "button[class='_2AkmmA _29YdH8']")
	  private WebElement popupClose;
	  
	  @FindBy(css = "input[class='LM6RPg']")
	  private WebElement searchField;


	  
	  @FindBy(css = "button[class='vh79eN']")
	  private WebElement searchButton;
	  
	 public void searchProduct(String product)
	 {searchField.sendKeys(product);
		 
	 }
	  
	 public void searchButton()
	 {searchButton.click();
		 
	 }
	 
	 public void popupClose()
	 {popupClose.click();
		 
	 }
	 

	
	
	 
	
	 
	 
}
	

	


