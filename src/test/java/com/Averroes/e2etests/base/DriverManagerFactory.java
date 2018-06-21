package com.Averroes.e2etests.base;

public class DriverManagerFactory {

	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager;

		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case IE:
			driverManager = new InternetExplorerDriver();
			break;
		default:
			driverManager = new SafariDriverManager();
			break;
		}
		return driverManager;

	}
}
