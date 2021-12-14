
package com.Cnea.util;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.Cnea.util.DriverManager;
import com.Cnea.util.DriverManagerFactory;
import com.Cnea.util.DriverType;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Setup {

	public static WebDriver driver;
	static DriverManager driverManager;

	@Before
	/**
	 * Call browser in test design pattern factory Navigator 
	 */
	public static void setup() {

		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
	}

	@After
	/**
	 * Embed a screen shot in test if test is market as failed 
	 */
	public void embedScreenShot(Scenario scenario) {

		if(scenario.isFailed()) {
			try {
				scenario.write("Current page URL is" +driver.getCurrentUrl());
				byte [] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}catch (WebDriverException somePlatfomeDontSupportSreenshots) {
				System.err.println(somePlatfomeDontSupportSreenshots.getMessage());

			} 
		}

		driver.quit();
	}

}	


