package test;

import com.freecrm.utils.Xls_Reader;

public class ReportData_UpdateResult {

	public static void main(String[] args) {

		Xls_Reader x1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\freecrm\\xls\\A suite.xlsx");
		reportDataSetResult(x1, "TestCase_A1", 3, "pass");
		System.out.print(reportDataSetResult(x1, "TestCase_A1", 4, "fail"));

	}
	
	//update a result for particular data set
	public static boolean reportDataSetResult(Xls_Reader xls, String testCaseName, int rowNum, String result){
		xls.getCellData(testCaseName, result, rowNum);
		return false;
	}

}
