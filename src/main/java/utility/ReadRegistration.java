package utility;

import jxl.Sheet;

import java.io.IOException;

public class ReadRegistration extends Thread{
	
	public String emailid =null;
	private Sheet sh;
	public ExcelUtils eu = new ExcelUtils();
	
	public void run() {

		try {
			System.out.print("in ReadRegistration");
			sh =  eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Registration");
			emailid = eu.getCellData(sh,1,1);
		//	lmwidth = Integer.parseInt(eu.getCellData(sh,1,2));
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
