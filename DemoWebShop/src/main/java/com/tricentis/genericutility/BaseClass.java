package com.tricentis.genericutility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tricentis.objectrepository.HomePage;
import com.tricentis.objectrepository.LoginPage;
import com.tricentis.objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extReport;
	public ExtentTest test; //for test script
	public static ExtentTest screenTest; //for listeners
	
	public FileUtility fUtils;
	public ExcelUtility eUtils;
	public JavaUtility jUtils;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	
	@BeforeSuite
	public void configReport()
	{
		jUtils = new JavaUtility();
		String timestamp=jUtils.getSystemTime();
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/ExtentReport_"+timestamp+".html");
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browserName.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver(); 
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       fUtils = new FileUtility();
       driver.get(fUtils.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login(Method method) throws IOException
	{
		test=extReport.createTest(method.getName()); //instead of hardcoding we are getting method names dynamically
		screenTest = test; //if we just use test without making it static we are getting null exception so we have created screenTest, made it static and assigned test value to it
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		lp = new LoginPage(driver);
		lp.getEmailTF().sendKeys(fUtils.getDataFromProperty("email"));
		lp.getPasswordTF().sendKeys(fUtils.getDataFromProperty("password"));
		lp.getLoginButton().click();
		eUtils = new ExcelUtility();
		String expectedTitle = eUtils.getStringDataFromExcel("Home", 1, 0);
		Assert.assertEquals(expectedTitle, driver.getTitle(), "User has failed to login");
		Reporter.log("User has logged in successfully", true);
		hp=new HomePage(driver);
	}
	
	@AfterMethod
	public void logout()
	{
		hp.getLogoutLink().click();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup()
	{
		extReport.flush();
	}
	
}
