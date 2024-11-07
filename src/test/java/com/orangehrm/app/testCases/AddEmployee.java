package com.orangehrm.app.testCases;

import org.testng.annotations.Test;

import com.orangehrm.app.pageObjects.AddEmployeePage;
import com.orangehrm.app.testUtilities.Dataprovider;

public class AddEmployee extends Baseclass{
	
	@Test(dataProviderClass = Dataprovider.class,dataProvider = "EmpData")
	public void validateAddEmployee(String fName,String middleName,String lastName) {
		test=extent.createTest("Add Employee Validation");
		AddEmployeePage addEmp=new AddEmployeePage(driver);
		addEmp.addEmployee(fName, middleName, lastName);
		logger.info("Added firstName,Middle Name and Last Name");
		test.pass("Added firstName,Middle Name and Last Name");
	}

}
