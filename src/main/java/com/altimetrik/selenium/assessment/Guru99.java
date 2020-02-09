package com.altimetrik.selenium.assessment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99 {
	public WebDriver driver;

	public Guru99(WebDriver driver) {           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	  @FindBy(xpath = "//table[@class=\"dataTable\"]/tbody/tr") 
	  private List<WebElement> tableData;
	  
	  public List<String> companyFinder(String companyName)
	  {
			List<String> companyDetails=new ArrayList<String>();
		for(WebElement rowData:tableData)
		  {
			  
			  String cmpName=rowData.findElement(By.tagName("a")).getText();
			  if(cmpName.equals(companyName))
			  {
				  Iterator<WebElement> rowIterator=rowData.findElements(By.xpath(".//td")).iterator();
				  while(rowIterator.hasNext())
				  {
					  companyDetails.add(rowIterator.next().getText());
				  }
			  }
		  }
		  return companyDetails;
	  }

	

}
