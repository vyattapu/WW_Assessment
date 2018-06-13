package com.weightwatchers.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {
	public static WebDriver driver;
	public Properties prop = new Properties();
	public WebDriver initializeDriver() {
		try(FileInputStream inputStream = new FileInputStream(".\\src\\test\\resources\\configuration\\config.properties")) {
			prop.load(inputStream);
			String browserType = prop.getProperty("browser");
			switch(browserType.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
				chromeOptions.addArguments("--disable-infobars");
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("disable-extensions");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);
				driver = new ChromeDriver(chromeOptions);
				System.out.println("Launching Chrome Driver...");
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
				driver = new InternetExplorerDriver();
				break;
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
