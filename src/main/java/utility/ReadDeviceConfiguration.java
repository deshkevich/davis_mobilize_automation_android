package utility;

import jxl.Sheet;

import java.io.IOException;


public class ReadDeviceConfiguration extends Thread{

	public static String PlatformName, platformVersion, DeviceName, packagename, UDID, Applicationpath,AppPathh,BundleId;
	private Sheet sh;
	public ExcelUtils eu = new ExcelUtils();

	public void run() {

		try {
			int row = Integer.parseInt(System.getProperty("Device","1"));
			sh =  eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Device_configuration");
			AppPathh=eu.getCellData(sh,row,4);
			PlatformName = eu.getCellData(sh,row,0);
			platformVersion = eu.getCellData(sh,row,1);
			DeviceName = eu.getCellData(sh,1,2);
			//Applicationpath = eu.getCellData(sh,1,4)	;
			packagename = eu.getCellData(sh, row, 3);
			BundleId=eu.getCellData(sh, row, 3);
			//System.out.println(Applicationpath);
			//UDID = eu.getCellData(sh,1, 5);

			//	lmwidth = Integer.parseInt(eu.getCellData(sh,1,2));

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
