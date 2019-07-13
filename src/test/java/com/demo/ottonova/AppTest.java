package com.demo.ottonova;

import cucumber.api.CucumberOptions;

/**
 * Example of Automation. Creator: Nicolas Mori
 */

@CucumberOptions(plugin = { "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json",
		"junit:target/surefire-reports/cucumber-junit.xml" }, features = "src/test/resources/features", tags = "@Regression1", glue = {
				"com.demo.ottonova.steps" })
public class AppTest {

}
