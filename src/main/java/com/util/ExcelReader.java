package com.util;



import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {



static XSSFWorkbook workbook;



static XSSFSheet sheet;




public ExcelReader(String excelPath, String sheetName) {



try {



System.out.println(2);



workbook = new XSSFWorkbook(excelPath);



sheet = workbook.getSheet(sheetName);



System.out.println(excelPath);



System.out.println(sheetName);



} catch (IOException e) {



System.out.println("File not present");



}





}





public int getRowCount() {



System.out.println(3);



System.out.println(sheet);



int rowCount = 0;



rowCount= sheet.getPhysicalNumberOfRows();



return rowCount;



}





public int getColCount() {



int colCount = 0;



colCount= sheet.getRow(0).getLastCellNum();



return colCount;



}





public String getStringCellData(int rowNum, int colNum) {



String cellData = null;



cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();



return cellData;



}





public Object[][] getTestData(){



Object data[][] = null;



int rowCount = getRowCount();



int colCount = getColCount();



System.out.println("Row is: "+rowCount);



System.out.println("Col is: "+ colCount);



//subtracting 1 from rowcount becase we dont want to store header



data = new Object[rowCount-1][colCount];



//starting with row as 1 to skip the headers



for (int row = 1; row < rowCount; row++) {



for (int col = 0; col < colCount; col++) {



data[row-1][col] = getStringCellData(row, col);



}



}



return data;



}
}