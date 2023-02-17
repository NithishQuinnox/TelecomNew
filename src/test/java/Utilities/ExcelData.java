package Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static XSSFSheet getSheet(int sheetNumber, String dataFilePath) {
		try {

			FileInputStream fileData = new FileInputStream(new File(dataFilePath));
			XSSFWorkbook wb = new XSSFWorkbook(fileData);
			XSSFSheet sheet = wb.getSheetAt(sheetNumber);
			// System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
			return sheet;

		} catch (Exception e) {
			return null;
		}
	}

	public static String[][] getData(int sheetNum, int rowNum, int colNum, String dataFilePath) {
		XSSFSheet sheet = getSheet(sheetNum, dataFilePath);
		// String[][] data = new String[2][2]

		String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		for (int i = rowNum; i < sheet.getLastRowNum(); i++) {
			for (int j = colNum; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}

		return data;
	}

	public static String[][] primaryKeyGetData(String primaryKey, int sheetNum, String filePath) {
		
		XSSFSheet sheet = getSheet(sheetNum, filePath);
		// String[][] = new String[sheet.get]

		// creating 2D array object of dynamic size
		String[][] data = new String[1][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getRow(0).getLastCellNum());
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i).getCell(0).getStringCellValue().equals(primaryKey)) {
					for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
						// System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
						data[0][j] = sheet.getRow(i).getCell(j).getStringCellValue();

					}
					
				}
			}

		return data;
	}
}