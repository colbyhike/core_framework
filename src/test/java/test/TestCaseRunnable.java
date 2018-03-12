package test;

import com.freecrm.utils.Xls_Reader;

public class TestCaseRunnable {

	public static void main(String[] args) {
		Xls_Reader x1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\freecrm\\xls\\A suite.xlsx");
		isTestCaseRunnable(x1, "TestCase_A1");
		System.out.println(isTestCaseRunnable(x1, "TestCase_A1"));
	}
	//Testcase in Runnable or not
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
