package com.inetBanking.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig()
	{
		File configFile = new File("./Configuration/config.proprties");
		try {
			FileInputStream fis = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(fis);			
			}
		catch (Exception e) {
			System.out.println("Exceptio from ReadConfig.java -- " + e.getMessage());
			}		
	}
	
	public String getBaseURL() {
		String baseURL = prop.getProperty("URL");
		return baseURL;
	}
	public String getusername() {
		String Username = prop.getProperty("UserName");
		return Username;
	}
	public String getPassword() {
		String Password = prop.getProperty("password");

		return Password;
	}
	
	/*
	 * public static void main(String[] args) { ReadConfig rc = new ReadConfig();
	 * System.out.println("URL Test -----------   " + rc.getBaseURL()); }
	 */
}
