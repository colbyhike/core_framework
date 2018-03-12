package test;

import com.freecrm.utils.Xls_Reader;

public class TestDataExtract {

	public static void main(String[] args) {
		
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\freecrm\\xls\\A suite.xlsx");
		getData(x, "TestCase_A1");
	}
	
	public static Object[][] getData(Xls_Reader xls ,String testCaseName){
		
		//if the sheet is not present
		if(! xls.isSheetExist(testCaseName)){
			xls = null;
			return new Object[1][0];
		}
		
		int rows = xls.getRowCount(testCaseName);
		int cols = xls.getColumnCount(testCaseName);
		/*System.out.println("rows are --"+rows);
		System.out.println("cols are --"+cols);*/
		
		Object[][] data = new Object[rows -1][cols -3];
		
		for(int rowNum=2; rowNum<rows; rowNum++){
			for(int colNum=0; colNum<cols; colNum++){
			
				//System.out.print(xls.getCellData(testCaseName, colNum, rowNum)+"--");
				
				data[rowNum-2][colNum]=xls.getCellData(testCaseName, colNum, rowNum);
			}
			System.out.println();
			
		}
		
		xls = null;
		return data;
	}
	

}
