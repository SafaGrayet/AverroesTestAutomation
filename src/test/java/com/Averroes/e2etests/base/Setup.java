package com.Averroes.e2etests.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Setup {

	public static WebDriver driver;
	static DriverManager driverManager;

	@Before     
	/**   
	 * Call Browser
	 */
	public static void setup() throws IOException, InterruptedException {

		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);

		driver = driverManager.getDriver();
		//driver.get("https://rct-selogervacances.poliris.net/");
		driver.navigate().to("http://127.0.0.1:8099/share/page/");
       

        //System.out.println("The password is"+ user.password);*/
      driver.findElement(By.name("username")).sendKeys("admin");
      Thread.sleep(500);
        driver.findElement(By.name("password")).sendKeys("Safa1994");

        driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
        //boutton.loginbtn.click();

	}

	@After   
	
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	 public void afterScenario(Scenario scenario) {
		
		 if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				try {
					//This takes a screenshot from the driver at save it to the specified location
					File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					//Building up the destination path for the screenshot to save
					//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
					File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");
					
					//Copy taken screenshot from source location to destination location
					Files.copy(sourcePath, destinationPath);   

					//This attach the specified screenshot to the test
					Reporter.addScreenCaptureFromPath(destinationPath.toString());
				} catch (IOException e) {
				} 
			}
		// driver.quit(); 
	}
}
