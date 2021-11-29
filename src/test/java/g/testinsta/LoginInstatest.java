package g.testinsta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import g.base.InstaBase;
import g.page.DBP;
import g.page.InstaPage;

public class LoginInstatest extends InstaBase {
	
	InstaPage lp;
	DBP gp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new InstaPage();
	}
	
	@BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
	}
	
	@Test
	public void validateTitleTest() {
		String expectedTitle = "Instagram";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void invalidLoginTest() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		gp=lp.invalidLogin(username, password);
		if(gp != null) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	@Test
	@Parameters({"uname" , "pass"})
	public void invalidLoginTestUsingParameters(String uname, String pass) {
		ExtentTest test = extent.createTest("InstaInvalidLogin");
		gp = lp.invalidLogin(uname,pass);
		test.log(Status.PASS, "ValidateLoginTestCasePassed");
	}
	
	@AfterTest
	public void GenerateReport() {
		CloseReportSetup();
	}
	
	@AfterMethod
	public void closesetup() {	
		teardown();
	}	
}