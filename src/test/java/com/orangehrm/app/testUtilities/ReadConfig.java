package com.orangehrm.app.testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	
	//Method to read confrig file
	public String getFromConfingFile(String data)
	{
	    String dataFromFile=pro.getProperty(data);
	    return dataFromFile;
	}


	

}
