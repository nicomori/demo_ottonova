package com.demo.ottonova.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.ottonova.framework.ParentPage;

public class LoginPage extends ParentPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By LOGIN_BUTTON_PRESENTATION = By.id("de.number26.android:id/loginButton");
	By MAIL_FIELD = By.id("de.number26.android:id/edit_email");
	By PASSWORD_FIELD = By.id("de.number26.android:id/edit_password");
	By BUTTON_START_SESSION = By.id("(de.number26.android:id/button_login");

	By BUTTON_SYMBOL_PLUS = By.xpath("//android.view.ViewGroup[2]/android.widget.Button[5]");
	By BUTTON_SYMBOL_EQUAL = By.xpath("//android.view.ViewGroup[1]/android.widget.ImageButton[1]");

	/**
	 * this method make click in the symbol declared in the feature file.
	 * 
	 */
	public void pressClicInTheLoginButton() {
		waitForAnExplicitElement(LOGIN_BUTTON_PRESENTATION);
		click(LOGIN_BUTTON_PRESENTATION);
	}

	/**
	 * this method make click in the symbol declared in the feature file.
	 * 
	 */
	public void loginIntoTheApp() {
		waitForAnExplicitElement(MAIL_FIELD);
		sendKeysToLocator(MAIL_FIELD, "");
		sendKeysToLocator(PASSWORD_FIELD, "");
		click(BUTTON_START_SESSION);
	}

}
