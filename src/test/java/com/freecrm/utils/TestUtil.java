package com.freecrm.utils;

public class TestUtil {
	
public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName){
		
		boolean isExecutable = false;
		
		for(int i=2; i<=xls.getRowCount("Test Suite"); i++){
		/*String suite = xls.getCellData("Test Suite", "TCID", i);
		String runmode = xls.getCellData("Test Suite", "Runmode", i);
		System.out.println(suite+"---"+runmode);*/
		
		if(xls.getCellData("Test Suite", "TCID", i).equalsIgnoreCase(suiteName)){
			if(xls.getCellData("Test Suite", "Runmode", i).equalsIgnoreCase("y")){
				isExecutable = true;
			}else{
				isExecutable = false;
			}
		}
		
	}
		xls = null;// to release the memory
		return isExecutable;
 }
	//to verify the test cases
    public static boolean isTestCaseRunnable(Xls_Reader xls, String testCaseName){
	
	boolean isExecutable = false;
	
	for(int i=2; i <= xls.getRowCount("TestCase"); i++){
	//String tcid = xls.getCellData("TestCase", "TCID", i);
	//String runmode = xls.getCellData("TestCase", "Runmode", i);
	//System.out.println(tcid+"----"+runmode);
	//validation
	if(xls.getCellData("TestCase", "TCID", i).equalsIgnoreCase(testCaseName)){
		if(xls.getCellData("TestCase", "Runmode", i).equalsIgnoreCase("y")){
			isExecutable = true;
		}else{
			isExecutable = false;
		}
	}

}
	//xls = null;//to clear meomory
	return isExecutable;
}

	

}
