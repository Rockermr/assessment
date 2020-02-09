package com.altimetrik.selenium.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Googlemaps {
	public WebDriver driver;
	public WebDriverWait wait;

	public Googlemaps(WebDriver driver) {           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);		}
	
	@FindBy(id = "searchbox-directions")
	private WebElement directions;
	
	public void getDirections()
	{
		directions.click();
	}
	
	
@FindBy(xpath="//div[@id='sb_ifc51']/input")
private WebElement fromPlace;

@FindBy(xpath="//div[@id='sb_ifc52']/input")
private WebElement toPlace;


@FindBy(xpath="//div[contains(@class, 'section-directions-trip-duration')]")
private List<WebElement> eta;

public void fromPlace(String place)
{
	fromPlace.sendKeys(place);
}

public void toPlace(String place)
{
	toPlace.sendKeys(place);
}

public String getFromPlace()
{
	return fromPlace.getAttribute("aria-label");
}

public String getToPlace()
{
	return toPlace.getAttribute("aria-label");
}

public List<String> eta() throws InterruptedException
{
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'section-directions-trip-duration')]"))); 

	List<String> data=new ArrayList<String>();
	for(WebElement element: eta)
	{
		data.add(element.getText());
		
		
	}
	data.removeAll(Arrays.asList("", null));
	return data;
}

public void fromDropdown() throws InterruptedException
{
	Thread.sleep(1000);
	fromPlace.sendKeys(Keys.DOWN, Keys.RETURN);
}
	 
	
public void toDropdown() throws InterruptedException
{	Thread.sleep(1000);

	toPlace.sendKeys(Keys.DOWN, Keys.RETURN);
}

	 
}
	

	


