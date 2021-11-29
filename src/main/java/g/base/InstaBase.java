package g.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstaBase {
public static WebDriver driver;
	
	public static Properties prop;
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter reporter; 
	
	public InstaBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\seleniumtestngframework\\src\\main\\java\\g\\config\\config1.properties");
			prop.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
	}
	
	public void ExtentReportSetup() {
		String reportpath = System.getProperty("user.dir") + "/extentreport/index1.html";
		reporter = new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	public void CloseReportSetup() {
		extent.flush();
	}
	
	public static void teardown() {
		driver.quit();
	}

}
