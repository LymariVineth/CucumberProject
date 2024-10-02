package com.OWASP.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.OWASP",
		plugin = {"pretty","summary",
				"html:src/test/resources/test-results/cucumber.html",
				"json:src/test/resources/test-results/cucumber.json",
				"junit:src/test/resources/test-results/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				},
		//tags = "@AddAddress",
		monochrome = false,
		publish = true,
		dryRun =  false
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
