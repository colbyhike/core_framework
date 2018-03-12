package test;

import com.freecrm.utils.Xls_Reader;

public class SuiteRunmode {

	public static void main(String[] args) {
		
	Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\freecrm\\xls\\Suites.xlsx");
	isSuiteRunnable(x, "Suites");
	isTestCasesRunable(x, "A Suite");
	}
	//find the test if the runmode is yes
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName){
		
		boolean isExecutable = false;
		for(int i=2; i<=xls.getRowCount("Test Suite"); i++){
		String suite = xls.getCellData("Test Suite", "TCID", i);
		String runmode = xls.getCellData("Test Suite", "Runmode", i);
		if(suite.equalsIgnoreCase(suiteName)){
			if(runmode.equalsIgnoreCase("y")){
				isExecutable = true;
			}else{
				isExecutable = false;
			}
		}
		
	}
		xls = null;// to release the memory
		return isExecutable;
	}
	
	public static boolean isTestCasesRunable(Xls_Reader xls, String sheetName){
		for(int i=2; i<=xls.getRowCount("Test Suite"); i++){
			String tcid = xls.getCellData("Test Suite", "TCID", i);
			String runmode=xls.getCellData("Test Suite", "Runmode", i);
			System.out.println(tcid+"---"+runmode);
		
		}
		return false;
	}
	
}
