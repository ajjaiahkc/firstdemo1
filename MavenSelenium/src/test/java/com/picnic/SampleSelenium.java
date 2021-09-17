package com.picnic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SampleSelenium{
	ExtentSparkReporter reporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUp() {
	reporter = new ExtentSparkReporter("myreport.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}
	@Test
	public void TestMethod2() {
		ExtentTest test = extent.createTest("My first test");
		test.log(Status.INFO, "This shows info");
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\ajjaiahk\\eclipse-selenium_Trainig\\SeleniumProject\\Drivers\\geckodriver.exe");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();// creat instance of chrome driver
			driver.get("https://www.google.co.in/");// metod to use to open url and then it will
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Bellary");
			driver.manage().window().maximize();
			searchBox.submit();
			//Thread.sleep(6000);// let the user actully see something
			driver.quit();

		}
			@AfterSuite
			public void tearDown() {
			extent.flush();
			}
	}

