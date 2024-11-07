package com.orangehrm.app.testCases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.app.testUtilities.ReadConfig;
import com.orangehrm.app.testUtilities.WebDriverUtitlies;

public class Baseclass {
	
	public static ReadConfig readconfig;
	static String  applictionURL;
	static String userName;
	static String password;
	public static WebDriver driver;
	public static String actualTitle;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentTest test ;
	public static ExtentHtmlReporter htmlReporter;
	public static SimpleDateFormat simpleDate;
    public static WebDriverUtitlies webdriverutils;
	
	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browser)
	{
		readconfig = new ReadConfig();
		applictionURL = readconfig.getFromConfingFile("baseURL");
		userName = readconfig.getFromConfingFile("userName");
		password = readconfig.getFromConfingFile("password");
		actualTitle=readconfig.getFromConfingFile("actualTitle");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
		String strDate = formatter.format(date);
		htmlReporter = new ExtentHtmlReporter("test-output\\ExtentReportResults" + strDate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		logger = Logger.getLogger("orangeHRM");
		PropertyConfigurator.configure("Log4j.properties");
		
		webdriverutils=new WebDriverUtitlies();
		if(browser.contentEquals("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		else if(browser.contentEquals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		
		driver.get(applictionURL);
		logger.info("Opened Application URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterSuite
	public void tearDown()
	{
		driver.quit();

	}
	
	@AfterMethod
	public void flushExtent()
	{
		extent.flush();
	}
}
