package com.configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import base.BaseClass;

public class Factory extends BaseClass {
		/**
	 * page factory init elements classes
	 */
	

	private static final String exentreportfolder= System.getProperty("user.dir") + "/extent-report/";
	private static String extentreportfilepath = "";

	public static String getExtentReportFilePath()  {
		if (extentreportfilepath.isEmpty()) {
			try {
				extentreportfilepath = createReportPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return extentreportfilepath;
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String createReportPath() throws IOException {
		if (prop == null) {
			loadProperties();  // Ensure properties are loaded
		}

		if (prop.getProperty("overridereports").equalsIgnoreCase("no")) {
			return exentreportfolder + config.getcurrenttime() +"/"+config.getcurrenttime()+"report.html";
		} else {
			return exentreportfolder+ "/report.html";
		}
	}

}
