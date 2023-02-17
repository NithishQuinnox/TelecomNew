package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	String exceldatapath="./TestData/newaddcustomer.xlsx";
	
	
	@DataProvider
	public Object[][] getLoginData() {
	
		
	Object data[][]= ExcelData.primaryKeyGetData("Nithish", 0, exceldatapath);
	return data;
	}
	
	@DataProvider
	public Object[][] getLoginData1() {
	//Object data[][]= ExcelDataCustomer.getTestData("Sheet2");
	Object data[][]= ExcelData.primaryKeyGetData("97", 1, exceldatapath);
	return data;
	}

}
