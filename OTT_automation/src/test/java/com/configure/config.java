package com.configure;

import java.util.Date;

public class config {

	/**
	 * get current time of system 
	 * @return data time format
	 */
	public static String getcurrenttime() {
		Date currentdate = new Date();
		String datafilename = currentdate.toString().replace(" ","-").replace(":", "-");
		return datafilename;
	}
	/** 
	 * Get property from the properties file
	 * @throws IOException
	 */

}