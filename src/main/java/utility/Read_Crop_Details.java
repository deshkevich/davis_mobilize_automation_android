package utility;

import jxl.Sheet;

public class Read_Crop_Details extends Thread {

	private Sheet sh;
	private ExcelUtils eu ;
	public String lower_threshold, upper_threshold, chilling_threshold,crop,variety,gddtarget,lowerTempThreshold,UpperTemp;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Crop_Details");

			lower_threshold = eu.getCellData(sh, 1, 0);
			System.out.println("lower_threshold"+lower_threshold);

			upper_threshold = eu.getCellData(sh, 1, 1);
			System.out.println("upper_threshold "+upper_threshold);

			chilling_threshold = eu.getCellData(sh, 1, 2);
			System.out.println("chilling_threshold"+chilling_threshold);
			crop=eu.getCellData(sh, 1, 3);
			variety=eu.getCellData(sh, 1, 4);
			gddtarget=eu.getCellData(sh,1,5);
			lowerTempThreshold=eu.getCellData(sh,1,6);
			UpperTemp=eu.getCellData(sh,1,7);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}