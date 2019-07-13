package com.demo.ottonova.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenBrowserChrome {

	public static WebDriver openBowserWithCapabilities(DesiredCapabilities capabilities) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nico/Documents/github/example_demo_nicolasmori/chromedriver222");

		WebDriver driver = new ChromeDriver(capabilities);

		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriver openBowserWithOutCapabilities(WebDriver driver) {

		String oS = System.getProperty("os.name").toLowerCase();

		if (oS.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "C:/DriversBrowser/chromedriver.exe");

		} else if (oS.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/nico/Documents/github/example_demo_nicolasmori/chromedriver");
		} else {
			System.out.println("This is the OS: " + oS);
			System.out.println("OS is not compatible, you need define the path of the chromedriver again");
			System.exit(0);
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");

		// aca agrego la extencion para poder bloquear las imagenes que se carguen en la ejecucion
		options.addExtensions(new File("Block-image_v1.0.crx"));
		// aca agrego la extencion para poder bloquear las publicidades
		options.addExtensions(new File("AdBlock_v3.15.0.crx"));

		// fp.set_preference("http.response.timeout", 5)
		// fp.set_preference("dom.max_script_run_time", 5)

		driver = new ChromeDriver(options);

		// driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

		// driver.manage().window().maximize();
		return driver;
	}

}
