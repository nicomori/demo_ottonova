package com.demo.ottonova.framework;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

/**
 * This Class is an abstract class, and created for make the interaction with the class ParentPage.
 */
public abstract class DSL {
	public WebDriver driver;

	public DSL(WebDriver driver2) {
		this.driver = driver2;
	}

	/**
	 * @param locator
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * @param locator
	 */
	public boolean isEnable(By locator) {
		return driver.findElement(locator).isEnabled();
	}

	/**
	 * 
	 */
	public void clickJS(By locator) {

		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * @param locator,
	 *            string to send
	 */
	public void sendKeysToLocator(By locator, String stringToSend) {
		driver.findElement(locator).sendKeys(stringToSend);
	}

	/**
	 * 
	 */
	public void buttonBackDevice() {
		driver.navigate().back();
	}

	/**
	 * 
	 */
	public boolean verifyIfisDisplayed(By locator) {
		if (driver.findElement(locator).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	public String getTextByLocator(By locator) {
		return driver.findElement(locator).getText();
	}

	/**
	 * 
	 */
	public String getTextInContentDescriptionByLocator(By locator) {
		return ((AndroidDriver) driver).findElement(locator).getAttribute("name");

	}

	/**
	 * 
	 */
	public String verifyBolaStatusIsFailed(int index) {

		return driver.findElement(By.xpath("(//tr[contains(@id,'job_')]//td[1][" + "contains(@data,'0') or " // fail
				+ "contains(@data,'4') or " // pass
				+ "contains(@data,'5') or " // executing pass
				+ "contains(@data,'1') or " // executing fail
				+ "contains(@data,'10') or " + "contains(@data,'8')" // disable
				+ "])[" + index + "]")).getAttribute("data");
		// return
		// driver.findElement(By.xpath("(//table[@id='projectstatus']//tbody//tr//td//img[@style='width:
		// 32px; height: 32px; ' and
		// contains(@tooltip,'Failed')])["+index+"]")).isDisplayed();

		// return driver.findElement(locator).getText();
	}

	// (//tr[contains(@id,'job_')]//td[1][contains(@data,'0')])[7]

	/**
	 * 
	 */
	public String getTextNameOfTheTask(int index) {
		return driver.findElement(By.xpath("(//tr//td[3]//a[1])[" + index + "]")).getText();
	}

	/**
	 * 
	 */
	public void refreshBrowser() {
		driver.navigate().refresh();
		// return
		// driver.findElement(By.xpath("(//tr//td[3]//a[1])["+index+"]")).getText();
	}

	/**
	 * 
	 */
	public String getAverageTimeLastExecution(int index) {
		// return
		// driver.findElement(By.xpath("(//tr//td[6])["+index+"]")).getText();
		return driver.findElement(By.xpath("(//tr//td[6])[" + index + "]")).getAttribute("data");
	}

	/**
	 * 
	 */
	public void pressClickInTheSchedulerOfTheTask(String task) {
		System.out.println("Waiting for the element with the name " + task + " appear");
		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[contains(@href,'" + task + "')]//img[contains(@alt,'Schedule')]")));
		System.out.println("Making click in the element " + task);
		driver.findElement(By.xpath("//*[contains(@href,'" + task + "')]//img[contains(@alt,'Schedule')]")).click();
	}

	/**
	 * 
	 */
	public void waitForAnExplicitElement(By locator) {

		WebElement myDynamicElement = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * 
	 */
	public String getTextOfALocator(By locator) {
		return driver.findElement(locator).getText();
	}

	/**
	 * 
	 */
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	private static final SimpleDateFormat horaActual = new SimpleDateFormat("HH");
	private static final SimpleDateFormat minutosActual = new SimpleDateFormat("mm");
	private static final SimpleDateFormat segundosActual = new SimpleDateFormat("ss");
	private static final SimpleDateFormat dayActual = new SimpleDateFormat("dd");
	private static final SimpleDateFormat monthActual = new SimpleDateFormat("MM");
	private static final SimpleDateFormat yearActual = new SimpleDateFormat("yy");

	public String getActualHour() {
		Date date = new Date();
		return horaActual.format(date);
	}

	public String getActualMinutes() {
		Date date = new Date();
		return minutosActual.format(date);
	}

	public String getActualSeconds() {
		Date date = new Date();
		return segundosActual.format(date);
	}

	public String getActualDay() {
		Date date = new Date();
		return dayActual.format(date);
	}

	public String getActualMonth() {
		Date date = new Date();
		return monthActual.format(date);
	}

	public String getActualYear() {
		Date date = new Date();
		return yearActual.format(date);
	}

	public void donwloadImage(By locatorOfTheImage, String scenarioName) throws IOException {
		System.out.println("Starting to get the data of the image");
		String s = driver.findElement(locatorOfTheImage).getAttribute("src");
		URL url = new URL(s);
		System.out.println("Starting to generate the buffer for the image");
		BufferedImage bufImgOne = ImageIO.read(url);
		System.out.println("Starting to write the image");
		ImageIO.write(bufImgOne, "png", new File("imagesFailedScenarios/" + scenarioName + ".png"));
		System.out.println("Image download completed for the scenario " + scenarioName);
	}

	public void accessToAURL(String url) {
		driver.get(url);
		// driver.get("https://applause.automation.applause.com/?auto_refresh=true");
	}

	/**
	 * 
	 */
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0, 5250);");

	}

	/**
	 * 
	 */
	public void stopBrowserLoad() {
		// ((JavascriptExecutor) driver).executeScript("window.stop();");
		driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return window.stop");
	}

	/**
	 * 
	 */
	public boolean verifyIfAWebelementIsDeployed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	// ############### MOBILE SECTIONS ######################

	/**
	 * this method make scroll down in a mobile Native App until a text appear, and after all that
	 * make click in the text.
	 * 
	 * @param textToFind
	 *            this is the text to find and make click.
	 */
	public void scrollDownUntilFindAStringAndMakeClick(String textToFind) {
		boolean flag = false;

		Dimension dimensions = driver.manage().window().getSize();

		Double screenHeightStart = dimensions.getHeight() * 0.4;
		Double screenHeightEnd = dimensions.getHeight() * 0.2;

		int scrollStart = screenHeightStart.intValue();
		System.out.println("s=" + scrollStart);

		int scrollEnd = screenHeightEnd.intValue();

		flag = false;

		while (flag == false) {
			try {
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + textToFind + "')]")).click();

				flag = true;
			} catch (Exception e) {
				((AndroidDriver) driver).swipe(0, scrollStart, 0, scrollEnd, 500);
			}
		}
	}

