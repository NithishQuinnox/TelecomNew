package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataCustomer {
static Workbook book;
static Sheet sheet;

public static String path = ".//TestData//newaddcustomer.xlsx";


public static Object[][] getTestData(String sheetName) {
FileInputStream file=null;
try {
file=new FileInputStream(path);

book=WorkbookFactory.create(file);
}
catch(Exception e) {
e.printStackTrace();
}
sheet=book.getSheet(sheetName);
Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
for(int i=0;i<sheet.getLastRowNum();i++) {
for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
data[i][k]=sheet.getRow(i+1).getCell(k).toString();
}
}
return data;
}
}