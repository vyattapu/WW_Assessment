package com.weightwatchers.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ela-menu-visitor-desktop-supplementa_find-a-meeting")
	WebElement findMeetingLink;
	
	public WebElement getFindMeetingLink() {
		return findMeetingLink;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
