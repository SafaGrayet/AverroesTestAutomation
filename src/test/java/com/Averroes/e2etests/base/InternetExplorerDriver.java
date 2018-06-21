package com.Averroes.e2etests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InternetExplorerDriver extends DriverManager {

	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers Exécutables/MicrosoftWebDriver.exe");
	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createDriver() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

}
