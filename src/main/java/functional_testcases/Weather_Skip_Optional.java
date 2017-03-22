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
import utility.Log;
import utility.Read_Frost_Data;

import java.util.List;

public class Weather_Skip_Optional {

	private AndroidDriver driver;
	private WeatherPage weatherPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private LoginPage loginpage;
	@SuppressWarnings("unused")
	private Read_Frost_Data readFrostData;
	private Account_Page accountPage;
	@SuppressWarnings("unused")
	@Test
	public void Add_weather() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		weatherPage = new WeatherPage(driver);
		homepage = new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		loginpage = new LoginPage(driver);
		readFrostData = new Read_Frost_Data();
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		
		Log.startTestCase("***Weather_Skip_Optional test Case start****");
		System.out.println("**********Weather_Skip_Optional test Case start ********");

		try {
			
			Thread.sleep(3000);
			// Calling precondition
			Create_view addClass = new Create_view();
			addClass.createView();
			Thread.sleep(10000);

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

			// Verify the Edit Weather text
			String editweather = weatherPage.getEditWeather().getText();
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

				// Verify the body text
				String body = weatherPage.getBodytxt().getText();
				if (body.isEmpty()) {
					ATUReports.add("Verify the Weather Sensor Input caption text  in the screen ",
							"Select the appropriate device and weather station for monitoring weather data.",
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

				// Select any option from device drop down -
				//weatherPage.getStationtxt().click();
				weatherPage.getStationdropdown().click();
				ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);

				// Select any option from sensor drop down
				//weatherPage.getSensortxt().click();
				weatherPage.getSensordropdown().click();
				ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(7000);

				// Click on next button in the Weather Sensor Input
				if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
					weatherPage.getNext_nxt_save_btnn().click();
					ATUReports.add("Next button is enabled in the WEATHER SENSOR INPUT and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(6000);
					
					
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

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add(
								"Next button is enabled in the 10 MINUTE AVERAGE WIND ALERTT and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(4000);

						
						//get the value of the optional and click on it
						Thread.sleep(4000);
						if(weatherPage.gethighwndAlertOptional().isDisplayed()){			
							ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
							Thread.sleep(4000);
						    WebElement optionalElement= weatherPage.gethighwndAlertOptional();
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
						// Click on the next button if enabled
						if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
							weatherPage.getNext_nxt_save_btnn().click();
							ATUReports.add(
									"Skip button is enabled in the HIGH WIND ALERT and clicked on the Skip button",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(2000);
							
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

							// Click on the next button if enabled
							if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
								weatherPage.getNext_nxt_save_btnn().click();
								ATUReports.add(
										"Next button is enabled in the DAILY RAIN ALERT and clicked on the Skip button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
								
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

								// Click on the next button if enabled
								if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
									weatherPage.getNext_nxt_save_btnn().click();
									ATUReports.add(
											"Skip button is enabled in the HIGH RAIN RATE ALERT and clicked on the Skip button",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(5000);
									
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

									// Verify the body text in the Weather
									String hightemplert_body = weatherPage.gethighTempBody().getText();
									if (hightemplert_body.isEmpty()) {
										ATUReports.add("Verify the HIGH TEMPERATURE ALERT caption text  in the screen ",
												"Alert activated if current temperature meets or exceeds threshold.",
												hightemplert_body, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (hightemplert_body.equals(
												"Alert activated if current temperature meets or exceeds threshold.")) {
											ATUReports.add(
													"HIGH TEMPERATURE ALERT caption text is dispalyed in the screen ",
													"Alert activated if current temperature meets or exceeds threshold.",
													hightemplert_body, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"HIGH TEMPERATURE ALERT caption text is not dispalyed in the screen ",
													hightemplert_body, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}

									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();
										ATUReports.add(
												"Skip button is enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										Thread.sleep(6000);
										
										
										//get the value of the optional and click on it
										Thread.sleep(4000);
										if(weatherPage.getlowTemArtOptional().isDisplayed()){			
											ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
											Thread.sleep(4000);
										    WebElement optionalElement=weatherPage.getlowTemArtOptional();
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
										

										// Verify the body text in the
										// Weather
										String loetemplert_body = weatherPage.getlowTempBody().getText();
										if (loetemplert_body.isEmpty()) {
											ATUReports.add(
													"Verify the LOW TEMPERATURE ALERT caption text  in the screen ",
													"Alert activated if current temperature meets or goes below threshold.",
													loetemplert_body, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (loetemplert_body.equals(
													"Alert activated if current temperature meets or goes below threshold.")) {
												ATUReports.add(
														"LOW TEMPERATURE ALERT caption text is dispalyed in the screen ",
														"Alert activated if current temperature meets or goes below threshold.",
														loetemplert_body, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add(
														"LOW TEMPERATURE ALERT caption text is not dispalyed in the screen ",
														loetemplert_body, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}

										// Click on the next button if enabled
										if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
											weatherPage.getNext_nxt_save_btnn().click();
											ATUReports.add(
													"Skip button is enabled in the LOW TEMPERATURE ALERT and clicked on the Skip button",
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											Thread.sleep(2000);

											// Verify weather title text.
											String complete_weather_title = weatherPage.getTitletxt().getText(); 
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

											// Click on save button
											if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
												weatherPage.getNext_nxt_save_btnn().click();
												ATUReports.add(
														"Save button is enabled in the complete Weather setup and clicked on the Save button",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
												// Verifying tutorial icon
												Thread.sleep(2000);
												Precondition.tutorialDisalogBox();
												

												/*// verify the Add button
												if (homepage.getAddbtn().isDisplayed()
														|| homepage.getAddbtn().isEnabled()) {
													ATUReports.add(
															"Successfully created the Weather setup by skipping optional data",
															LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												} else {
													ATUReports.add(
															"Unable to create Weather by skipping the optional data",
															LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}*/

											} else {
												ATUReports.add("Save button is bot enabled in the complete Crop setup ",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											}
											
											Thread.sleep(5000);
											

											//Click on Manage Account    				
											homepage.getAccountbtn().click();
											ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											Thread.sleep(2000);
											
											
											// Verifying tutorial icon
											Thread.sleep(2000);
											Precondition.tutorialDisalogBox();
											
											 //Click on Settings button
											accountPage.getsettings().click();
											Thread.sleep(3000);
											System.out.println("Clicked on settings");
											ATUReports.add("Click Settings/Gear button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
											
								           //Click on log out button
											accountPage.getsettingsLogoutBtn().click();
											System.out.println("Clicked on logout");
											Thread.sleep(4000);
											ATUReports.add("Click Logout button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
											
								            //Click on Ok Button
											accountPage.getlogoutAlertOk().click();
											System.out.println("Clicked on ok");
											Thread.sleep(2000);


										} else {
											ATUReports.add("Skip button is enabled in the LOW TEMPERATURE ALERT ",
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}

									} else {
										ATUReports.add("Skip button is not enabled in the HIGH TEMPERATURE ALERT ",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

								} else {
									ATUReports.add("Skip button is not enabled in the HIGH RAIN RATE ALERT ",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							} else {
								ATUReports.add("Skip button is not enabled in the DAILY RAIN ALERT ", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						} else {
							ATUReports.add("Skip button is not enabled in the HIGH WIND ALERT ", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}

					} else {
						ATUReports.add("Skip button is not enabled in the 10 MINUTE AVERAGE WIND ALERTT ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				} else {
					ATUReports.add("Skip button is not enabled in the WEATHER SENSOR INPUT", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("Edit Weather is not noticed in the screen ", "Edit Weather", editweather, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}
}
