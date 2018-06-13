package com.weightwatchers.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetingLocationPage {
public WebDriver driver;
	
	public MeetingLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	@FindBy(className = "location__name")
	WebElement locationNameLabel;
	
	@FindBy(className = "hours-list-item-day")
	List<WebElement> daysOfTheWeek;
	
	@FindBy(className = "hours-list-item-hours")
	List<WebElement> hoursOfOperation;
	
	public WebElement getLocationNameLabel() {
		return locationNameLabel;
	}
	
	public List<String> getDaysOfTheWeek() {
		List<String> values = new ArrayList<>();
		for(WebElement e: daysOfTheWeek)
			values.add(e.getText());
		return values;
	}
	
	public List<String> getHoursOfOperation() {
		List<String> values = new ArrayList<>();
		for(WebElement e: hoursOfOperation)
			values.add(e.getText());
		return values;
	}
}
