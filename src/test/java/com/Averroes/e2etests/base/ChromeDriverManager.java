package com.Averroes.e2etests.base;

import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

	private ChromeDriverService chService;

	@Override
	public void startService() {
		if (null == chService) {
			try {
				chService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File("src/test/resources/Drivers Exécutables/chromedriver.exe"))
						.usingAnyFreePort().build();
				chService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}

	@Override
	public void createDriver() {
		String downloadFilepath = "src/test/resources/Téléchargements";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

		options.setExperimentalOption("prefs", chromePrefs);

		options.addArguments("--test-type");

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);

		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(chService, cap);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

}
