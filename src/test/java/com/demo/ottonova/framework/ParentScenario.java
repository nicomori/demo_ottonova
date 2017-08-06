package com.demo.ottonova.framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.demo.ottonova.steps.StepsHelper;
import com.demo.ottonova.util.SelectorBrowser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * This Class is created for make a helper for all the pages, and all the parts of the a native app,
 * or for execute all the drivers. And for create all the objects of pages, or objects created in
 * all the pages.
 * 
 */

public class ParentScenario extends StepsHelper {

	protected static WebDriver driver;

	// protected static HomePage homePageNativeWG;

	/**
	 * this method create the object driver for Android.
	 * 
	 * @param uuid
	 *            of the device to use.
	 */
	public void startAndroid(String uuid, String appPackage) {

		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, uuid);
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, appPackage);
		// cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.wggesucht.android.WG_Gesucht");
		// cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.APP,
				"/Users/nico/Documents/github/example_demo_nicolasmori/wggesucht-android.apk");

		//
		cap.setCapability("noReset", true);
		cap.setCapability("deviceName", "8575525242395141");
		// cap.setCapability("fullReset", true);
		// cap.setCapability("fastReset", true);
		cap.setCapability("appWaitActivity", "com.wggesucht.android.WG_Gesucht");

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (Exception e) {
			System.out.println("Exeption at the moment to generate the driver = " + e);
		}

		// homePageNativeWG = new HomePage(driver);
		// toolBar = new ToolBar(driver);
		// loginPage = new LoginPage(driver);
		// homePage = new HomePage(driver);

	}

	public void startBrowser() {
		System.out.println("Starting driver for Browser Chrome");
		driver = SelectorBrowser.createDriverWithoutCapabilities("chrome", driver);

		// wg_ResultsPage = new WG_ResultsPage(driver);
		// wg_ResultsDetailPage = new WG_ResultsDetailPage(driver);
		// wg_DashboardPage = new WG_DashboardPage(driver);

	}

	protected void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void closeDriver() {
		driver.quit();
	}

}
