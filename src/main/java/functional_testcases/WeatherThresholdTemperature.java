package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.*;

import java.util.List;

public class WeatherThresholdTemperature {
	
	private Read_Crop_Details readCropDetails;
	private AndroidDriver driver;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private WeatherPage weatherPage;
	private Read_FrostPageThresholdValues readfrost;
	private Read_CropPageThresholdValues readCrop;
	private Account_Page accountPage;
	private ReadWeatherThresholdValues weatherpagevalues;
    private Alert_Page alertpage;
	@SuppressWarnings({ })
	@Test
	public void verifyThresholdIrrigationTemp() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		new CropPage(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		frostPage = new FrostPage(driver);
		readFrostData = new Read_Frost_Data();
		readFrostData.start();
		weatherPage = new WeatherPage(driver);
		readfrost = new Read_FrostPageThresholdValues();
		readfrost.start();
		readCropDetails = new Read_Crop_Details();
		readCropDetails.start();
		readCrop = new Read_CropPageThresholdValues();
		readCrop.start();
		accountPage=new Account_Page(driver);
		weatherpagevalues =new ReadWeatherThresholdValues();
		weatherpagevalues.start();
		alertpage =new Alert_Page(driver);
		Thread.sleep(1000);
		try {
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
			
			// Click on Account button
			if (homepage.getAccountbtn().isDisplayed()) {
				ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				homepage.getAccountbtn().click();
				Thread.sleep(3000);

			} else {
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			           Thread.sleep(2000);   
			           
			        // Verifying tutorial icon
						Thread.sleep(2000);
						Precondition.tutorialDisalogBox();
						
						
					// Click on preferences
			         MobileElement preferences=accountPage.getpreferecnes();
						// String textOne=preferences.getText();
						if (preferences.isDisplayed()) {
							ATUReports.add("Preferences is Displayed and Clicked on prefrences", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(2000);
							preferences.click();
							Thread.sleep(3000);

						} else {
							ATUReports.add("preferences tab is not Displayed ", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						// Verify user selected units from preferences.
						Thread.sleep(3000);
						//---------Verify preferences lists-------
						MobileElement list = frostPage.getpreferencesList();
						if (list.isDisplayed()) {
							ATUReports.add("Users preferences list is displayed", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							

							// Verify temperature
							MobileElement temperature = frostPage.gettempList();

							String expectedTempTxt = temperature.getText();
							if (temperature != null && temperature.isDisplayed()) {
								ATUReports.add("Users preferences Temperature list is displayed", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								
								//First tap on the screen and swipe it from bottom to top.(temperature)
								if(homepage.getprefrencesFirstList().isDisplayed()){
								WebElement prefernceslistElement =homepage.getprefrencesFirstList();
							    int xInitialprefernceslistElement = prefernceslistElement.getLocation().getX() + prefernceslistElement.getSize().getWidth()/2;
								int yInitialprefernceslistElement = prefernceslistElement.getLocation().getY() + prefernceslistElement.getSize().getHeight()/2;
								System.out.println("=startx "+xInitialprefernceslistElement+" "+ yInitialprefernceslistElement+"=end y  scroll down to  up the page");
							   //driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-1000, 5000);//nexus-1000//1080 s4wht//1100 in blk s4//motola -1250
							   //driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-300, 5000);
								ATUReports.add("Scroll down to up the preferences  list", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
								
								if(yInitialprefernceslistElement>1700){
									driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-1600, 5000);
									System.out.println("--1st loop--in 1st---");
								}else{
									if(yInitialprefernceslistElement>1200){
										driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-1100, 5000);
										System.out.println("--2ndloop--in 1st--");
									}else{
										if(yInitialprefernceslistElement<1000){
											driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-600, 5000);	
											System.out.println("--3dr loop--in 1st--");
										}else{
											if(yInitialprefernceslistElement>1000){
												driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-1030, 5000);
												System.out.println("--4th loop--in 1st--");
										}
									}
								}
									
								
								}
								
								}else{
									ATUReports.add("Preferences list is not displayed", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							
											
								// Verify 'F'
								MobileElement fText = frostPage.getfrostFText();
								MobileElement fRadiobtn = frostPage.getfrostRadioButton();
								String expectedFtxt = fText.getText();
								System.out.println(expectedFtxt + "expectedFtxt");

								// Verify 'C'
								MobileElement cText = frostPage.gettempCText();
								String cUnitsActualText=cText.getText();
								MobileElement cRadiobtn = frostPage.gettempCRadioButton();
								Thread.sleep(3000);
							
								//-------*Verify Rain rate units*-----
								MobileElement rainUnitsList = frostPage.getrainEtUnits();
								String unitsText=rainUnitsList.getText();
								if(rainUnitsList!=null && rainUnitsList.isDisplayed()){
									ATUReports.add(unitsText+"  Units list is displayed", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									//Verify inches
									MobileElement inchesText = frostPage.getinchesText();
									String inchesRainText=inchesText.getText();
									System.out.println(inchesRainText+"------inchesRainText");
									
									//Verify mm
									MobileElement mmText = frostPage.getmmText();
									String mmRainText=mmText.getText();
									System.out.println(mmRainText+"------mmRainText");
									
									
									//nexus---1014//S6--1424,One plus 1-1087,Moto e2-508,note-3-1087,s5-1086,moto g-677
									WebElement prefernceslistElement =homepage.getprefrencesFirstList();
									int xInitial3rdswipelistElement = prefernceslistElement.getLocation().getX() + prefernceslistElement.getSize().getWidth()/2;
									int yInitial3rdswiplistElement = prefernceslistElement.getLocation().getY() + prefernceslistElement.getSize().getHeight()/2;
									System.out.println("=startx "+xInitial3rdswipelistElement+" "+ yInitial3rdswiplistElement+"=end y  scroll down to  up the page---2");
									//driver.swipe(xInitial3rdswipelistElement, yInitial3rdswiplistElement, xInitial3rdswipelistElement, yInitial3rdswiplistElement-800, 5000);	//Fine in nexus,one plus,S5 "-not in s6,moto E2,note 3-little bit in note 3"
								
									
									Thread.sleep(2000);
									if(yInitial3rdswiplistElement>1400){
										driver.swipe(xInitial3rdswipelistElement, yInitial3rdswiplistElement, xInitial3rdswipelistElement, yInitial3rdswiplistElement-1350, 7000);
										System.out.println("--1st loop--in 2nd------");
										
									}else{
										Thread.sleep(2000);
										if(yInitial3rdswiplistElement<1020){
											driver.swipe(xInitial3rdswipelistElement, yInitial3rdswiplistElement, xInitial3rdswipelistElement, yInitial3rdswiplistElement-900, 7000);//nexus	
											System.out.println("--2 loop--in 2nd----");
										
										}else{
											Thread.sleep(2000);

											if(yInitial3rdswiplistElement>1000){
												driver.swipe(xInitial3rdswipelistElement, yInitial3rdswiplistElement, xInitial3rdswipelistElement, yInitial3rdswiplistElement-1070, 9000);//1050 for 1+,s5,moto e,
												System.out.println("--3 loop--in 2nd-----");
												Thread.sleep(9000);
											}else{
												Thread.sleep(2000);
												if(yInitial3rdswiplistElement<1000){
													driver.swipe(xInitial3rdswipelistElement, yInitial3rdswiplistElement, xInitial3rdswipelistElement, yInitial3rdswiplistElement-500, 7000);	
													
													System.out.println("--4th loop--in 2nd----");
													
												}	
											}
											
										}
									}
									Thread.sleep(2000);
								
																
								//---------Verify windSpeed-----	
								MobileElement windSpeedUnits = frostPage.getwindSpeedUnits();
								String windSpeedText=windSpeedUnits.getText();
								System.out.println(windSpeedText+"------windSpeedText--------");
								if(windSpeedUnits!=null && windSpeedUnits.isDisplayed()){
								ATUReports.add(windSpeedText+" Units list is displayed", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
								
								//Verify mph in preferences
								MobileElement mphText = frostPage.getmphText();
								String mphSpeedText=mphText.getText();
								System.out.println(mphSpeedText+"------mphSpeedText------");
								Thread.sleep(2000);
								
								//Verify knots in preferences
								MobileElement knotsText = frostPage.getknotsText();
								String knotsSpeedText=knotsText.getText();
								System.out.println(knotsSpeedText+"-----knotsSpeedText------");
								Thread.sleep(5000);
								
								// Clicked on home button
								homepage.getHomebutton().click();
								Thread.sleep(4000);
								
								// Verify the Add button is displayed in the Home screen
								MobileElement addButton = homepage.getAddbtn();

								// Verify Tap on + tab at bottom bar
								if (addButton != null) {
									if (addButton.isDisplayed()) {
										ATUReports.add("Mobilize Add symbol is displayed ", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										addButton.click();
										Thread.sleep(3000);
										

									} else {

										ATUReports.add("Mobilize Add symbol is not displayed", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.close();
										return;
									}

								} else {
									ATUReports.add("Add symbol is not displayed in the screen", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}

								// Enter View name
								MobileElement viewName = newscreenpage.getView_txtfld();
								if (viewName != null) {
									if (viewName.isDisplayed()) {
										ATUReports.add("Mobilize Name is entered in view name text box ", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										viewName.sendKeys(readUserData.search);
										Thread.sleep(3000);
										
									} else {

										ATUReports.add("Mobilize Enter View name text box is  not displayed", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.close();
										return;
									}
								} else {
									ATUReports.add("View name text box is not displayed in the screen", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}

								// Verify Tap on Add button
								MobileElement nextAddButton = newscreenpage.getAddbtn();
								if (nextAddButton != null) {
									if (nextAddButton.isDisplayed()) {
										ATUReports.add("Mobilize Add button  is displayed & clicked on Add button,view is created in the current screen after click on Add button", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										nextAddButton.click();
										Thread.sleep(2000);									
									} else {

										ATUReports.add("Mobilize Add button element is  not displayed", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));									
									}
								} else {

									ATUReports.add("Add button is not displayed in the screen", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
									return;

								}
								
							
								// Verifying tutorial icon
								Thread.sleep(2000);
								Precondition.tutorialDisalogBox();
								
								
								// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
								Thread.sleep(1000);
								List <WebElement> weatherTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));		
								System.out.println(weatherTitle.size()+"----size----");	
								for(int i=0;i<=weatherTitle.size();i++){
									String weatherTitleText =weatherTitle.get(i).getText();
									System.out.println(weatherTitleText + "---accessabilityid---");							
									if (weatherTitleText.contains("WEATHER")) {
										ATUReports.add("Mobilize " + weatherTitleText + "  tab is displayed.", "WEATHER", weatherTitleText,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										weatherTitle.get(i).click();										
										Thread.sleep(2000);
										ATUReports.add("Mobilize WEATHER tab is clicked", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										break;
									} else {
										ATUReports.add("Mobilize Report title " + weatherTitleText + " tab is not displayed", "WEATHER",
												weatherTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																
									}
									
								}
											
								// Verify the title text
								String title = weatherPage.getTitletxt().getText();
								if (title.isEmpty()) {
									ATUReports.add("Verify the Weather Sensor Input text  in the screen ", "Weather Sensor Input",
											title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (title.equals("Weather Sensor Input")) {
										ATUReports.add("WEATHER SENSOR INPUT text is noticed in the screen ", "Weather Sensor Input",
												title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("WEATHER SENSOR INPUT is not observed in the screen ", title, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
								
								
								// Select any option from device drop down -
								//weatherPage.getStationtxt().click();
								Thread.sleep(2000);
								weatherPage.getStationdropdown().click();
								Thread.sleep(2000);
								ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								//Thread.sleep(2000);

								// Select any option from sensor drop down		
								//weatherPage.getSensortxt().click();
								Thread.sleep(2000);
								weatherPage.getSensordropdown().click();
								Thread.sleep(2000);
								ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								//Thread.sleep(3000);

								// Click on next button in the Weather Sensor Input
								if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
									weatherPage.getNext_nxt_save_btnn().click();
									ATUReports.add("Next button is enabled in the WEATHER SENSOR INPUT and clicked on the Next button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(3000);
									
								} else {
									ATUReports.add("Skip button is not enabled in the WEATHER SENSOR INPUT", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}
								
				
								// Verifying tutorial icon
								Thread.sleep(2000);
								Precondition.tutorialDisalogBox();

								
								//--------------************" VERIFY MINUTE AVERAGE ALERT &  HIGH WIND ALERT IN"  MPH  " UNITS ----------------
								//get the value of the optional and click on it
								Thread.sleep(4000);
								if(weatherPage.getavrgeOptional().isDisplayed()){			
									ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
									Thread.sleep(4000);
											WebElement optionalElement =weatherPage.getavrgeOptional();
									int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
									int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;						
									if(xInitialOptional<1200){  
										driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
										System.out.println("in 1st loop optional");
									}else{				
											if(xInitialOptional>1200){
											driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
												System.out.println("in 2nd loop optional");
											}
									}									
								Thread.sleep(2000);
								}else{
									ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								
								// Verify weather title text.
								String weather_sensor_title = weatherPage.getminuteTitle().getText();
								if (weather_sensor_title.isEmpty()) {
									ATUReports.add("Verify the 10 MINUTE AVERAGE WIND ALERT text  in the screen ",
											"10 MINUTE AVERAGE WIND ALERT", weather_sensor_title, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (weather_sensor_title.contains("10-Minute Average")) {
										ATUReports.add("10 MINUTE AVERAGEis noticed in the screen ", "10-Minute Average Wind Alert",
												weather_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("10 MINUTE AVERAGE is not observed in the screen ", weather_sensor_title,
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									if (weather_sensor_title.contains("Wind Alert")) {
										ATUReports.add("Wind Alert is noticed in the screen ", "Wind AlertT", weather_sensor_title,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("WIND ALERT is not noticed in the screen", weather_sensor_title,
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
								Thread.sleep(6000);
								
								
								
								
							
								// Verify the wind speed units text	
								String actualWinSpeedUnits =weatherPage.getMph().getText();
								//String actualWindSpeedKontUnits=weatherPage.getknot().getText();
								System.out.println(actualWinSpeedUnits + "---actualTemperatureUnits");
								System.out.println(mphSpeedText + "----mphSpeedText");
								if (actualWinSpeedUnits.isEmpty()) {
									ATUReports.add("actualWinSpeedUnits element is not visible", null, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {						
								if(actualWinSpeedUnits.contains(mphSpeedText)){
										ATUReports.add("actualWinSpeedUnits text is noticed in the screen  same as expected ",
												actualWinSpeedUnits, mphSpeedText, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
										
										//Verify tap on temperature text box
										// Verify Tap on Temperature value box.

										MobileElement temparatureBox = weatherPage.getThresholdtxtfld();
										String textDefaultText = temparatureBox.getText();
										System.out.println(textDefaultText + "---textDefaultText---");

										if (temparatureBox != null && temparatureBox.isDisplayed()) {

											ATUReports.add(
													"Mobilize temperature value text box is displayed, and its default value is - "
															+ textDefaultText,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// Verify to enter min(value) range in
											// text box
											temparatureBox.click();
											
						
											// Verify to enter min(value) range in text box
											temparatureBox.click();
											System.out.println("Clear the field");
											weatherPage.getThresholdtxtfld().sendKeys(Keys.DELETE);
											weatherPage.getThresholdtxtfld().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											//weatherPage.getThresholdtxtfld().sendKeys("1");weather page values
											weatherPage.getThresholdtxtfld().sendKeys(weatherpagevalues.MinWindMin_Mph);
											System.out.println("enter 1 value");
											System.out.println(temparatureBox.getText() + "---textminimum value---");
											ATUReports.add("Entered minimum value", temparatureBox.getText(), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											driver.hideKeyboard();

											// Verify Observe Next button is Enabled.
											nextButtonEnabled();
												
											// Verify to enter out of range values in text
											// box
											temparatureBox.click();
											System.out.println("Clear the field");
											weatherPage.getThresholdtxtfld().sendKeys(Keys.DELETE);
											weatherPage.getThresholdtxtfld().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											weatherPage.getThresholdtxtfld().sendKeys(weatherpagevalues.MinWindOutOfRange_Mph);
											System.out.println(temparatureBox.getText() + "---text ot of value---");
											ATUReports.add("Entered Out of range value ", temparatureBox.getText(), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											// driver.hideKeyboard();

											// Verify Observe Next button is Enabled.
											String weather_thresholdTitle = weatherPage.getminuteTitle().getText();
											if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
												ATUReports.add("Next button is enabled in the " + weather_thresholdTitle,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Next button is not enabled in the  " + weather_thresholdTitle,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											Thread.sleep(2000);
											
											
											// Verify to enter max(value) range in textbox
											// it contains zero by default
											temparatureBox.click();
											System.out.println("Clear the field");
											weatherPage.getThresholdtxtfld().sendKeys(Keys.DELETE);
											weatherPage.getThresholdtxtfld().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											//weatherPage.getThresholdtxtfld().sendKeys("50");wetherpagevalues
											weatherPage.getThresholdtxtfld().sendKeys(weatherpagevalues.MinWindMin_Max_Mph);
											System.out.println(temparatureBox.getText() + "---text maxm  value---");
											ATUReports.add("Entered maximum value", temparatureBox.getText(), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											// driver.hideKeyboard();
											Thread.sleep(1000);
											
											

											// Verify Observe Next button is Enabled.
											
											if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
												weatherPage.getNext_nxt_save_btnn().click();
												ATUReports.add("Next button is enabled in the " + weather_sensor_title,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Next button is not enabled in the  " + weather_sensor_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											Thread.sleep(2000);
											
										}else{
											ATUReports.add("temperature value text box  is not observed in the screen ",
													actualWinSpeedUnits, mphSpeedText, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											driver.close();
										}
										
										
										
										
										
										//-------Verify--------High wind alert page-------
										//get the value of the optional and click on it
										Thread.sleep(4000);
										if(weatherPage.gethighwndAlertOptional().isDisplayed()){			
											ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
											Thread.sleep(4000);
										    WebElement optionalElement= weatherPage.gethighwndAlertOptional();
											int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
											int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
											//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
											//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
											if(xInitialOptional<1200){  
												driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
												//System.out.println("in 1st loop optional");
											}else{				
													if(xInitialOptional>1200){
													driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
														//System.out.println("in 2nd loop optional");
													}
											}
										Thread.sleep(2000);
										}else{
											ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										
										// Verify weather title text.
										String highwindalert_title = weatherPage.getwingAlertTitle().getText();
										if (highwindalert_title.isEmpty()) {
											ATUReports.add("Verify the HIGH WIND ALERT text  in the screen ", "High Wind Alert",
													highwindalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (highwindalert_title.equalsIgnoreCase("High Wind Alert")) {
												ATUReports.add("High Wind Alert is noticed in the screen ", "High Wind Alert",
														highwindalert_title, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("HIGH WIND ALERT is not observed in the screen ", highwindalert_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}
										
										
							
										
										//Verify text box units text
										if(actualWinSpeedUnits.contains(mphSpeedText)){
											ATUReports.add("high wind alertUnits text is noticed in the screen  same as expected ",
													actualWinSpeedUnits, mphSpeedText, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
											
											//Verify tap on temperature text box
											// Verify Tap on Temperature value box.

											MobileElement highWindTextBox= weatherPage.gethighWindAlertTextBox();
											String textBoxDefaultText = highWindTextBox.getText();
											System.out.println(textBoxDefaultText + "---textBoxDefaultText---");

											if (highWindTextBox != null && highWindTextBox.isDisplayed()) {

												ATUReports.add(
														"Mobilize high wind alert  text box is displayed, and its default value is - "
																+ textDefaultText,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											
											 
											         // Verify to enter out of range values in text
													// box											
												    weatherPage.gethighWindAlertTextBox().click();
												    weatherPage.gethighWindAlertTextBox().sendKeys(Keys.DELETE);
												    weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
													Thread.sleep(1000);
													//weatherPage.gethighWindAlertTextBox().sendKeys("101");weatherpagevalues
													weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_ot_range_mph);
													System.out.println(weatherPage.gethighWindAlertTextBox().getText() + "---text ot of value---");
													ATUReports.add("Entered Out of range value ", weatherPage.gethighWindAlertTextBox().getText(), LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													driver.hideKeyboard();

													
													// Verify Observe Next button is Enabled.
													if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
														ATUReports.add("Next button is enabled in the " + highwindalert_title,
																LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("Next button is not enabled in the  " + highwindalert_title,
																LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
													//Thread.sleep(3000);
													
													
												
												// Verify to enter min(value) range in text box
											    weatherPage.gethighWindAlertTextBox().click();
												weatherPage.gethighWindAlertTextBox().sendKeys(Keys.DELETE);
												weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
												System.out.println("Clear the field");
												Thread.sleep(2000);
												//weatherPage.gethighWindAlertTextBox().sendKeys("1");weatherpagevalues
												weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_min_mph);
												System.out.println("enter 1 value");
												System.out.println(weatherPage.gethighWindAlertTextBox().getText() + "---textminimum value---");
												ATUReports.add("Entered minimum value", weatherPage.gethighWindAlertTextBox().getText(), LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												//driver.hideKeyboard();

												// Verify Observe Next button is Enabled.		
												System.out.println(highwindalert_title+"-----weather_thresholdTitle-----");
												if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
													ATUReports.add("Next button is enabled in the " + highwindalert_title, LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												} else {
													ATUReports.add("Next button is not enabled in the " + highwindalert_title, LogAs.FAILED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
												Thread.sleep(2000);
											
												
											
												
												// Verify to enter max(value) range in text box
												// it contains zero by default
												weatherPage.gethighWindAlertTextBox().click();
												weatherPage.gethighWindAlertTextBox().sendKeys(Keys.DELETE);
												weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
												System.out.println("Clear the field");
												Thread.sleep(2000);
												//weatherPage.gethighWindAlertTextBox().sendKeys("100");weatherpagevalues
												weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_max_mph);
												System.out.println(weatherPage.gethighWindAlertTextBox().getText() + "---text maxm  value---");
												ATUReports.add("Entered maximum value", weatherPage.gethighWindAlertTextBox().getText(), LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												// driver.hideKeyboard();
												Thread.sleep(1000);
												

												// Verify Observe Next button is Enabled.
												if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
													weatherPage.getNext_nxt_save_btnn().click();
													ATUReports.add("Next button is enabled in the " + highwindalert_title,
															LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												} else {
													ATUReports.add("Next button is not enabled in the  " + highwindalert_title,
															LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
												Thread.sleep(2000);					
										
											}else{
												ATUReports.add("High wind alert temperature value text box  is not observed in the screen ",
														actualWinSpeedUnits, mphSpeedText, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												driver.close();
											}
										
										}else{
											ATUReports.add("high wind alertUnits text is noticed in the screen  not same as expected ",
													actualWinSpeedUnits, mphSpeedText, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
										}
										
										

							}else{
								
								//--------------************" VERIFY MINUTE AVERAGE ALERT &  HIGH WIND ALERT IN"  KNOTS  " UNITS ----------------
									//------------Verify--------knots units-------	
								String knotsUnits=weatherPage.getMph().getText();
								System.out.println(knotsSpeedText+"-------knotsSpeedText---");
								if(knotsUnits.contains(knotsSpeedText)){
									ATUReports.add("actualWinSpeedUnits text is noticed in the screen  same as expected ",
											knotsUnits, knotsSpeedText, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									
									//Verify tap on temperature text box
									// Verify Tap on Temperature value box.

									MobileElement temparatureBox = weatherPage.getThresholdtxtfld();
									String textDefaultText = temparatureBox.getText();
									System.out.println(textDefaultText + "---textDefaultText---");

									if (temparatureBox != null && temparatureBox.isDisplayed()) {

										ATUReports.add(
												"Mobilize temperature value text box is displayed, and its default value is - "
														+ textDefaultText,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify to enter min(value) range in
										// text box
										temparatureBox.click();
															
										// Verify to enter min(value) range in text box
										temparatureBox.click();
										System.out.println("Clear the field");
										weatherPage.getThresholdtxtfld().sendKeys(Keys.DELETE);
										weatherPage.getThresholdtxtfld().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										//weatherPage.getThresholdtxtfld().sendKeys("1");weatherpagevalues
										weatherPage.getThresholdtxtfld().sendKeys(weatherpagevalues.MinWindMin_Knots);
										Thread.sleep(1000);
										System.out.println("enter 1 value");
										System.out.println(temparatureBox.getText() + "---textminimum value---");
										ATUReports.add("Entered minimum value", temparatureBox.getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.hideKeyboard();

										// Verify Observe Next button is Enabled.
										nextButtonEnabled();
										
										
										// Verify to enter out of range values in text
										// box
										Thread.sleep(1000);
										weatherPage.getThresholdtxtfld().sendKeys(Keys.DELETE);
										weatherPage.getThresholdtxtfld().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										
									    //weatherPage.getThresholdtxtfld().sendKeys("44");weatherpagevalue
										weatherPage.getThresholdtxtfld().sendKeys(weatherpagevalues.MinWindMinOutOfRange_Knots);
										Thread.sleep(1000);
										System.out.println(temparatureBox.getText() + "---text ot of value---");
										ATUReports.add("Entered Out of range value ", temparatureBox.getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										// driver.hideKeyboard();

										// Verify Observe Next button is Enabled.
										if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
											ATUReports.add("Next button is enabled in the " + weather_sensor_title,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Next button is not enabled in the  " + weather_sensor_title,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);
										
										
										// Verify to enter max(value) range in textbox
										// it contains zero by default
										weatherPage.getThresholdtxtfld().clear();
										Thread.sleep(2000);
										weatherPage.getThresholdtxtfld().sendKeys(weatherpagevalues.MinWindMin_Max_Knots);
										System.out.println(temparatureBox.getText() + "---text maxm  value---");
										ATUReports.add("Entered maximum value", temparatureBox.getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										Thread.sleep(1000);

										// Verify Observe Next button is Enabled.
										// clikcedOnNext
										String nextText=weatherPage.getNext_nxt_save_btnn().getText();
										if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
											weatherPage.getNext_nxt_save_btnn().click();
											ATUReports.add("Next button is enabled in the " + weather_sensor_title,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Next button is not enabled in the  " + weather_sensor_title,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);
										
									}else{
										ATUReports.add("temperature value text box  is not observed in the screen ",
												knotsUnits, knotsSpeedText, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.close();
									}
									
									
									
									//get the value of the optional and click on it
									Thread.sleep(4000);
									if(weatherPage.gethighwndAlertOptional().isDisplayed()){			
										ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
										Thread.sleep(4000);
									    WebElement optionalElement= weatherPage.gethighwndAlertOptional();
										int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
										int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
										//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
										//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
										if(xInitialOptional<1200){  
											driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
											System.out.println("in 1st loop optional");
										}else{				
												if(xInitialOptional>1200){
												driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
													System.out.println("in 2nd loop optional");
												}
										}
									Thread.sleep(2000);
									}else{
										ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									
									//-------Verify--------High wind alert page-------
									
									// Verify weather title text.
									String highwindalert_title = weatherPage.getwingAlertTitle().getText();
									if (highwindalert_title.isEmpty()) {
										ATUReports.add("Verify the HIGH WIND ALERT text  in the screen ", "High Wind Alert",
												highwindalert_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (highwindalert_title.equalsIgnoreCase("High Wind Alert")) {
											ATUReports.add("High Wind Alert is noticed in the screen ", "High Wind Alert",
													highwindalert_title, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("HIGH WIND ALERT is not observed in the screen ", highwindalert_title,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									
									
									// Verify Drag the slider to change the temperature
									//move the slider
									thresholdSlider();
									Thread.sleep(4000);
									
									
									//Verify text box units text
									if(knotsUnits.contains(knotsSpeedText)){
										ATUReports.add("high wind alertUnits text is noticed in the screen  same as expected ",
												knotsSpeedText, knotsUnits, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
																
										// Verify Tap on Temperature value box.
										MobileElement highWindTextBox= weatherPage.gethighWindAlertTextBox();
										String textBoxDefaultText = highWindTextBox.getText();
										System.out.println(textBoxDefaultText + "---textBoxDefaultText---");

										if (highWindTextBox != null && highWindTextBox.isDisplayed()) {

											ATUReports.add(
													"Mobilize high wind alert  text box is displayed, and its default value is - "
															+ textDefaultText,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											// Verify to enter min(value) range in
											// text box
											 weatherPage.gethighWindAlertTextBox().click();
											 		
											// Verify to enter min(value) range in text box
											    weatherPage.gethighWindAlertTextBox().click();
											    weatherPage.gethighWindAlertTextBox().sendKeys(Keys.DELETE);
											    weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
												Thread.sleep(2000);
												weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_min_knots);
												System.out.println(weatherPage.gethighWindAlertTextBox().getText() + "-----text manimum  value---");
												ATUReports.add("Entered minimum value", weatherPage.gethighWindAlertTextBox().getText(), LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												driver.hideKeyboard();
												Thread.sleep(1000);
											

											   // Verify Observe Next button is Enabled.
												String weather_thresholdTitle = weatherPage.getwingAlertTitle().getText();
												System.out.println(weather_thresholdTitle+"-----weather_thresholdTitle-----");
												if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
													
													ATUReports.add("Next button is enabled in the " + weather_thresholdTitle, LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												} else {
													ATUReports.add("Next button is not enabled in the " + weather_thresholdTitle, LogAs.FAILED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
												Thread.sleep(2000);
											
											
											// Verify to enter out of range values in text
											// box
											weatherPage.gethighWindAlertTextBox().click();
											Thread.sleep(1000);
											weatherPage.gethighWindAlertTextBox().sendKeys(Keys.DELETE);
											weatherPage.gethighWindAlertTextBox().sendKeys(Keys.INSERT);
											Thread.sleep(2000);
											weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_ot_range_knots);
											System.out.println(highWindTextBox.getText() + "---text out of value---");
											ATUReports.add("Entered Out of range value ", highWindTextBox.getText(), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
											// Verify Observe Next button is Enabled.
											
											if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
												ATUReports.add("Next button is enabled in the " + highwindalert_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Next button is not enabled in the  " + highwindalert_title,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											Thread.sleep(2000);
											
											
											// Verify to enter max(value) range in textbox
											// it contains zero by default
											weatherPage.gethighWindAlertTextBox().clear();
											Thread.sleep(2000);
											//weatherPage.gethighWindAlertTextBox().sendKeys("86");weatherpagevalues
											weatherPage.gethighWindAlertTextBox().sendKeys(weatherpagevalues.high_wind_max_knots);
											System.out.println(highWindTextBox.getText() + "---text maxm  value---");
											ATUReports.add("Entered maximum value", highWindTextBox.getText(), LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											// driver.hideKeyboard();
											Thread.sleep(1000);

											// Verify Observe Next button is Enabled.
											// clikcedOnNext();
											System.out.println(highwindalert_title+"---highwindalert_title-----");
											if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
												weatherPage.getNext_nxt_save_btnn().click();
												ATUReports.add("Next button is enabled in the " + highwindalert_title,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Next button is not enabled in the  " + highwindalert_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											Thread.sleep(2000);					
									
										}else{
											ATUReports.add("High wind alert temperature value text box  is not observed in the screen ",
													knotsSpeedText, knotsUnits, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											driver.close();
										}
									
									}else{
										ATUReports.add("high wind alertUnits text is noticed in the screen  not same as expected ",
												knotsSpeedText, knotsUnits, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
									}								
									}					
								}
								}
								

								//get the value of the optional and click on it
								Thread.sleep(4000);
								if(weatherPage.getdailyRainAlrtOptional().isDisplayed()){			
									ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
									Thread.sleep(4000);
								    WebElement optionalElement=weatherPage.getdailyRainAlrtOptional();
									int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
									int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
									//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
									//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
									if(xInitialOptional<1200){  
										driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
										//System.out.println("in 1st loop optional");
									}else{				
											if(xInitialOptional>1200){
											driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
												//System.out.println("in 2nd loop optional");
											}
									}
								Thread.sleep(2000);
								}else{
									ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								
								 
								//**************************VERIFY DAILY RAIN ALERT & HIGH RAIN RATE IN " INCHES  "UNITS.*********************
							
	                           //----------------*****************Verify daily rain units***********---------------------
								
								// Verify weather title text.
								String dailyrainalert_title = weatherPage.getdailyRainTitle().getText();
								if (dailyrainalert_title.isEmpty()) {
									ATUReports.add("Verify theDaily Rain Alert text  in the screen ", "Daily Rain Alert",
											dailyrainalert_title, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (dailyrainalert_title.equalsIgnoreCase("Daily Rain Alert")) {
										ATUReports.add("Daily Rain Alert is noticed in the screen ", "Daily Rain Alert",
												dailyrainalert_title, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("DAILY RAIN ALERT is not observed in the screen ",
												dailyrainalert_title, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
										
																		
										// -----------------Verify the rain units text---------------------
										String dailyRain = weatherPage.getInches().getText();
										System.out.println(dailyRain+"---daliyRain---highlyRain---in/hr actual----");
										System.out.println(inchesRainText+"-----inchesRainText----expected---inches----");
										if(dailyRain.isEmpty()){
											
										}else{
											if(dailyRain.contains(inchesRainText)){
												ATUReports.add("Daily rain alert Units text is noticed in the screen  same as expected ",
														dailyRain, inchesRainText, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																				
												// Verify Tap on Temperature value box.
												MobileElement dailyRainTextBox= weatherPage.getdailyRainAlertTextBox();
												String textBoxDefaultText = dailyRainTextBox.getText();
												System.out.println(textBoxDefaultText + "---textBoxDefaultText inhces box---");

												if (dailyRainTextBox != null && dailyRainTextBox.isDisplayed()) {

													ATUReports.add(
															"Mobilize Daily rain alert  text box is displayed, and its default value is - "
																	+ textBoxDefaultText,
															LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													  Thread.sleep(1000);

													 // Verify to enter min(value) range in
													  // text box
													  
													    //weatherPage.getdailyRainAlertTextBox().click();
													    Thread.sleep(1000);
													   //driver.sendKeyEvent(AndroidKeyCode.DEL);
													    WebElement dalyRainAlert=driver.findElementById("com.davis.mobilize:id/et_daily_rain_threshold");
													    dalyRainAlert.click();
													    Thread.sleep(1000);
													    System.out.println("Clicked on textbox");
													    dalyRainAlert.sendKeys(Keys.DELETE);   
													    dalyRainAlert.sendKeys(Keys.INSERT);
													    //dalyRainAlert.clear();
													    System.out.println("Deleted the code");
													    Thread.sleep(2000);
													   // dalyRainAlert.sendKeys("0.01");weatherpagevalues
													    dalyRainAlert.sendKeys(weatherpagevalues.daily_rain_min_inches);
													    System.out.println("Entered the value");
													    Thread.sleep(1000);
													
													    Thread.sleep(4000);
													    //weatherPage.getdailyRainAlertTextBox().sendKeys("0.01");						  
													    //Thread.sleep(2000);
														System.out.println(weatherPage.getdailyRainAlertTextBox().getText() + "-----text minimum  value---");
														ATUReports.add("Entered minimum value", weatherPage.getdailyRainAlertTextBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														driver.hideKeyboard();
														Thread.sleep(1000);
													
													   // Verify Observe Next button is Enabled.
														String weather_thresholdTitle = weatherPage.getdailyRainTitle().getText();
														System.out.println(weather_thresholdTitle+"-----weather_thresholdTitle-----");
														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {						
															ATUReports.add("Next button is enabled in the " + weather_thresholdTitle, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the " + weather_thresholdTitle, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);
													 
													 
													 
														// Verify to enter out of range values in text
														// box		
														 weatherPage.getdailyRainAlertTextBox().click();
														 Thread.sleep(1000);
														 weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
														 weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.INSERT);
														Thread.sleep(2000);
													    // weatherPage.getdailyRainAlertTextBox().sendKeys("6.00");weatherpagevalues
														 weatherPage.getdailyRainAlertTextBox().sendKeys(weatherpagevalues.daily_rain_ot_range_inches);
														Thread.sleep(1000);
														System.out.println(weatherPage.getdailyRainAlertTextBox().getText()+ "---text out of value---");
														ATUReports.add("Entered Out of range value ", weatherPage.getdailyRainAlertTextBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														//driver.hideKeyboard();

														
														// Verify Observe Next button is Enabled.			
														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
															ATUReports.add("Next button is enabled in the " + dailyrainalert_title,
																	LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the  " + dailyrainalert_title,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);
														
														
														// Verify to enter max(value) range in textbox
														// it contains zero by default
														String texThree=weatherPage.getdailyRainAlertTextBox().getText();
														weatherPage.getdailyRainAlertTextBox().click();
														Thread.sleep(1000);
														 weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
														 weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.INSERT);
														Thread.sleep(2000);
														//weatherPage.getdailyRainAlertTextBox().sendKeys("5.00");weatherpagevalues	
														weatherPage.getdailyRainAlertTextBox().sendKeys(weatherpagevalues.daily_rain_max_inches);
														Thread.sleep(1000);
														System.out.println(weatherPage.getdailyRainAlertTextBox().getText() + "---text maxm  value---");
														ATUReports.add("Entered maximum value", weatherPage.getdailyRainAlertTextBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														// driver.hideKeyboard();
														Thread.sleep(1000);
														

														// Verify Observe Next button is Enabled.
														// clikcedOnNext();
														System.out.println(dailyrainalert_title+"---dailyrainalert_title-----");
														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
															weatherPage.getNext_nxt_save_btnn().click();
															ATUReports.add("Next button is enabled in the " + dailyrainalert_title,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the  " + dailyrainalert_title,
																	LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);					
													 
													 
													 
													 
												}else{
													ATUReports.add("Rain value text box  is not observed in the screen ",
															inchesRainText,dailyRain, LogAs.FAILED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													driver.close();
												}
												
										
												
									//------------******Verify Hihgly rain alert********------------
												
												//get the value of the optional and click on it
												Thread.sleep(4000);
												if(weatherPage.gethighRainRateArtOptional().isDisplayed()){			
													ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
													Thread.sleep(4000);
												    WebElement optionalElement=weatherPage.gethighRainRateArtOptional();
													int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
													int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
													//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
													
													if(xInitialOptional<1200){  
														driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
														//System.out.println("in 1st loop optional");
													}else{				
															if(xInitialOptional>1200){
															driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
																//System.out.println("in 2nd loop optional");
															}
													}
												Thread.sleep(2000);
												}else{
													ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
												
												
												// Verify weather title text.
												String highrainalert_title = weatherPage.gethighRainTitle().getText();
												if (highrainalert_title.isEmpty()) {
													ATUReports.add("Verify the High Rain Rate Alert text  in the screen ",
															"High Rain Rate Alert", highrainalert_title, LogAs.WARNING,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												} else {
													if (highrainalert_title.equalsIgnoreCase("High Rain Rate Alert")) {
														ATUReports.add("High Rain Rate Alert is noticed in the screen ",
																"High Rain Rate Alert", highrainalert_title, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("High Rain Rate Alert is not observed in the screen ",
																highrainalert_title, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
												}
												
											
												//Verify high rain units
												String highRain= weatherPage.getHighmm().getText();
												System.out.println(highRain+"---highRainn---highlyRain---in/hr actual----");
												System.out.println(inchesRainText+"-----inchesRainText----expected---inches----");
												if(highRain.isEmpty()){
													
												}else{
													if(highRain.contains(inchesRainText)){
														ATUReports.add("High rain rate  alert Units text is noticed in the screen  same as expected ",
																highRain, inchesRainText, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														
														
														// Verify Tap on Temperature value box.

														MobileElement highRainTextBox= weatherPage.gethighRainTextBox();
														String textBoxDefaultTextHighRain= highRainTextBox.getText();
														System.out.println(textBoxDefaultTextHighRain + "---textBoxDefaultTextHighRain---");

														if (highRainTextBox != null && highRainTextBox.isDisplayed()) {

															ATUReports.add(
																	"Mobilize High rain rate  alert  text box is displayed, and its default value is - "
																			+ textBoxDefaultText,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															// Verify to enter min(value) range in
															// text box
															 weatherPage.gethighRainTextBox().click();
															 
															 
															    // Verify to enter min(value) range in
																 // text box
															         weatherPage.gethighRainTextBox().click();	
															         Thread.sleep(1000);
															          weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
															          weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
																	 Thread.sleep(2000);		
																	 weatherPage.gethighRainTextBox().sendKeys(weatherpagevalues.high_rain_inches_min);
																	 Thread.sleep(2000);
																	
																	 System.out.println( weatherPage.gethighRainTextBox().getText() + "-----text minimum  value---");
																	 ATUReports.add("Entered minimum value", weatherPage.gethighRainTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	 driver.hideKeyboard();
																	 Thread.sleep(1000);
																

																   // Verify Observe Next button is Enabled.
																	String weather_thresholdTitleHighRain= weatherPage.gethighRainTitle().getText();
																	System.out.println(weather_thresholdTitleHighRain+"-----weather_thresholdTitle-----");
																	if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																		
																		ATUReports.add("Next button is enabled in the " + weather_thresholdTitleHighRain, LogAs.PASSED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Next button is not enabled in the " + weather_thresholdTitleHighRain, LogAs.FAILED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																	Thread.sleep(2000);
																 
																 
																 
																	// Verify to enter out of range values in text
																	// box																	
																	weatherPage.gethighRainTextBox().click();
																	Thread.sleep(1000);
																	weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
															        weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
																	Thread.sleep(2000);			
																	//weatherPage.gethighRainTextBox().sendKeys("11.00");	weatherpagevalues
																	weatherPage.gethighRainTextBox().sendKeys(weatherpagevalues.high_rain_inches_ot_range);
																	Thread.sleep(1000);														
																	System.out.println( weatherPage.gethighRainTextBox().getText()+ "---text out of value---");
																	ATUReports.add("Entered Out of range value ", weatherPage.gethighRainTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	//driver.hideKeyboard();

																	// Verify Observe Next button is Enabled.
																	
																	if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																		ATUReports.add("Next button is enabled in the " + weather_thresholdTitleHighRain,
																				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Next button is not enabled in the  " + weather_thresholdTitleHighRain,
																				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																	Thread.sleep(2000);
																	
																	
																	// Verify to enter max(value) range in textbox
																	// it contains zero by default
																	// weatherPage.gethighRainTextBox().clear();
																	weatherPage.gethighRainTextBox().click();
																	Thread.sleep(1000);
																	weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
															        weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
															        Thread.sleep(2000);
															      //  weatherPage.gethighRainTextBox().sendKeys("10.0");weatherpagevalues
															        
															        weatherPage.gethighRainTextBox().sendKeys(weatherpagevalues.high_rain_max_inches);
															        Thread.sleep(1000);
																	System.out.println( weatherPage.gethighRainTextBox().getText() + "---text maxm  value---");
																	ATUReports.add("Entered maximum value",weatherPage.gethighRainTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	// driver.hideKeyboard();
																	

																	// Verify Observe Next button is Enabled.
																	// clikcedOnNext();
															       
																	System.out.println(weather_thresholdTitleHighRain+"---dailyrainalert_title-----");
																	if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																		weatherPage.getNext_nxt_save_btnn().click();
																		ATUReports.add("Next button is enabled in the " + weather_thresholdTitleHighRain,
																				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Next button is not enabled in the  " + weather_thresholdTitleHighRain,
																				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																	Thread.sleep(2000);				 
															 
														}else{
															ATUReports.add("Rain value text box  is not observed in the screen ",
																	inchesRainText,dailyRain, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															driver.close();
														}
															 
														}else{
															ATUReports.add("high Rain alert Units text is noticed in the screen  not same as expected ",
																	highRain, inchesRainText, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															
														}
												}
															 
												//-----------------------end of inhces-------			 
												
												
											}else{
												//--------------VERIFY DAILY RAIN ALERT & HIGH RAIN RATE IN " MM  "UNITS.----------------
												
												String dailyRainmmUnits= weatherPage.getInches().getText();
												System.out.println(dailyRain+"---daliyRain---highlyRain---in/hr actual----");
												System.out.println(mmRainText+"-----mmRainText----expected---inches----");
												if(dailyRain.isEmpty()){
													
												}else{
													if(dailyRain.contains(mmRainText)){
														ATUReports.add("Daily rain alert Units text is noticed in the screen  same as expected ",
																dailyRain, mmRainText, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														
														
													
														// Verify Tap on Temperature value box.

														MobileElement dailyRainTextBox= weatherPage.getdailyRainAlertTextBox();
														String textBoxDefaultText = dailyRainTextBox.getText();
														System.out.println(textBoxDefaultText + "---textBoxDefaultText---");

														if (dailyRainTextBox != null && dailyRainTextBox.isDisplayed()) {

															ATUReports.add(
																	"Mobilize Daily rain alert  text box is displayed, and its default value is - "
																			+ textBoxDefaultText,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															  
																
																
																// Verify to enter max(value) range in textbox
																// it contains zero by default
															    weatherPage.getdailyRainAlertTextBox().click();
																weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
																weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
																weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.INSERT);
																Thread.sleep(3000);
																//weatherPage.getdailyRainAlertTextBox().sendKeys("127.0");weatherpagevalues
																
																weatherPage.getdailyRainAlertTextBox().sendKeys(weatherpagevalues.daily_rain_max_mm_max);
																Thread.sleep(2000);
																System.out.println(weatherPage.getdailyRainAlertTextBox().getText() + "---text maxm  value---");
																ATUReports.add("Entered maximum value", weatherPage.getdailyRainAlertTextBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																// driver.hideKeyboard();
																Thread.sleep(1000);
															

															  // Verify Observe Next button is Enabled.
																//String weather_thresholdTitle = weatherPage.getdailyRainTitle().getText();
																System.out.println(dailyrainalert_title+"-----weather_thresholdTitle-----");
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	
																	ATUReports.add("Next button is enabled in the " + dailyrainalert_title, LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the " + dailyrainalert_title, LogAs.FAILED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);
															 
															 
															 
																// Verify to enter out of range values in text
																// box
																weatherPage.getdailyRainAlertTextBox().click();
																weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
																weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.DELETE);
																weatherPage.getdailyRainAlertTextBox().sendKeys(Keys.INSERT);
																Thread.sleep(2000);
																//weatherPage.getdailyRainAlertTextBox().sendKeys("128.0");weatherpagevalues
																weatherPage.getdailyRainAlertTextBox().sendKeys(weatherpagevalues.daily_rain_ot_range_mm);
																Thread.sleep(1000);
																System.out.println(weatherPage.getdailyRainAlertTextBox().getText()+ "---text out of value---");
																ATUReports.add("Entered Out of range value ", weatherPage.getdailyRainAlertTextBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																//driver.hideKeyboard();

																// Verify Observe Next button is Enabled.				
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	ATUReports.add("Next button is enabled in the " + dailyrainalert_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the  " + dailyrainalert_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);
																
																
																
																
																  // Verify to enter min(value) range in
																   // text box
															        MobileElement minimumValue=(MobileElement) driver.findElementById("com.davis.mobilize:id/et_daily_rain_threshold");
																    minimumValue.sendKeys(Keys.DELETE);
																    minimumValue.sendKeys(Keys.DELETE);
																    minimumValue.sendKeys(Keys.INSERT);
																	Thread.sleep(3000);
																//	minimumValue.sendKeys("0.254");weatherpagevalues
																	minimumValue.sendKeys(weatherpagevalues.daily_ran_min_mm);
																	Thread.sleep(2000);
																	System.out.println(weatherPage.getdailyRainAlertTextBox().getText() + "-----text manimum  value---");
																	ATUReports.add("Entered minimum value", weatherPage.getdailyRainAlertTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	driver.hideKeyboard();
																	Thread.sleep(1000);
																	
																	
																// Verify Observe Next button is Enabled.
																// clikcedOnNext();
																System.out.println(dailyrainalert_title+"---dailyrainalert_title-----");
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	weatherPage.getNext_nxt_save_btnn().click();
																	ATUReports.add("Next button is enabled in the " + dailyrainalert_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the  " + dailyrainalert_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);					
															 
															 
															 
															 
														}else{
															ATUReports.add("Rain value text box  is not observed in the screen ",
																	inchesRainText,dailyRain, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															driver.close();
														}
												
											}
										}
										
											
										
												
											
												
												
												//------------******Verify Highly rain alert********------------
												
												//get the value of the optional and click on it
												Thread.sleep(4000);
												if(weatherPage.gethighRainRateArtOptional().isDisplayed()){			
													ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
													Thread.sleep(4000);
												    WebElement optionalElement=weatherPage.gethighRainRateArtOptional();
													int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
													int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
													//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
													
													if(xInitialOptional<1200){  
														driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
														//System.out.println("in 1st loop optional");
													}else{				
															if(xInitialOptional>1200){
															driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
																//System.out.println("in 2nd loop optional");
															}
													}
												Thread.sleep(2000);
												}else{
													ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
												
												// Verify weather title text.
												String highrainalert_title = weatherPage.gethighRainTitle().getText();
												if (highrainalert_title.isEmpty()) {
													ATUReports.add("Verify the High Rain Rate Alert text  in the screen ",
															"High Rain Rate Alert", highrainalert_title, LogAs.WARNING,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												} else {
													if (highrainalert_title.equalsIgnoreCase("High Rain Rate Alert")) {
														ATUReports.add("High Rain Rate Alert is noticed in the screen ",
																"High Rain Rate Alert", highrainalert_title, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("High Rain Rate Alert is not observed in the screen ",
																highrainalert_title, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
												}
												
												
												/*//verify to move the slider
												driver.swipe(920, 475, 1030, 475, (int)1.3);
												ATUReports.add(
														"After Draging  the Optional slider,Optional slider is in Active Mode",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												Thread.sleep(2000);*/
												
												
												
												
												//Verify high rain units
												String highRain= weatherPage.getHighmm().getText();
												System.out.println(highRain+"---highRainn---highlyRain---in/hr actual----");
												System.out.println(mmRainText+"-----mmRainText----expected---inches----");
												if(highRain.isEmpty()){
													
												}else{
													if(highRain.contains(mmRainText)){
														ATUReports.add("High rain rate  alert Units text is noticed in the screen  same as expected ",
																highRain, mmRainText, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														
														
													
														// Verify Tap on Temperature value box.

														MobileElement highRainTextBox= weatherPage.gethighRainTextBox();
														String textBoxDefaultTextHighRainTwo= highRainTextBox.getText();
														System.out.println(textBoxDefaultTextHighRainTwo + "---textBoxDefaultTextHighRainTwo---");

														if (highRainTextBox != null && highRainTextBox.isDisplayed()) {

															ATUReports.add(
																	"Mobilize High rain rate  alert  text box is displayed, and its default value is - "
																			+ textBoxDefaultTextHighRainTwo,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															// Verify to enter min(value) range in
															// text box
															 weatherPage.gethighRainTextBox().click();
															 
															 
															// Verify to enter min(value) range in
																// text box
															        weatherPage.gethighRainTextBox().click();		 
															        weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
															        weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
																	Thread.sleep(2000);
																	//weatherPage.gethighRainTextBox().sendKeys("1");weatherpagevalues
																	weatherPage.gethighRainTextBox().sendKeys(weatherpagevalues.high_rain_mm_min);
																	Thread.sleep(1000);
																	System.out.println( weatherPage.gethighRainTextBox().getText() + "-----text manimum  value---");
																	ATUReports.add("Entered minimum value", weatherPage.gethighRainTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	driver.hideKeyboard();
																	Thread.sleep(1000);
																

																   // Verify Observe Next button is Enabled.
																	String weather_thresholdTitleHighRain= weatherPage.gethighRainTitle().getText();
																	System.out.println(weather_thresholdTitleHighRain+"-----weather_thresholdTitle-----");
																	if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																		
																		ATUReports.add("Next button is enabled in the " + weather_thresholdTitleHighRain, LogAs.PASSED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Next button is not enabled in the " + weather_thresholdTitleHighRain, LogAs.FAILED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																	Thread.sleep(2000);
																 
																 
																 
																	// Verify to enter out of range values in text
																	// box		
																	weatherPage.gethighRainTextBox().click();
																	weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
																	weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
																    weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
																	Thread.sleep(2000);
																	// weatherPage.gethighRainTextBox().sendKeys("255.0");weather page values
																	 weatherPage.gethighRainTextBox().sendKeys(weatherpagevalues.high_rain_mm_ot_range);
																	System.out.println( weatherPage.gethighRainTextBox().getText()+ "---text out of value---");
																	ATUReports.add("Entered Out of range value ", weatherPage.gethighRainTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	//driver.hideKeyboard();

																	// Verify Observe Next button is Enabled.			
																	if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																		ATUReports.add("Next button is enabled in the " + weather_thresholdTitleHighRain,
																				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Next button is not enabled in the  " + weather_thresholdTitleHighRain,
																				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																	Thread.sleep(2000);
																	
																	
																	// Verify to enter max(value) range in textbox
																	weatherPage.gethighRainTextBox().click();
																	weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
																	weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
																    weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
																	Thread.sleep(2000);
																//	 weatherPage.gethighRainTextBox().sendKeys("254.0");weatherpagevalues
																	 weatherPage.gethighRainTextBox().sendKeys(weatherpagevalues.high_range_max_mm);
																	System.out.println( weatherPage.gethighRainTextBox().getText() + "---text maxm  value---");
																	ATUReports.add("Entered maximum value",weatherPage.gethighRainTextBox().getText(), LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	// driver.hideKeyboard();
																	Thread.sleep(1000);

																	// Verify Observe Next button is Enabled.
																	System.out.println(weather_thresholdTitleHighRain+"---dailyrainalert_title-----");
																	if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																		weatherPage.getNext_nxt_save_btnn().click();
																		ATUReports.add("Next button is enabled in the " + weather_thresholdTitleHighRain,
																				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Next button is not enabled in the  " + weather_thresholdTitleHighRain,
																				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																	Thread.sleep(2000);				 
															 
														
														}else{
															ATUReports.add("Rain value text box  is not observed in the screen ",
																	inchesRainText,dailyRain, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															driver.close();
														}
															 
														}else{
															ATUReports.add("high Rain alert Units text is noticed in the screen  not same as expected ",
																	highRain, inchesRainText, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															
														}
												}	
												
												
												
											}
										}
										
									
										
										
										//-------------******* VERIFY  HIGH & LOW TEMPERATURE IN " F " UNITS *****---------------

										//get the value of the optional and click on it
										Thread.sleep(4000);
										if(weatherPage.gethighTemAlrtOptional().isDisplayed()){			
											ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
											Thread.sleep(4000);
										    WebElement optionalElement=weatherPage.gethighTemAlrtOptional();
											int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
											int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
											//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);

											if(xInitialOptional<1200){  
												driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
												//System.out.println("in 1st loop optional");
											}else{				
													if(xInitialOptional>1200){
													driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
														//System.out.println("in 2nd loop optional");
													}
											}
											Thread.sleep(2000);
										}else{
											ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										

										
										
										// Verify weather title text.
										String hightempAlert_title = weatherPage.gethighTempTilte().getText();

										if (hightempAlert_title.isEmpty()) {
											ATUReports.add("Verify the HIGH TEMPERATURE ALERT text  in the screen ",
													"HIGH TEMPERATURE ALERT", hightempAlert_title, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											
											if (hightempAlert_title.contains("High Temperature")) {
												ATUReports.add("High Temperature is noticed in the screen ",
														"High Temperature Alert", hightempAlert_title, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("HIGH TEMPERATURE ALERT is not observed in the screen ",
														hightempAlert_title, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											if (hightempAlert_title.contains("Alert")) {
												ATUReports.add("Alert is noticed in the screen ", "Alert",
														hightempAlert_title, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Alert is not observed in the screen ", hightempAlert_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											}
										}

										Thread.sleep(6000);
										
										
									/*	
										//verify to move the slider
										driver.swipe(920, 475, 1030, 475, (int)1.3);
										ATUReports.add(
												"After Draging  the Optional slider,Optional slider is in Active Mode",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										Thread.sleep(2000);
										*/
								
										// Verify temperature units from current page
										
										String actualTemperatureUnits =weatherPage.gethighTempFUnits().getText(); 
										System.out.println(actualTemperatureUnits + "---actualTemperatureUnits--f");
										System.out.println(expectedFtxt + "----expectedTempTxt----f");

										if (actualTemperatureUnits.isEmpty()) {
											ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											
											if (actualTemperatureUnits.contains(expectedFtxt)) {
												ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
														actualTemperatureUnits, expectedTempTxt, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												// Verify Tap on Temperature value box.

												MobileElement temparatureBox = weatherPage.gethighTemptxBox();
												String textDefaultText = temparatureBox.getText();
												System.out.println(textDefaultText + "---textDefaultText--high temp----- -");

												if (temparatureBox != null && temparatureBox.isDisplayed()) {

													ATUReports.add(
															"Mobilize temperature value text box is displayed, and its default value is - "
																	+ textDefaultText,
															LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													// Verify to enter min(value) range in text box
													temparatureBox.click();
													System.out.println("Clear the field");
													weatherPage.gethighTemptxBox().sendKeys(Keys.DELETE);
													weatherPage.gethighTemptxBox().sendKeys(Keys.INSERT);
													Thread.sleep(2000);
												//	weatherPage.gethighTemptxBox().sendKeys("0");weatherpagevalues
													weatherPage.gethighTemptxBox().sendKeys(weatherpagevalues.hightem_F_min);
													System.out.println("enter 0 value");

													System.out.println(weatherPage.gethighTemptxBox().getText() + "---textminimum value---");
													ATUReports.add("Entered minimum value", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													driver.hideKeyboard();

													// Verify Observe Next button is Enabled.
													//nextButtonEnabled();
													if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
														ATUReports.add("Next button is enabled in the " + hightempAlert_title, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("Next button is not enabled in the " + hightempAlert_title, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
													Thread.sleep(2000);
												
												

													// Verify to enter out of range values in text
													// box
													// it contains zero by default

													// weatherPage.getTemperatureBox().clear();
													Thread.sleep(1000);
													MobileElement highTempBx=(MobileElement) driver.findElementById("com.davis.mobilize:id/et_high_temp");
													//highTempBx.sendKeys(Keys.CLEAR);
													weatherPage.gethighRainTextBox().sendKeys(Keys.DELETE);
													weatherPage.gethighRainTextBox().sendKeys(Keys.INSERT);
													Thread.sleep(2000);
													temparatureBox.click();
													weatherPage.gethighTemptxBox().sendKeys(Keys.DELETE);
													weatherPage.gethighTemptxBox().sendKeys(Keys.INSERT);
													//highTempBx.sendKeys("151");weatherpagevalues
													weatherPage.gethighTemptxBox().sendKeys(weatherpagevalues.high_tem_F_ot_range);
													Thread.sleep(1000);
													
													System.out.println(weatherPage.gethighTemptxBox().getText() + "---text out of range value---");
													ATUReports.add("Entered Out of range value ", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													// driver.hideKeyboard();

													// Verify Observe Next button is Enabled.
													
													if (frostPage.getNext_nxt_save_btn().isEnabled()) {
														ATUReports.add("Next button is enabled in the " + hightempAlert_title,
																LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("Next button is not enabled in the  " + hightempAlert_title,
																LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
													Thread.sleep(2000);

													// Verify to enter max(value) range in textbox
													
													MobileElement highTempBx2=(MobileElement) driver.findElementById("com.davis.mobilize:id/et_high_temp");
													highTempBx2.click();
													highTempBx2.sendKeys(Keys.DELETE);
													highTempBx2.sendKeys(Keys.INSERT);
													Thread.sleep(2000);
													//highTempBx2.sendKeys("150");weatherpagevalues
													highTempBx2.sendKeys(weatherpagevalues.high_temp_F_max);
													Thread.sleep(1000);
													System.out.println(weatherPage.gethighTemptxBox().getText() + "---text maximum range value---");
													ATUReports.add("Entered maximum value", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													// driver.hideKeyboard();
													Thread.sleep(1000);

													// Verify Observe Next button is Enabled.
													// clikcedOnNext();

													if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
														weatherPage.getNext_nxt_save_btnn().click();
														ATUReports.add("Next button is enabled in the " + hightempAlert_title,
																LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("Next button is not enabled in the  " + hightempAlert_title,
																LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
													Thread.sleep(2000);

												} else {
													ATUReports.add("temperature value text box  is not observed in the screen ",
															actualTemperatureUnits, expectedTempTxt, LogAs.FAILED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													driver.close();
												}
												
												
												//--------*****Verify  Low Temperature alert***--------

												//get the value of the optional and click on it
												Thread.sleep(4000);
												if(weatherPage.getlowTemArtOptional().isDisplayed()){			
													ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
													Thread.sleep(4000);
												    WebElement optionalElement=weatherPage.getlowTemArtOptional();
													int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
													int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
													//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);

													if(xInitialOptional<1200){  
														driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
														//System.out.println("in 1st loop optional");
													}else{				
															if(xInitialOptional>1200){
															driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
																//System.out.println("in 2nd loop optional");
															}
													}
													Thread.sleep(2000);
												}else{
													ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}

												
												
												// Verify weather title text.
												String lowtemplert_title = weatherPage.getlowTempTitle().getText();
												
												if (lowtemplert_title.isEmpty()) {
													ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ",
															"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.WARNING,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												} else { 
													if (lowtemplert_title.contains("Low Temperature")) {
														ATUReports.add("Low Temperature  is noticed in the screen ",
																"Low Temperature", lowtemplert_title, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													} else {
														ATUReports.add("LOW TEMPERATURE is not observed in the screen ",
																lowtemplert_title, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
													if(lowtemplert_title.contains("Alert")){
														
														ATUReports.add("Alert is noFticed in the screen ",
																"Alert", lowtemplert_title, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														
													}else{
														ATUReports.add("ALERT is not observed in the screen ",
																lowtemplert_title, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														
													}
														
													}
												
												
												
												//verify to move the slider
												driver.swipe(920, 475, 1030, 475, (int)1.3);
												ATUReports.add(
														"After Draging  the Optional slider,Optional slider is in Active Mode",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												Thread.sleep(2000);
												
										
												// Verify temperature units from current page
												
												String actualLowTemperatureUnits =weatherPage.getlowTempFUnits().getText(); 
												System.out.println(actualLowTemperatureUnits + "---actualTemperatureUnits--c");
												System.out.println(expectedFtxt + "----cUnitsActualText----c");

												if (actualLowTemperatureUnits.isEmpty()) {
													ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												} else {
													if (actualLowTemperatureUnits.contains(expectedFtxt)) {
														ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
																actualLowTemperatureUnits, expectedFtxt, LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

														// Verify Tap on Temperature value box.

														MobileElement lowTemperatureBox = weatherPage.getlowTempTxtBox();
														String lowTemperatureBoxDefaultText = lowTemperatureBox.getText();
														System.out.println(lowTemperatureBoxDefaultText + "---lowTemperatureBoxDefaultText--high temp----- -");

														if (lowTemperatureBox != null && lowTemperatureBox.isDisplayed()) {

															ATUReports.add(
																	"Mobilize temperature value text box is displayed, and its default value is - "
																			+ lowTemperatureBoxDefaultText,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															// Verify to enter min(value) range in text box
															lowTemperatureBox.click();
															System.out.println("Clear the field");
															weatherPage.getlowTempTxtBox().sendKeys(Keys.DELETE);
															weatherPage.getlowTempTxtBox().sendKeys(Keys.INSERT);
															Thread.sleep(1000);
															//weatherPage.getlowTempTxtBox().sendKeys("0");weatherpagevalues
															weatherPage.getlowTempTxtBox().sendKeys(weatherpagevalues.low_tem_f_min);
															System.out.println("enter 0 value");

															System.out.println(weatherPage.getlowTempTxtBox().getText() + "---textminimum value---");
															ATUReports.add("Entered minimum value", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															driver.hideKeyboard();

															// Verify Observe Next button is Enabled.
														
															if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																
																ATUReports.add("Next button is enabled in the " + lowtemplert_title, LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															} else {
																ATUReports.add("Next button is not enabled in the " + lowtemplert_title, LogAs.FAILED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															}
															Thread.sleep(2000);
														

															// Verify to enter out of range values in text
															// box
																
														   Thread.sleep(1000);
															MobileElement LowTempBx=(MobileElement) driver.findElementById("com.davis.mobilize:id/et_low_temp");
															LowTempBx.sendKeys(Keys.CLEAR);
															Thread.sleep(2000);
															//LowTempBx.sendKeys("51");weatherpagevalues
															LowTempBx.sendKeys(weatherpagevalues.low_temp_f_ot_range);
															Thread.sleep(1000);	
															System.out.println(weatherPage.getlowTempTxtBox().getText() + "---text ot of value---");
															ATUReports.add("Entered Out of range value ", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															// driver.hideKeyboard();

															// Verify Observe Next button is Enabled.
														
															if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																ATUReports.add("Next button is enabled in the " + lowtemplert_title,
																		LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															} else {
																ATUReports.add("Next button is not enabled in the  " + lowtemplert_title,
																		LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															}
															Thread.sleep(2000);

															// Verify to enter max(value) range in textbox
															weatherPage.getlowTempTxtBox().click();
															weatherPage.getlowTempTxtBox().sendKeys(Keys.DELETE);
															weatherPage.getlowTempTxtBox().sendKeys(Keys.INSERT);
															Thread.sleep(2000);
															//weatherPage.getlowTempTxtBox().sendKeys("50");weatherpagevalues
															weatherPage.getlowTempTxtBox().sendKeys(weatherpagevalues.low_f_max);
															System.out.println(weatherPage.getlowTempTxtBox().getText() + "---text maxm  value---");
															ATUReports.add("Entered maximum value", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															// driver.hideKeyboard();
															Thread.sleep(1000);

															// Verify Observe Next button is Enabled.
															// clikcedOnNext();

															if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																weatherPage.getNext_nxt_save_btnn().click();
																ATUReports.add("Next button is enabled in the " + lowtemplert_title,
																		LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															} else {
																ATUReports.add("Next button is not enabled in the  " + lowtemplert_title,
																		LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															}
															Thread.sleep(2000);
															
					
															// Verify the COMPLETE FROST SETUP

															String COMPLETE_FROST_SETUP_title = weatherPage.getTitletxt().getText();
															if (COMPLETE_FROST_SETUP_title.isEmpty()) {
																ATUReports.add("Verify the COMPLETE FROST SETUP text  in the screen ",
																		"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.WARNING,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															} else {
																if (COMPLETE_FROST_SETUP_title.equals("Complete Weather Setup")) {
																	ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ",
																			"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("COMPLETE FROST SETUP is not noticed in the screen",
																			readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
															}

															// Verify save button is displayed or
															// not.

															MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
															String saveText = saveButton.getText();
															if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
																if (saveText.equals("Save")) {

																	ATUReports.add(
																			saveText + " button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
																			"Save", saveText, LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	// saveButton.click();
																	Thread.sleep(2000);

																} else {
																	ATUReports.add("Mobilize " + saveText + " button is not displayed. ",
																			readFrostData.ButtonTextThree, saveText, LogAs.FAILED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}

															} else {
																driver.close();
																return;
															}

															

														} else {
															ATUReports.add("temperature value text box  is not observed in the screen ",
																	actualLowTemperatureUnits, expectedFtxt, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															driver.close();
														}
														
																				
													}else{
														driver.close();
													}				
											}
												
				}else{
												//-------------******* VERIFY  HIGH & LOW TEMPERATURE IN C UNITS *****---------------
												
												if (actualTemperatureUnits.contains(cUnitsActualText)) {
													ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
															actualTemperatureUnits, cUnitsActualText, LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													// Verify Tap on Temperature value box.
													MobileElement temparatureBox = weatherPage.gethighTemptxBox();
													String textDefaultText = temparatureBox.getText();
													System.out.println(textDefaultText + "---textDefaultText--high temp-- in c units---- -");

													if (temparatureBox != null && temparatureBox.isDisplayed()) {

														ATUReports.add(
																"Mobilize temperature value text box is displayed, and its default value is - "
																		+ textDefaultText,
																LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

														// Verify to enter min(value) range in text box
														temparatureBox.click();
														MobileElement highTempBx2=(MobileElement) driver.findElementById("com.davis.mobilize:id/et_high_temp");
														highTempBx2.sendKeys(Keys.DELETE);	
														highTempBx2.sendKeys(Keys.INSERT);	
														Thread.sleep(2000);	
														//highTempBx2.sendKeys("0");weatherpagevalues
														highTempBx2.sendKeys(weatherpagevalues.high_temp_c_min);
														Thread.sleep(1000);
														System.out.println(weatherPage.gethighTemptxBox().getText() + "---textminimum value   in c---");
														ATUReports.add("Entered minimum value", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														driver.hideKeyboard();

														// Verify Observe Next button is Enabled.
														//nextButtonEnabled();
														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
															
															ATUReports.add("Next button is enabled in the " + hightempAlert_title, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the " + hightempAlert_title, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);
													
													

														// Verify to enter out of range values in text
														// box
														// it contains zero by default
														weatherPage.gethighTemptxBox().click();
														Thread.sleep(1000);
														weatherPage.gethighTemptxBox().sendKeys(Keys.DELETE);
														weatherPage.gethighTemptxBox().sendKeys(Keys.INSERT);
														Thread.sleep(2000);
														//weatherPage.gethighTemptxBox().sendKeys("66");weatherpagevalues
														weatherPage.gethighTemptxBox().sendKeys(weatherpagevalues.high_temp_c_ot_range);
														Thread.sleep(1000);						
														System.out.println(weatherPage.gethighTemptxBox().getText() + "---text out of range value- in c--");
														ATUReports.add("Entered Out of range value ", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														// driver.hideKeyboard();

														// Verify Observe Next button is Enabled.
														
														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
															ATUReports.add("Next button is enabled in the " + hightempAlert_title,
																	LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the  " + hightempAlert_title,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);

														// Verify to enter max(value) range in textbox
														weatherPage.gethighTemptxBox().click();
														Thread.sleep(1000);
														weatherPage.gethighTemptxBox().sendKeys(Keys.DELETE);
														weatherPage.gethighTemptxBox().sendKeys(Keys.INSERT);
														Thread.sleep(2000);
														//weatherPage.gethighTemptxBox().sendKeys("65");
														
														weatherPage.gethighTemptxBox().sendKeys(weatherpagevalues.high_temp_c_max);
														Thread.sleep(1000);
														System.out.println(weatherPage.gethighTemptxBox().getText() + "---text maximum range value in c---");
														ATUReports.add("Entered maximum value", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														// driver.hideKeyboard();
														Thread.sleep(1000);

														// Verify Observe Next button is Enabled.
														// clikcedOnNext();
														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
															weatherPage.getNext_nxt_save_btnn().click();
															ATUReports.add("Next button is enabled in the " + hightempAlert_title,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the  " + hightempAlert_title,
																	LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);

													} else {
														ATUReports.add("temperature value text box  is not observed in the screen ",
																actualTemperatureUnits, expectedTempTxt, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														driver.close();
													}
													
													
													//--------*****Verify  Low Temperature alert***--------

													//get the value of the optional and click on it
													Thread.sleep(4000);
													if(weatherPage.getlowTemArtOptional().isDisplayed()){			
														ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
														Thread.sleep(4000);
													    WebElement optionalElement=weatherPage.getlowTemArtOptional();
														int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
														int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
														//System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);

														if(xInitialOptional<1200){  
															driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
															//System.out.println("in 1st loop optional");
														}else{				
																if(xInitialOptional>1200){
																driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
																	//System.out.println("in 2nd loop optional");
																}
														}
														Thread.sleep(2000);
													}else{
														ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}

													
													
													// Verify weather title text.
													String lowtemplert_title = weatherPage.getlowTempTitle().getText();
													
													if (lowtemplert_title.isEmpty()) {
														ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ",
																"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.WARNING,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													} else { 
														if (lowtemplert_title.contains("Low Temperature")) {
															ATUReports.add("Low Temperature  is noticed in the screen ",
																	"Low Temperature", lowtemplert_title, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("LOW TEMPERATURE is not observed in the screen ",
																	lowtemplert_title, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														if(lowtemplert_title.contains("Alert")){
															
															ATUReports.add("Alert is noFticed in the screen ",
																	"Alert", lowtemplert_title, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															
														}else{
															ATUReports.add("ALERT is not observed in the screen ",
																	lowtemplert_title, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															
														}
															
														}
													
													
													// Verify Drag the slider to change the temperature
													thresholdSlider();
													Thread.sleep(4000);
													
											
													// Verify temperature units from current page
													
													String actualLowTemperatureUnits =weatherPage.getlowTempFUnits().getText(); 
													System.out.println(actualLowTemperatureUnits + "---actualTemperatureUnits--c");
													System.out.println(cUnitsActualText + "----cUnitsActualText----c");

													if (actualLowTemperatureUnits.isEmpty()) {
														ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													} else {
														if (actualLowTemperatureUnits.contains(cUnitsActualText)) {
															ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
																	actualLowTemperatureUnits, cUnitsActualText, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															// Verify Tap on Temperature value box.

															MobileElement lowTemperatureBox = weatherPage.getlowTempTxtBox();
															String lowTemperatureBoxDefaultText = lowTemperatureBox.getText();
															System.out.println(lowTemperatureBoxDefaultText + "---lowTemperatureBoxDefaultText--high temp----- -");

															if (lowTemperatureBox != null && lowTemperatureBox.isDisplayed()) {
																ATUReports.add(
																		"Mobilize temperature value text box is displayed, and its default value is - "
																				+ lowTemperatureBoxDefaultText,
																		LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

																// Verify to enter min(value) range in text box
																lowTemperatureBox.click();
																System.out.println("Clear the field");
																weatherPage.getlowTempTxtBox().sendKeys(Keys.DELETE);
																weatherPage.getlowTempTxtBox().sendKeys(Keys.INSERT);
																Thread.sleep(2000);
															//	weatherPage.getlowTempTxtBox().sendKeys("0");weatherpagevalues					
																weatherPage.getlowTempTxtBox().sendKeys(weatherpagevalues.low_c_min);
																Thread.sleep(1000);				
																System.out.println("enter 0 value");
																System.out.println(weatherPage.getlowTempTxtBox().getText() + "---textminimum value---");
																ATUReports.add("Entered minimum value", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																driver.hideKeyboard();

																// Verify Observe Next button is Enabled.
																//nextButtonEnabled();
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	
																	ATUReports.add("Next button is enabled in the " + lowtemplert_title, LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the " + lowtemplert_title, LogAs.FAILED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);
															

																// Verify to enter out of range values in text
																// box
																// it contains zero by default

																// weatherPage.getTemperatureBox().clear();
																Thread.sleep(1000);
																weatherPage.getlowTempTxtBox().click();
																weatherPage.getlowTempTxtBox().sendKeys(Keys.DELETE);
																Thread.sleep(2000);
															//	weatherPage.getlowTempTxtBox().sendKeys("11");weatherpagevalues
																weatherPage.getlowTempTxtBox().sendKeys(weatherpagevalues.low_temp_c_ot_range);
																Thread.sleep(1000);
																
																System.out.println(weatherPage.getlowTempTxtBox().getText() + "---text ot of value---");
																ATUReports.add("Entered Out of range value ", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																// driver.hideKeyboard();

																// Verify Observe Next button is Enabled.
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	ATUReports.add("Next button is enabled in the " + lowtemplert_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the  " + lowtemplert_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);

																// Verify to enter max(value) range in textbox					
																weatherPage.getlowTempTxtBox().clear();
																Thread.sleep(2000);
																//weatherPage.getlowTempTxtBox().sendKeys("10");weatherpagevalues
																weatherPage.getlowTempTxtBox().sendKeys(weatherpagevalues.low_temp_c_max);
																System.out.println(weatherPage.getlowTempTxtBox().getText() + "---text maxm  value---");
																ATUReports.add("Entered maximum value", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																// driver.hideKeyboard();
																Thread.sleep(1000);

																// Verify Observe Next button is Enabled.
																// clikcedOnNext();
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	frostPage.getNext_nxt_save_btn().click();
																	ATUReports.add("Next button is enabled in the " + lowtemplert_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the  " + lowtemplert_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);
																
												
																
																String COMPLETE_FROST_SETUP_title = weatherPage.getTitletxt().getText();
																if (COMPLETE_FROST_SETUP_title.isEmpty()) {
																	ATUReports.add("Verify the Complete Weather Setup text  in the screen ",
																			"Complete Weather Setup", COMPLETE_FROST_SETUP_title, LogAs.WARNING,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

																} else {
																	if (COMPLETE_FROST_SETUP_title.equals("Complete Weather Setup")) {
																		ATUReports.add("Complete Weather Setup is displayed in the screen ",
																				"Complete Weather Setup", COMPLETE_FROST_SETUP_title,
																				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("Complete Weather Setup is not noticed in the screen",
																				readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title,
																				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																}

																// Verify save button is displayed or
																// not.
																MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
																String saveText = saveButton.getText();
																if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
																	if (saveText.equals("Save")) {
																		ATUReports.add(
																				saveText + " button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
																				"Save", saveText, LogAs.PASSED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																		// saveButton.click();
																		Thread.sleep(2000);
																	} else {
																		ATUReports.add("Mobilize " + saveText + " button is not displayed. ",
																				readFrostData.ButtonTextThree, saveText, LogAs.FAILED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																} else {
																	driver.close();
																	return;
																}
															} else {
																ATUReports.add("temperature value text box  is not observed in the screen ",
																		actualTemperatureUnits, cUnitsActualText, LogAs.FAILED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																driver.close();
															}
															
																					
														}else{
															driver.close();
														}
													}
												}
												
											}
										
										    }
										
									
									
								           }else{
								        	   ATUReports.add(windSpeedText+" Units list is not displayed", LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								           }
								
								          }else{
								        	  driver.close();
								          }
											
												
												
											} else {
											ATUReports.add("Users preferences Temperature list is not displayed", LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												}
																
													
													} else {
														ATUReports.add("Users preferences list is not displayed", LogAs.FAILED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																driver.close();
															}
													
												} catch (InterruptedException i) {
													i.printStackTrace();
												}
										}
											


	
	
//Verify clicked on next button

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

	// This method is used to verify next button
	public void nextButtonEnabled() throws InterruptedException {
		//String frost_thresholdTitle = frostPage.getTitletxt().getText();
		if (frostPage.getNext_nxt_save_btn().isEnabled()) {
			// frostPage.getNext_nxt_save_btn().click();
			ATUReports.add("Next button is enabled in the title page " , LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Next button is not enabled in the  title page" , LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		Thread.sleep(2000);
	}

	// Verify to clicked on next button
	public void clikcedOnNext() throws InterruptedException {
		//String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
		if (frostPage.getNext_nxt_save_btn().isEnabled()) {
			frostPage.getNext_nxt_save_btn().click();
			ATUReports.add("Next button is not enabled in the in weather  title page" , LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Next button is enabled in the in the weather title page" , LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		Thread.sleep(2000);
	}

	
public void thresholdSlider() throws InterruptedException{
		
		//move the slider
		Thread.sleep(4000);
		WebElement lastElement =frostPage.getTempSlier();
		Thread.sleep(2000);
		int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth()/2;
		int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight()/2;
		System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
		driver.swipe(xInitial, yInitial, xInitial+200, yInitial, 5000);					
		ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	
}
































































//****** THIS CODE IS FOR FUTURE REFENCE TO CLICK ON PARTICULA VIEW FROM LIST AND SWIPE DOWN TO UP PAGE.************



/*	
//Click on particular view from the list 
for (int j = 1; j <= 4; j++) {
	System.out.println(j + "--j---");
	
	//this is mandatory to give this path here becs this is not accepting in pages.
	driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout")).click();
	Thread.sleep(4000);
	System.out.println("in loop view");

	

// scroll up the current page
	driver.scrollTo("Edit View");
	System.out.println("Scroll to edit view button");
	Thread.sleep(3000);
	
	
	// Verify tap on weather.
	System.out.println(newscreenpage.getweatherElement().getText() + "-----weatherTitleText----");
	if(newscreenpage.getweatherTitle() != null && newscreenpage.getweatherElement().isEnabled()) {
		if (newscreenpage.getweatherElement().getText().contains("WEATHER")) {
			ATUReports.add("Mobilize " +newscreenpage.getweatherElement().getText() + "  tab is displayed.", "WEATHER",
					newscreenpage.getweatherElement().getText(), LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			newscreenpage.getweatherElement().click();
			Thread.sleep(2000);

			ATUReports.add("Mobilize weather  tab is clicked", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(3000);
			break;
		} else {
			ATUReports.add("Mobilize Report title " +newscreenpage.getweatherElement().getText() + " tab is not displayed",
					newscreenpage.getweatherElement().getText(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.navigate().back();
			Thread.sleep(3000);
		}

		// break;
	} else {
		Thread.sleep(2000);
		System.out.println("I am  inside else");

		// Click on home page back button
		driver.navigate().back();
		Thread.sleep(3000);
	}

	if (j == 4) {
		Thread.sleep(2000);
		// scroll up the current page
		// driver.swipe(540, 1747, 540, 270, 5000);//note 3
		//ddriver.swipe(540, 1538, 540, 268, 5000);nexus5			
		driver.swipe(540, 1590, 540, 200, 5000);
		System.out.println("swiped-3");
		j = 1;
		Thread.sleep(4000);

	}

}
*/












												//This code is for future refences:
												
												/*//---------------//***** Verify c Units *********\\----------
												
												
												if (actualTemperatureUnits.contains(cUnitsActualText)) {
													ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
															actualTemperatureUnits, cUnitsActualText, LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													System.out.println(actualTemperatureUnits+"------actualTemperatureUnits---");
													// Verify Tap on Temperature value box.

													//MobileElement temparatureBox = weatherPage.gethighTemptxBox();
													//String textDefaultText = temparatureBox.getText();
													System.out.println(textDefaultText + "---textDefaultText--high temp----- -");

													if (temparatureBox != null && temparatureBox.isDisplayed()) {

														ATUReports.add(
																"Mobilize temperature value text box is displayed, and its default value is - "
																		+ textDefaultText,
																LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

														// Verify to enter min(value) range in text box
														temparatureBox.click();
														System.out.println("Clear the field");
														weatherPage.gethighTemptxBox().clear();
														Thread.sleep(1000);
														weatherPage.gethighTemptxBox().sendKeys("0");
														
														System.out.println("enter 0 value");

														System.out.println(weatherPage.gethighTemptxBox().getText() + "---textminimum value---");
														ATUReports.add("Entered minimum value", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														driver.hideKeyboard();

														// Verify Observe Next button is Enabled.
														nextButtonEnabled();

														// Verify to enter out of range values in text
														// box
														// it contains zero by default

														// weatherPage.getTemperatureBox().clear();
														Thread.sleep(1000);
														// weatherPage.getTemperatureBox().sendKeys("6");
														// Thread.sleep(2000);

														MobileElement highTempBx=(MobileElement) driver.findElementById("com.davis.mobilize:id/et_high_temp");
														highTempBx.sendKeys(Keys.CLEAR);
														Thread.sleep(2000);
														highTempBx.sendKeys("151");
														Thread.sleep(1000);
														
														System.out.println(weatherPage.gethighTemptxBox().getText() + "---text ot of value---");
														ATUReports.add("Entered Out of range value ", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														// driver.hideKeyboard();

														// Verify Observe Next button is Enabled.
														
														if (frostPage.getNext_nxt_save_btn().isEnabled()) {
															ATUReports.add("Next button is enabled in the " + hightempAlert_title,
																	LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the  " + hightempAlert_title,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);

														// Verify to enter max(value) range in textbox
														// it contains zero by default
														// weatherPage.getTemperatureBox().sendKeys("50");
														highTempBx.sendKeys(Keys.CLEAR);
														Thread.sleep(2000);				
														highTempBx.sendKeys("150");
														Thread.sleep(1000);

														System.out.println(weatherPage.gethighTemptxBox().getText() + "---text maxm  value---");
														ATUReports.add("Entered maximum value", weatherPage.gethighTemptxBox().getText(), LogAs.PASSED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														// driver.hideKeyboard();
														Thread.sleep(1000);

														// Verify Observe Next button is Enabled.
														// clikcedOnNext();

														if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
															frostPage.getNext_nxt_save_btn().click();
															ATUReports.add("Next button is enabled in the " + hightempAlert_title,
																	LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("Next button is not enabled in the  " + hightempAlert_title,
																	LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														Thread.sleep(2000);

													} else {
														ATUReports.add("temperature value text box  is not observed in the screen ",
																actualTemperatureUnits, cUnitsActualText, LogAs.FAILED,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														driver.close();
													}
													
													
													//--------*****Verify  Low Temperature alert***--------
													
													// Verify weather title text.
													//String lowtemplert_title = weatherPage.getlowTempTitle().getText();
													
													if (lowtemplert_title.isEmpty()) {
														ATUReports.add("Verify the LOW TEMPERATURE ALERT text  in the screen ",
																"LOW TEMPERATURE ALERT", lowtemplert_title, LogAs.WARNING,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													} else { 
														if (lowtemplert_title.contains("Low Temperature")) {
															ATUReports.add("Low Temperature  is noticed in the screen ",
																	"Low Temperature", lowtemplert_title, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														} else {
															ATUReports.add("LOW TEMPERATURE is not observed in the screen ",
																	lowtemplert_title, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
														}
														if(lowtemplert_title.contains("Alert")){
															
															ATUReports.add("Alert is noFticed in the screen ",
																	"Alert", lowtemplert_title, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															
														}else{
															ATUReports.add("ALERT is not observed in the screen ",
																	lowtemplert_title, LogAs.FAILED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															
														}
															
														}
													
													
													
													//verify to move the slider
													driver.swipe(920, 475, 1030, 475, (int)1.3);
													ATUReports.add(
															"After Draging  the Optional slider,Optional slider is in Active Mode",
															LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													Thread.sleep(2000);
													
											
													// Verify temperature units from current page
													
													//String actualLowTemperatureUnits =weatherPage.getlowTempFUnits().getText(); 
													System.out.println(actualLowTemperatureUnits + "---actualTemperatureUnits--c");
													System.out.println(cUnitsActualText + "----cUnitsActualText----c");

													if (actualLowTemperatureUnits.isEmpty()) {
														ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
																new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													} else {
														if (actualLowTemperatureUnits.contains(cUnitsActualText)) {
															ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
																	actualLowTemperatureUnits, cUnitsActualText, LogAs.PASSED,
																	new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

															// Verify Tap on Temperature value box.

															MobileElement lowTemperatureBox = weatherPage.getlowTempTxtBox();
															String lowTemperatureBoxDefaultText = lowTemperatureBox.getText();
															System.out.println(lowTemperatureBoxDefaultText + "---lowTemperatureBoxDefaultText--high temp----- -");

															if (lowTemperatureBox != null && lowTemperatureBox.isDisplayed()) {

																ATUReports.add(
																		"Mobilize temperature value text box is displayed, and its default value is - "
																				+ textDefaultText,
																		LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

																// Verify to enter min(value) range in text box
																lowTemperatureBox.click();
																System.out.println("Clear the field");
																weatherPage.getlowTempTxtBox().clear();
																Thread.sleep(1000);
																weatherPage.getlowTempTxtBox().sendKeys("0");
																
																System.out.println("enter 0 value");

																System.out.println(weatherPage.getlowTempTxtBox().getText() + "---textminimum value---");
																ATUReports.add("Entered minimum value", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																driver.hideKeyboard();

																// Verify Observe Next button is Enabled.
																//nextButtonEnabled();
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	// frostPage.getNext_nxt_save_btn().click();
																	ATUReports.add("Next button is enabled in the " + lowtemplert_title, LogAs.PASSED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the " + lowtemplert_title, LogAs.FAILED,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);

																// Verify to enter out of range values in text
																// box
																// it contains zero by default

																// weatherPage.getTemperatureBox().clear();
																Thread.sleep(1000);
																// weatherPage.getTemperatureBox().sendKeys("6");
																// Thread.sleep(2000);

																weatherPage.getlowTempTxtBox().clear();
																Thread.sleep(1000);
																weatherPage.getlowTempTxtBox().sendKeys("51");
																Thread.sleep(1000);
																
																System.out.println(weatherPage.getlowTempTxtBox().getText() + "---text ot of value---");
																ATUReports.add("Entered Out of range value ", temparatureBox.getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																// driver.hideKeyboard();

																// Verify Observe Next button is Enabled.
																//String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	ATUReports.add("Next button is enabled in the " + lowtemplert_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the  " + lowtemplert_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);

																// Verify to enter max(value) range in textbox
																// it contains zero by default
																weatherPage.getlowTempTxtBox().clear();
																Thread.sleep(2000);
																// weatherPage.getTemperatureBox().sendKeys("50");
																weatherPage.getlowTempTxtBox().sendKeys("50");

																System.out.println(temparatureBox.getText() + "---text maxm  value---");
																ATUReports.add("Entered maximum value", weatherPage.getlowTempTxtBox().getText(), LogAs.PASSED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																// driver.hideKeyboard();
																Thread.sleep(1000);

																// Verify Observe Next button is Enabled.
																// clikcedOnNext();

																if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
																	frostPage.getNext_nxt_save_btn().click();
																	ATUReports.add("Next button is enabled in the " + lowtemplert_title,
																			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																} else {
																	ATUReports.add("Next button is not enabled in the  " + lowtemplert_title,
																			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																}
																Thread.sleep(2000);
																
																
																
																
																
																// Verify the COMPLETE FROST SETUP

																String COMPLETE_FROST_SETUP_title = frostPage.getTitletxt().getText();
																if (COMPLETE_FROST_SETUP_title.isEmpty()) {
																	ATUReports.add("Verify the COMPLETE FROST SETUP text  in the screen ",
																			"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.WARNING,
																			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

																} else {
																	if (COMPLETE_FROST_SETUP_title.equals("Complete Frost Setup")) {
																		ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ",
																				"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
																				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	} else {
																		ATUReports.add("COMPLETE FROST SETUP is not noticed in the screen",
																				readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title,
																				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}
																}

																// Verify save button is displayed or
																// not.

																MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
																String saveText = saveButton.getText();
																if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
																	if (saveText.equals("Save")) {

																		ATUReports.add(
																				saveText + " button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
																				"Save", saveText, LogAs.PASSED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																		// saveButton.click();
																		Thread.sleep(2000);

																	} else {
																		ATUReports.add("Mobilize " + saveText + " button is not displayed. ",
																				readFrostData.ButtonTextThree, saveText, LogAs.FAILED,
																				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																	}

																} else {
																	driver.close();
																	return;
																}

																

															} else {
																ATUReports.add("temperature value text box  is not observed in the screen ",
																		actualLowTemperatureUnits, cUnitsActualText, LogAs.FAILED,
																		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																driver.close();
															}
														//}
													//}
														
												}else{
													ATUReports.add("TemperatureUnits text is  not noticed in the screen  same as expected ",
															actualLowTemperatureUnits, cUnitsActualText, LogAs.FAILED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													driver.close();
												}
													//driver.close();
												
												
												
												
											}//c lower(all) ends	
										
											}
											
								
								//-----------------
								}else{
									
									ATUReports.add(windSpeedText+" Units list is not  displayed", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}
								}else{
									
									ATUReports.add(unitsText+" Units list is not  displayed", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}
												
												
												
												
											
	
	
	// Verify clicked on next button

		public void clickonNextButton() throws InterruptedException {
			MobileElement next = loginpage.getNextButton();
			if (next.isDisplayed()) {
				next.click();
			} else {
				driver.quit();
			}
		}
	
		
	// This method is used to verify next button
		public void nextButtonEnabled() throws InterruptedException {
			String weather_thresholdTitle = weatherPage.getminuteTitle().getText();
			System.out.println(weather_thresholdTitle+"-----weather_thresholdTitle-----");
			if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
				// frostPage.getNext_nxt_save_btn().click();
				ATUReports.add("Next button is enabled in the " + weather_thresholdTitle, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the " + weather_thresholdTitle, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);
		}
}


/* Actions action = new Actions(driver);
 action.moveToElement(dalyRainAlert).build().perform();
 Thread.sleep(2000);
 System.out.println("movuse hover on");
 action.moveToElement(dalyRainAlert).click();
 System.out.println("Clicked on textbox");
 Thread.sleep(2000);
 action.moveToElement(dalyRainAlert).sendKeys(Keys.DELETE);
 
 //sendKeyEvent(AndroidKeyCode.DEL);
 Thread.sleep(2000);
 System.out.println("Deleted the code");
 action.moveToElement(dalyRainAlert).sendKeys("0.01");
 Thread.sleep(2000);
 System.out.println("Entered the value");*/
 
//  weatherPage.getdailyRainAlertTextBox().clear();
