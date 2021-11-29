package com.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;

import com.pages.LoginPage;



public class LoginPageTest extends TestBase {

LoginPage lp;

@BeforeMethod
public void setup() {
initialization();
lp = new LoginPage();
}

@BeforeTest
public void Reportsetup() {
ExtentReportSetup();
}

@Test(enabled = false)
public void validateTitleTest() {
ExtentTest test = extent.createTest("OrangeHRMTitleTestCase");
String expectedTitle = "OrangeHRM";
String actualTitle = lp.validateTitle();
Assert.assertEquals(actualTitle, expectedTitle);
test.log(Status.PASS, "ValidateTitleTestCasePassed");
}



@Test(dataProvider = "getData")
public void validateLoginUsingTestNGDataProvider(String uname, String pwd) {
//lp.validateLogin(uname, pwd);
System.out.println(uname);
System.out.println(pwd);
}

@DataProvider
public Object[][] getData() {
// Row Indicates how many times we want to execute the testcases
// Column indicates how many values we want to pass the testcases
Object[][] data = new Object[2][2];
data[0][0] = "Admin";
data[0][1] = "admin123";
data[1][0] = "Tom";
data[1][1] = "pass";
return data;
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