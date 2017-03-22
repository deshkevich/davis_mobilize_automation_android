package utility;

import jxl.Sheet;

public class ReadUserData extends Thread{

	private Sheet sh;
	public ExcelUtils eu = new ExcelUtils();
	public String sUserName ,sPassword, Firstname, emailid,search,changeViewName,invalidEmail,existingEmail,davisRoofId,davisroofPwd;
	
	public void run() {

		try {

			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"UserData");
			System.out.println("sheett :"+ sh);
			sUserName = eu.getCellData(sh,1,1);
			sPassword = eu.getCellData(sh,1,2);
			Firstname = eu.getCellData(sh, 13, 1);
			emailid = eu.getCellData(sh, 13, 2);
			search=eu.getCellData(sh, 12, 1);
			changeViewName=eu.getCellData(sh, 13, 1);
			invalidEmail=eu.getCellData(sh, 13, 3);
			existingEmail=eu.getCellData(sh, 11, 2);
			davisRoofId=eu.getCellData(sh, 4, 1);
			davisroofPwd=eu.getCellData(sh, 4, 2);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
