package com.BStack.Utility;

public class CommonUtils {
	
	public static void waitForWhile(long millis) {
		
		try {
			Thread.sleep(millis);
			
		}catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}

}
