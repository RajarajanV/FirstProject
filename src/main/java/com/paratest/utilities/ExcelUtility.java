package com.paratest.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	XSSFSheet sheet;
	XSSFWorkbook workbook;
	Object[][] obj;

	@DataProvider(name = "testdata")
	public Object[][] passData() {

		String filepath = "C:\\Users\\kanagalakshmi\\workspace\\paratest\\src\\test\\java\\TestData\\SignUPTest.xlsx";
		try {
			File file = new File(filepath); // Create a file Object
			FileInputStream fis;

			fis = new FileInputStream(file); // Read the file

			workbook = new XSSFWorkbook(fis); // Load thw workbook
			sheet = workbook.getSheetAt(0); // Get the cpntrol over sheet 0
			int rowCount = sheet.getLastRowNum(); // Getting total rows
			int colCount = sheet.getRow(0).getLastCellNum(); // Getting total columns
	obj = new Object[rowCount][1]; // Specify Object array size
			for (int rows = 0; rows < rowCount; rows++) {
				Map<String, String> data = new HashMap<String, String>();
				for (int columns = 0; columns < colCount; columns++) {

					data.put(sheet.getRow(0).getCell(columns).toString(),
							sheet.getRow(rows + 1).getCell(columns).toString()); // Store 1 rows colums as keys and other row as values
					System.out.println(sheet.getRow(0).getCell(columns).toString()+"value"+sheet.getRow(rows + 1).getCell(columns).toString());
										 											
				}
				obj[rows][0] = data; // Store map values in 2D arrays

			
			}

		} catch (FileNotFoundException e) {
		//noding
			
		} catch (IOException e) {
		//noding
		}
		catch (Exception e) {
			//noding
			}
		
		return obj;
	}

}
