package com.weightwatchers.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindMeetingPage {
	public WebDriver driver;
	
	public FindMeetingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	@FindBy(id = "meetingSearch")
	WebElement searchTextBox;
	
	@FindBy(className = "form-blue-pill__btn")
	WebElement searchBtn;
	
	@FindBy(className = "location__name")
	List<WebElement> locationTitles;
	
	@FindBy(className = "location__distance")
	List<WebElement> locationDistancess;
	
	@FindBy(className = "meeting-locations-list__item")
	List<WebElement> searchResults;
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public List<String> getLocationTitlesFromResults() {
		List<String> values = new ArrayList<>();
		for(WebElement e: locationTitles)
			values.add(e.getText());
		return values;
	}
	
	public List<String> getLocationDistancesFromResults() {
		List<String> values = new ArrayList<>();
		for(WebElement e: locationDistancess)
			values.add(e.getText());
		return values;
	}
	
	public WebElement getFirstResultLink(String linkText) {
		return driver.findElement(By.partialLinkText(linkText));
	}
}
