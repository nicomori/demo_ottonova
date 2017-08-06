package com.demo.ottonova.steps;

import com.demo.ottonova.framework.ParentScenario;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Steps extends ParentScenario {

	@Given("I start the android native calculator with this device \"(.*)?\"")
	public void accessTheAndroid(String uuid, String appPackage) {
		startAndroid(uuid, appPackage);
	}

	@Given("I start the android native app with this uuid \"(.*)?\" and this appPackage \"(.*)?\"")
	public void startAndroidNativeApp(String uuid, String appPackage) {
		startAndroid(uuid, appPackage);
	}

	@Given("I start the browser")
	public void accessToTheBrowser() {
		System.out.println("Starting the browser");
		startBrowser();
	}

	@And("I access to this url \"(.*)?\"")
	public void a111(String url) {
		System.out.println("Accessint to the url: " + url);
		navigateTo(url);
	}

}