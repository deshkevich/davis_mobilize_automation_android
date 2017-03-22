package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Frost_Details;

import java.net.MalformedURLException;
import java.util.List;

public class Verify_Edit_Weather_Report {
	private NewViewScreenPage newviewscreenpage;
	private AndroidDriver driver ;
	private Read_Frost_Details read_frost_details;
	private WeatherPage weatherPage ;
	private CropPage cropPage;
	private FrostPage frostpage ;
	private LoginPage loginpage;
	private ReadUserData readUserData;	
	private HomePage homepage;
	@SuppressWarnings("unused")
	@Test
	public void verifyEditFrostView() throws InterruptedException, MalformedURLException{


		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		new HomePage(driver);
		new NewViewScreenPage(driver);
		new NewViewScreenPage(driver);
		new FrostPage(driver);
		homepage = new HomePage(driver);
		read_frost_details = new Read_Frost_Details();
		read_frost_details.start();
		weatherPage = new WeatherPage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		new Account_Page(driver);
		cropPage = new CropPage(driver);
		Thread.sleep(9000);
		loginpage = new LoginPage(driver);
		readUserData=new ReadUserData();
		readUserData.start();
		frostpage = new FrostPage(driver);
		try{
			                          // Calling precondition
						               Precondition addClass = new Precondition();
						               addClass.precondition();
									
									
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
									MobileElement viewName = newviewscreenpage.getView_txtfld();
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
									MobileElement nextAddButton = newviewscreenpage.getAddbtn();
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

								
						
						// Verify the Edit Weather text
						String editweather = weatherPage.getEditWeather().getText();
						// System.out.println(editfrost);
						if (editweather.isEmpty()) {
							ATUReports.add("Verify the Edit Weather in the screen ", "Edit Weather", editweather, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else if (editweather.equals("Edit Weather")) {
							ATUReports.add("Edit Weather is noticed in the screen ", "Edit Weather", editweather, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
						}

							// Verify the body text
							String body = weatherPage.getBodytxt().getText();
							// System.out.println(body);
							if (body.isEmpty()) {
								ATUReports.add("Verify the WEATHER SENSOR INPUT caption text  in the screen ",
										"Select the appropriate device or weather station and sensor inputs for monitoring frost data.",
										body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (body.equals(
										"Select the appropriate device and weather station for monitoring weather data.")) {
									ATUReports.add("WEATHER SENSOR INPUT caption text is dispalyed in the screen ",
											"Select the appropriate device and weather station for monitoring weather data.",
											body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("WEATHER SENSOR INPUT caption text is not dispalyed in the screen ", body,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
							Thread.sleep(3000);
							
							// Select any option from device drop down -
						//	weatherPage.getStationtxt().click();
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

								// Verify weather page pagination dots.
								MobileElement paginationDotsThree = weatherPage.getPageindicator();
								if (paginationDotsThree != null) {

									if (paginationDotsThree.isDisplayed()) {
										ATUReports.add("Pagination dots is Displayed in Weather first page", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Pagination dots is not Displayed in Weather first page", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									}
								} else {
									driver.close();
								}
							}
								
							// Verifying tutorial icon
							Thread.sleep(2000);
							Precondition.tutorialDisalogBox();

							
							//get the value of the optional and click on it
							Thread.sleep(4000);
							if(weatherPage.getavrgeOptional().isDisplayed()){			
								ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
								Thread.sleep(4000);
										WebElement optionalElement =weatherPage.getavrgeOptional();
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

								// Verify the body text in the Weather
								String weather_body = weatherPage.getminiteAvgBody().getText();
								if (weather_body.isEmpty()) {
									ATUReports.add("Verify the Weather caption text  in the screen ",
											"Alert activated if wind speed average threshold is met for any 10-minute span.",
											weather_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									if (weather_body.equals(
											"Alert activated if wind speed average threshold is met for any 10-minute span.")) {
										ATUReports.add("Weather caption text is dispalyed in the screen ",
												"Alert activated if wind speed average threshold is met for any 10-minute span.",
												weather_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Weather caption text is not dispalyed in the screen ", weather_body,
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
								
								
								
								
								// Verify Drag the slider to change the temperature
								//move the slider
							
								thresholdSlider();
								Thread.sleep(4000);
								
							
								//Verifying plus icon
								plusIconButton();
								ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
								
								//Verifying minus icon
								minusIconButton();
								ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
								
								
								// Click on the next button if enabled
								if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
									weatherPage.getNext_nxt_save_btnn().click();
									ATUReports.add(
											"Next button is enabled in the 10 MINUTE AVERAGE WIND ALERTT and clicked on the Next button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(3000);
									
								}else{
									ATUReports.add(
											"Next button is not enabled in the 10 MINUTE AVERAGE WIND ALERTT and clicked on the Next button",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
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

								// Verify the body text in the Weather
								String highwindalert_body = weatherPage.getwindAlertBody().getText();
								if (highwindalert_body.isEmpty()) {
									ATUReports.add("Verify the HIGH WIND ALERT caption text  in the screen ",
											"Alert activated if wind speed threshold is met at any moment.", highwindalert_body, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									if (highwindalert_body.equals("Alert activated if wind speed threshold is met at any moment.")) {
										ATUReports.add("HIGH WIND ALERT caption text is dispalyed in the screen ",
												"Alert activated if wind speed threshold is met at any moment.", highwindalert_body, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("HIGH WIND ALERT caption text is not dispalyed in the screen ",
												highwindalert_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									
								}
									
								// Verify Drag the slider to change the temperature
								//move the slider
								//AddFrost slider=new AddFrost();
								thresholdSlider();
								Thread.sleep(4000);
								
							
								//Verifying plus icon
								plusIconButton();
								ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								Thread.sleep(2000);
								
								//Verifying minus icon
								minusIconButton();
								ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
									
									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();
										Thread.sleep(3000);
										// weatherPage.getNext_nxt_save_btnn().click();
										ATUReports.add(
												"Next button is enabled in the HIGH WIND ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));			
									}else{
										ATUReports.add(
												"Next button is not enabled in the HIGH WIND ALERT and clicked on the Skip button",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

									// Verify the body text in the Weather
									String dailyrainalert_body = weatherPage.getdailyRainBody().getText();
									if (dailyrainalert_body.isEmpty()) {
										ATUReports.add("Verify the Daily Rain Alert caption text  in the screen ",
												"Alert activated if daily rain threshold is met from midnight to midnight.", dailyrainalert_body,
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (dailyrainalert_body.equals("Alert activated if daily rain threshold is met from midnight to midnight.")) {
											ATUReports.add("DAILY RAIN ALERT caption text is dispalyed in the screen ",
													"Alert activated if daily rain threshold is met from midnight to midnight.", dailyrainalert_body,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("DAILY RAIN ALERT caption text is not dispalyed in the screen ",
													dailyrainalert_body, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									
									// Verify Drag the slider to change the temperature
									//move the slider
									//AddFrost slider=new AddFrost();
									thresholdSlider();
									Thread.sleep(4000);
									
								
									//Verifying plus icon
									plusIconButton();
									ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									Thread.sleep(2000);
									
									//Verifying minus icon
								     minusIconButton();
									ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);
									
									
									
									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();
										// weatherPage.getNext_nxt_save_btnn().click();
										ATUReports.add(
												"Next button is enabled in the DAILY RAIN ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));						
									}else{
										ATUReports.add(
												"Next button is not enabled in the DAILY RAIN ALERT and clicked on the Skip button",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									
									
									//get the value of the optional and click on it
									Thread.sleep(4000);
									if(weatherPage.gethighRainRateArtOptional().isDisplayed()){			
										ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
										Thread.sleep(4000);
									    WebElement optionalElement=weatherPage.gethighRainRateArtOptional();
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

									// Verify the body text in the Weather
									String highrainalert_body = weatherPage.gethighRainBody().getText();
									if (highrainalert_body.isEmpty()) {
										ATUReports.add("Verify the High Rain Rate Alert caption text  in the screen ",
												"High rain rate alerts will let you know if.", highrainalert_body,
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (highrainalert_body.equals("Alert activated if rain rate per hour threshold is met.")) {
											ATUReports.add("HIGH RAIN RATE ALERT caption text is dispalyed in the screen ",
													"Alert activated if rain rate per hour threshold is met.", highrainalert_body,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"HIGH RAIN RATE ALERT caption text is not dispalyed in the screen ",
													highrainalert_body, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									
									
									
									// Verify Drag the slider to change the temperature
									//move the slider
									//AddFrost slider=new AddFrost();
									thresholdSlider();
									Thread.sleep(4000);
									
								
									//Verifying plus icon
									plusIconButton();
									ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									Thread.sleep(2000);
									
									//Verifying minus icon
									minusIconButton();
									ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();
										
										ATUReports.add(
												"Skip button is enabled in the HIGH RAIN RATE ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
									}else{
										ATUReports.add(
												"Skip button is not enabled in the HIGH RAIN RATE ALERT and clicked on the Skip button",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									
									
									//get the value of the optional and click on it
									Thread.sleep(4000);
									if(weatherPage.gethighTemAlrtOptional().isDisplayed()){			
										ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
										Thread.sleep(4000);
									    WebElement optionalElement=weatherPage.gethighTemAlrtOptional();
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
									String hightemplert_title = weatherPage.gethighTempTilte().getText();

									if (hightemplert_title.isEmpty()) {
										ATUReports.add("Verify the HIGH TEMPERATURE ALERT text  in the screen ",
												"HIGH TEMPERATURE ALERT", hightemplert_title, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {			
										if (hightemplert_title.contains("High Temperature")) {
											ATUReports.add("High Temperature is noticed in the screen ",
													"High Temperature Alert", hightemplert_title, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("HIGH TEMPERATURE ALERT is not observed in the screen ",
													hightemplert_title, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										if (hightemplert_title.contains("Alert")) {
											ATUReports.add("Alert is noticed in the screen ", "Alert",
													hightemplert_title, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Alert is not observed in the screen ", hightemplert_title,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}
									}

									Thread.sleep(6000);
									
									
									
									
									// Verify Drag the slider to change the temperature
									//move the slider
									thresholdSlider();
									Thread.sleep(4000);
									
								
									//Verifying plus icon
									plusIconButton();
									ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									Thread.sleep(2000);
									
									//Verifying minus icon
									minusIconButton();
									ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();

										ATUReports.add(
												"Skip button is enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
									}else{
										ATUReports.add(
												"Skip button is not enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
									}
									
									
									
												
									ATUReports.add(
											"Skip button is enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									
									// Verify Drag the slider to change the temperature
									//move the slider
									//AddFrost slider=new AddFrost();
									thresholdSlider();
									Thread.sleep(4000);
									
								
									//Verifying plus icon
									plusIconButton();
									ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									Thread.sleep(2000);
									
									//Verifying minus icon
									minusIconButton();
									ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();
										// weatherPage.getNext_nxt_save_btnn().click();
										ATUReports.add(
												"Skip button is enabled in the LOW TEMPERATURE ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}else{
										ATUReports.add(
												"Skip button is not enabled in the LOW TEMPERATURE ALERT and clicked on the Skip button",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									
							
									// Verify weather title text.
									String complete_weather_title = weatherPage.getTitletxt().getText(); // System.out.println(title);
									if (complete_weather_title.isEmpty()) {
										ATUReports.add("Verify the COMPLETE WEATHER SETUP text  in the screen ",
												"Complete Weather Setup", complete_weather_title, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (complete_weather_title.equalsIgnoreCase("Complete Weather Setup")) {
											ATUReports.add("Complete Weather Setup is noticed in the screen ",
													"Complete Weather Setup", complete_weather_title,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"Complete Weather Setup is not observed in the screen ",
													complete_weather_title, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									// Verify the body text in the
									// Weather
									String complete_weather_body = weatherPage.getBodytxt().getText();
									if (complete_weather_body.isEmpty()) {
										ATUReports.add(
												"Verify the COMPLETE WEATHER SETUP caption text  in the screen ",
												"Save the setup to view the weather report. Go back to edit any weather setup setting.",
												complete_weather_body, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (complete_weather_body.equals(
												"Save the setup to view the weather report. Go back to edit any weather setup setting.")) {
											ATUReports.add(
													"COMPLETE WEATHER SETUP caption text is dispalyed in the screen ",
													"Save the setup to view the weather report. Go back to edit any weather setup setting.",
													complete_weather_body, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"COMPLETE WEATHER SETUP caption text is not dispalyed in the screen ",
													complete_weather_body, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									
									
									// Verify Save the frost setup
									MobileElement saveButton = cropPage.getNext_nxt_save_btn();
									if(saveButton!=null){
									saveButton.click();
									ATUReports.add(
											"COMPLETE WEATHER SETUP save button is dispalyed in the screen ,and clicked on save buuton ",
											LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);
									}else{
										ATUReports.add(
												"COMPLETE WEATHER SETUP save button is not dispalyed in the screen ",
												LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									
									
									// Verifying tutorial icon
									Thread.sleep(2000);
									Precondition.tutorialDisalogBox();
									
									
						

		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		
							}
	
public void thresholdSlider() throws InterruptedException{
		
		//move the slider
		Thread.sleep(4000);
		WebElement lastElement =frostpage.getTempSlier();
		Thread.sleep(2000);
		int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth()/2;
		int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight()/2;
		System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
		driver.swipe(xInitial, yInitial, xInitial+200, yInitial, 5000);					
		ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}


//This method used to click on next button
	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}
	
	
	public void plusIconButton() throws InterruptedException{		
	        //move the slider
			Thread.sleep(4000);
			WebElement lastElement =frostpage.getplusIcon();
			
			if(lastElement.isDisplayed()){
			lastElement.click();
			ATUReports.add("Plus icon is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		
		ATUReports.add("Plus icon is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.close();
	}
	}
	
	public void minusIconButton() throws InterruptedException{		
        //move the slider
		Thread.sleep(4000);
		WebElement lastElement =frostpage.getminusIcon();
		if(lastElement.isDisplayed()){
			lastElement.click();
			ATUReports.add("Minus icon is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		
		ATUReports.add("Minus icon is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.close();
	}
	}
						
}





















//for future refernce


/*if (saveButton != null) {
String saveText = saveButton.getText();
if (saveButton.isDisplayed()) {
	if (saveText.equals("Save"))

		ATUReports.add("Clicked on  " + saveText + " button in weather set up page",
		 saveText, LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	saveButton.click();
	Thread.sleep(3000);

} else {
	ATUReports.add("Mobilize " + saveText + " button is not displayed.",
			 saveText, LogAs.FAILED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}

} else {
driver.close();
//return;
}*/


/*
//Click on Manage Account    				
homepage.getAccountbtn().click();
ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
Thread.sleep(2000);

//Click on Settings button
accountPage.getsettings().click();
Thread.sleep(3000);
System.out.println("Clicked on settings");
ATUReports.add("Click Settings/Gear button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


//Click on logout button
accountPage.getsettingsLogoutBtn().click();
System.out.println("Clicked on logout");
Thread.sleep(4000);
ATUReports.add("Click Logout button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


//Click on Ok Button
accountPage.getlogoutAlertOk().click();
System.out.println("Clicked on ok");
Thread.sleep(2000);
ATUReports.add("Click ok button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
