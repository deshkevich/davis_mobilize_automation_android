package utility;
import jxl.Sheet;

public class Read_Frost_Data extends Thread{

		private Sheet sh;
		private ExcelUtils eu ;
		public String titleText,titleTextTwo,titleTextThree,titleTextFour,titleTextFive,ButtonText,ButtonTextTwo,ButtonTextThree,ButtonTextFour;

		public void run(){

			try {
				eu = new ExcelUtils();
				sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"FrostPage_Data");

				titleText = eu.getCellData(sh, 0, 1);
				System.out.println("Title"+titleText);

				titleTextTwo= eu.getCellData(sh, 0, 2);
				System.out.println("titleTextTwo"+titleTextTwo);
				
				titleTextThree= eu.getCellData(sh, 0, 3);
				System.out.println("titleTextThree"+titleTextThree);
				
				titleTextFour= eu.getCellData(sh, 0, 4);
				System.out.println("titleTextFour"+titleTextFour);
				
				titleTextFive= eu.getCellData(sh, 0, 5);
				System.out.println("titleTextFive"+titleTextFive);
				
				ButtonText = eu.getCellData(sh,1,1);
				System.out.println("ButtonText"+ButtonText);
					
				ButtonTextTwo= eu.getCellData(sh,1,2);
				System.out.println("ButtonTextTwo"+ButtonTextTwo);

				ButtonTextThree= eu.getCellData(sh,1,3);
				System.out.println("ButtonTextThree"+ButtonTextThree);
				
				ButtonTextFour= eu.getCellData(sh,1,4);
				System.out.println("ButtonTextFour"+ButtonTextFour);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}