	/**
	 * this method is for make a refresh in the mobile native apps.
	 * 
	 */
	public void refreshSwipingToDown() {
		Dimension dimensions = driver.manage().window().getSize();

		Double screenHeightStart = dimensions.getHeight() * 0.2;
		Double screenHeightEnd = dimensions.getHeight() * 0.5;

		int scrollStart = screenHeightStart.intValue();
		int scrollEnd = screenHeightEnd.intValue();

		((AndroidDriver) driver).swipe(0, scrollStart, 0, scrollEnd, 200);

	}

	/**
	 * this method is for make a refresh in the mobile native apps.
	 * 
	 */
	public void scrollDownDevice() {
		System.out.println("Preparing the scroll down.");
		boolean flag = false;

		Dimension dimensions = driver.manage().window().getSize();

		Double screenHeightStart = dimensions.getHeight() * 0.6;
		Double screenHeightEnd = dimensions.getHeight() * 0.4;

		int scrollStart = screenHeightStart.intValue();

		int scrollEnd = screenHeightEnd.intValue();

		System.out.println("Starting to make the scroll down");
		((AndroidDriver) driver).swipe(0, scrollStart, 0, scrollEnd, 500);
		System.out.println("Scroll down completed");
	}

	/**
	 * 
	 */
	public void buttonBackMobile() {
		((AndroidDriver) driver).navigate().back();
	}

}
