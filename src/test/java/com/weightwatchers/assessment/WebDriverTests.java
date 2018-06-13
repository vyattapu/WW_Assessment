package com.weightwatchers.assessment;

import static org.testng.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.weightwatchers.pageObjects.FindMeetingPage;
import com.weightwatchers.pageObjects.HomePage;
import com.weightwatchers.pageObjects.MeetingLocationPage;
import com.weightwatchers.pages.BasePage;

public class WebDriverTests extends BasePage {
	
	@BeforeTest
	public void setUp() {
		driver = initializeDriver();
//		Step # 1
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void webDriverAssessmentValidationTests() {
		HomePage homePage = new HomePage(driver);
//		Step # 2
		assertTrue(homePage.getPageTitle().equals("Weight Loss Program, Recipes & Help | Weight Watchers"));
		
//		Step # 3
		homePage.getFindMeetingLink().click();
		FindMeetingPage findMeetingPage = new FindMeetingPage(driver);
		
//		Step # 4
		assertTrue(findMeetingPage.getPageTitle().contains("Get Schedules & Times Near You"));
		
//		Step # 5
		findMeetingPage.getSearchTextBox().sendKeys("10011");
		findMeetingPage.getSearchBtn().click();
		String firstLocationTitle = findMeetingPage.getLocationTitlesFromResults().get(0);
		
//		Step # 6
		System.out.println("Title of the first result: " + firstLocationTitle);
		System.out.println("Distance of the first result: " + findMeetingPage.getLocationDistancesFromResults().get(0));
		
//		Step # 7
		findMeetingPage.getFirstResultLink(firstLocationTitle).click();
		MeetingLocationPage meetingLocationPage = new MeetingLocationPage(driver);
		assertTrue(meetingLocationPage.getLocationNameLabel().getText().equals(firstLocationTitle));
		
//		Step # 8
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		List<String> hoursOfOperation = meetingLocationPage.getHoursOfOperation();
		System.out.println("Today\'s Hours of Operation are: " + System.lineSeparator()
							+ hoursOfOperation.get(calendar.get(Calendar.DAY_OF_WEEK) - 1));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
