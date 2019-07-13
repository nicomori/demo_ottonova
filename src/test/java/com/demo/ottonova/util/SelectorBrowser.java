package com.demo.ottonova.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectorBrowser {

	public static DesiredCapabilities capabilities;
//	private static WebDriver driver = null;

	public static WebDriver createDriverWithoutCapabilities(String browser, WebDriver driver) {

		switch (browser) {
		case "Chrome":
			driver = OpenBrowserChrome.openBowserWithOutCapabilities(driver);
			break;
		case "chrome":
			driver = OpenBrowserChrome.openBowserWithOutCapabilities(driver);
			break;
		default:
			driver = OpenBrowserChrome.openBowserWithOutCapabilities(driver);
			break;

		}
		return driver;
	}
}
