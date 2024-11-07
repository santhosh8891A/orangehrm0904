package com.orangehrm.app.testUtilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {

	// Method to read the data from excel and pass the parameters to the test case
	// using Dataprovider.
	@DataProvider(name = "EmpData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\orangehrm\\app\\testData\\EmpData.xlsx";
		// Number of Rows
		int rownum = XlUtitlies.getRowCount(path, "Sheet1");
		// Number of Columns
		int colcount = XlUtitlies.getCellCount(path, "Sheet1", 1);
		String empData[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empData[i - 1][j] = XlUtitlies.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return empData;
	}

}
