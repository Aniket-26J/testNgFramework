package com.testcases;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import com.util.ExcelReader;



public class LoginPageTestTDD {

ExcelReader reader;

@Test(dataProvider = "GetDataUsingExcel")
public void validateLoginTest(String uname, String pass) {
System.out.println(uname);
System.out.println(pass);
}

@DataProvider(name = "GetDataUsingExcel")
public Object[][] getData() {
String Excelpath = "./TestData.xlsx";
String Sheetname = "Sheet1";
reader = new ExcelReader(Excelpath, Sheetname);
Object[][] data = reader.getTestData();
return data;
}
}