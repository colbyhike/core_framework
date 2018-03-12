package test;

import com.freecrm.utils.XlsReader;

public class SutieRunmode {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		
		XlsReader x = new XlsReader(System.getProperty("user.dir")+"src\\test\\java\\com\\freecrm\\xls\\Suite.xls");
		isSuiteRunnable(x,"Suites");
	}
	
	public static boolean isSuiteRunnable(XlsReader xls, String suiteName){
	
		return false;
	}

}
