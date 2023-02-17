package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData2 {
	
public static void writeData2(String customerid,int rowNum, int rowCount1) throws Exception {

File src = new File("./TestData/newaddcustomer.xlsx");
FileInputStream fis = new FileInputStream(src);

XSSFWorkbook wb = new XSSFWorkbook(fis);

XSSFSheet sheet1 = wb.getSheet("Sheet1");

XSSFCell cell = sheet1.getRow(rowNum).createCell(6);
cell.setCellValue(customerid);
System.out.println(customerid);

FileOutputStream fout = new FileOutputStream(src);
wb.write(fout);

wb.close();
}
}