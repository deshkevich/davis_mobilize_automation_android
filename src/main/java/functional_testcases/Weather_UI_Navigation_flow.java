package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Log;
import utility.Read_Frost_Data;

import java.net.MalformedURLException;
import java.util.List;

//Update the Unique weather name in the weather details excel sheet 
public class Weather_UI_Navigation_flow {
	private FrostPage frostpage ;
	private AndroidDriver driver;
	private WeatherPage weatherPage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private LoginPage loginpage;
	private Read_Frost_Data readFrostData;
	private Account_Page accountPage;
	@SuppressWarnings("unused")
	@Test
	public void Add_weather() throws MalformedURLException, InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		frostpage = new FrostPage(driver);
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		weatherPage = new WeatherPage(driver);
		new LoginPage(driver);
		readFrostData = new Read_Frost_Data();
		newviewscreenpage = new NewViewScreenPage(driver);
		homepage=new HomePage(driver);
		new FrostPage(driver);
		// Get the values from frost data file
		readFrostData.start();
		
		
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Weather_UI_Navigation_flow  test Case start");
		System.out.println("**********Weather_UI_Navigation_flow test Case start ********");

		try {

			
			Thread.sleep(5000);	
			
			// Calling precondition
			Create_view addClass = new Create_view();
			addClass.createView();
			Thread.sleep(15000);
			
			
			
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

				// Verify the back button text
				String back_btn_text_weather_sensor = weatherPage.getCancelbtn().getText();
				if (back_btn_text_weather_sensor.isEmpty()) {
					ATUReports.add("Cancel button element is not visible",
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Cancel button element is  visible",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
				//weatherPage.getStationtxt().click();
				Thread.sleep(2000);
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

					
					// Verify weather page pagination dots.
					MobileElement paginationDotsThree = weatherPage.getPageindicator();
					if (paginationDotsThree != null) {
						if (paginationDotsThree.isDisplayed()) {
							ATUReports.add("Pagination dots is Displayed in Weather first page",
									readFrostData.titleTextFour, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Pagination dots is not Displayed in Weather first page", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					} else {
						driver.close();
					}

					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();
					
					  //Verify optional 
					
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

					// Verify the back button text
					//String back_btn_text_weather_sensor = weatherPage.getCancelbtn().getText();
					if (back_btn_text_weather_sensor.isEmpty()) {
						ATUReports.add("Cancel button element visible",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							ATUReports.add("Cancel button element is not visible",
									LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

			
				
					// Verify the Optional button text
					String Optional = weatherPage.getOptionalText().getText();
					if (Optional.isEmpty()) {
						ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (Optional.equals("optional")) {
							ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Optional text is not observed in the screen ", Optional, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

			

					// verify the Average Wind speed text
					String Average_wind_speed = weatherPage.getAverage_wind_speed().getText();
					if (Average_wind_speed.isEmpty()) {
						ATUReports.add("Verify the wind speed threshold  text  in the screen ",
								"Average wind speed threshold", Average_wind_speed, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (Average_wind_speed.equals("Average wind speed threshold")) {
							ATUReports.add("Wind speed threshold text is dispalyed in the screen ",
									"Average wind speed threshold", Average_wind_speed, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Wind speed threshold text is not dispalyed in the screen ",
									Average_wind_speed, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
				

					// Verify weather page pagination dots.
					if (paginationDotsThree != null) {

						if (paginationDotsThree.isDisplayed()) {
							ATUReports.add("Pagination dots is Displayed in Weather second page",LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Pagination dots is not Displayed in Weather second page", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
					} else {
						driver.close();
					}

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add(
								"Next button is enabled in the 10 MINUTE AVERAGE WIND ALERTT and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(3000);

						
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
						// Verify the back button text
						if (back_btn_text_weather_sensor.isEmpty()) {
							ATUReports.add("Cancel button element visible",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								ATUReports.add("Cancel button element is not visible",
										LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

					

					
					
						// Verify the Optional button text
						String Optional_highwind = weatherPage.getOptionalText().getText();
						if (Optional_highwind.isEmpty()) {
							ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (Optional_highwind.equals("optional")) {
								ATUReports.add("Optional text is noticed in the screen ", "Optional", Optional_highwind,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Optional text is not observed in the screen ", Optional_highwind,
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}

						// verify the Wind speed text
						String wind_speed = weatherPage.getAverageWindSpeedThreshold().getText();
						if (wind_speed.isEmpty()) {
							ATUReports.add("Element is not visible", "Wind speed threshold:", wind_speed, LogAs.WARNING,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							if (wind_speed.equals("Wind speed threshold:")) {
								ATUReports.add("Wind speed threshold text is dispalyed in the screen ",
										"Wind speed threshold:", wind_speed, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Wind speed threshold text is not dispalyed in the screen ", wind_speed,
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						

						// Verify pagination buttons in weather third page
						if (paginationDotsThree != null) {
							if (paginationDotsThree.isDisplayed()) {
								ATUReports.add("Pagination dots is Displayed in Weather third page",
										 LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Pagination dots is not Displayed in Weather third page", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
						} else {
							driver.close();
						}

						// Click on the next button if enabled
						if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
							weatherPage.getNext_nxt_save_btnn().click();
							Thread.sleep(3000);
							// weatherPage.getNext_nxt_save_btnn().click();
							ATUReports.add(
									"Next button is enabled in the HIGH WIND ALERT and clicked on the Skip button",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							
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

							// Verify the back button text
							if (back_btn_text_weather_sensor.isEmpty()) {
								ATUReports.add("Cancel button element is not visible",
										LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									ATUReports.add("Cancel button element is visible",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

		
							// Verify the Optional button text
							String Optional_daily_rain = weatherPage.getOptionalText().getText();
							if (Optional_daily_rain.isEmpty()) {
								ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								if (Optional_daily_rain.equals("optional")) {
									ATUReports.add("Optional text is noticed in the screen ", "Optional",
											Optional_daily_rain, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Optional text is not observed in the screen ", Optional_daily_rain,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							// verify the daily rain threshold text
							String daily_rain_treshold = weatherPage.getDaily_rain_threshold().getText();
							if (daily_rain_treshold.isEmpty()) {
								ATUReports.add("Verify the Daily rain threshold text  in the screen ",
										"Daily rain threshold:", daily_rain_treshold, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (daily_rain_treshold.equals("Daily rain threshold:")) {
									ATUReports.add("Daily rain threshold text is dispalyed in the screen ",
											"Daily rain threshold:", daily_rain_treshold, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Daily rain threshold text is not dispalyed in the screen ",
											daily_rain_treshold, LogAs.FAILED,
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
							
							///Verifying minus icon
							minusIconButton();
							ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							Thread.sleep(2000);

						
							// Verify pagination buttons in weather fourth page
							if (paginationDotsThree != null) {
								if (paginationDotsThree.isDisplayed()) {
									ATUReports.add("Pagination dots is Displayed in Weather fourth page",
											readFrostData.titleTextFour, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Pagination dots is not Displayed in Weather fourth page",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}
							} else {
								driver.close();
							}

							// Click on the next button if enabled
							if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
								weatherPage.getNext_nxt_save_btnn().click();
								// weatherPage.getNext_nxt_save_btnn().click();
								ATUReports.add(
										"Next button is enabled in the DAILY RAIN ALERT and clicked on the Skip button",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								
								
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


								// Verify the back button text
								if (back_btn_text_weather_sensor.isEmpty()) {
									ATUReports.add("Cancel button element is not visible",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										ATUReports.add("Cancel button element is  visible",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

		
								// Verify the Optional button text
								String Optional_high_rain = weatherPage.getOptionalText().getText();
								if (Optional_high_rain.isEmpty()) {
									ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									if (Optional_high_rain.equals("optional")) {
										ATUReports.add("Optional text is noticed in the screen ", "Optional",
												Optional_high_rain, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Optional text is not observed in the screen ",
												Optional_high_rain, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}


								// verify the high rain rate text
								String high_rain_treshold = weatherPage.getHigh_rain_rate_threshold().getText();
								if (high_rain_treshold.isEmpty()) {
									ATUReports.add("Verify the High rain rate threshold text  in the screen ",
											"High rain rate threshold:", high_rain_treshold, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									if (high_rain_treshold.equals("High rain rate threshold:")) {
										ATUReports.add("High rain rate threshold text is dispalyed in the screen ",
												"High rain rate threshold:", high_rain_treshold, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("High rain rate threshold text is not dispalyed in the screen ",
												high_rain_treshold, LogAs.FAILED,
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


									// Verify the back button text
									if (back_btn_text_weather_sensor.isEmpty()) {
										ATUReports.add("Cancel button element is not  visible",
												LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Cancel button element is  visible",
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

								

									// Verify the Optional button text
									String Optional_high_temp = weatherPage.getOptionalText().getText();
									if (Optional_high_temp.isEmpty()) {
										ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (Optional_high_temp.equals("optional")) {
											ATUReports.add("Required text is noticed in the screen ", "Optional",
													Optional_high_temp, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Optional text is not observed in the screen ",
													Optional_high_temp, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}

									// verify the Average Wind speed text
									String high_temp_treshold = weatherPage.gethighThresholdText().getText();
									if (high_temp_treshold.isEmpty()) {
										ATUReports.add("Element is not visible", "High temperature:",
												high_temp_treshold, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										if (high_temp_treshold.equals("High temperature:")) {
											ATUReports.add("High temperature text is dispalyed in the screen ",
													"High temperature:", high_temp_treshold, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("High temperature text is not dispalyed in the screen ",
													high_temp_treshold, LogAs.FAILED,
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
									
									//clicked on minus icon
									minusIconButton();
									ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Click on the next button if enabled
									if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
										weatherPage.getNext_nxt_save_btnn().click();

										ATUReports.add(
												"Skip button is enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

										// Verify the back button text
										if (back_btn_text_weather_sensor.isEmpty()) {
											ATUReports.add("Cancel button element is not visible",
													LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											} else {
												ATUReports.add("Cancel button element is  visible",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}

										// Verify the Optional button text
										String Optional_low_temp = weatherPage.getOptionalText().getText();
										if (Optional_low_temp.isEmpty()) {
											ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (Optional_low_temp.equals("optional")) {
												ATUReports.add("Required text is noticed in the screen ", "Optional",
														Optional_low_temp, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Required text is not observed in the screen ",
														Optional_low_temp, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}

										// verify the Average Wind speed text
										String low_temp_treshold = weatherPage.getLow_temperature().getText();
										if (low_temp_treshold.isEmpty()) {
											ATUReports.add("Element is not visible", "Low temperature:",
													low_temp_treshold, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (low_temp_treshold.equals("Low temperature:")) {
												ATUReports.add("Low temperature text is dispalyed in the screen ",
														"Low temperature:", low_temp_treshold, LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("Low temperature text is not dispalyed in the screen ",
														low_temp_treshold, LogAs.FAILED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}
										// Verify Drag the slider to change the temperature
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
											
											

										

											// Verify pagination buttons in
											// weather last page
											if (paginationDotsThree != null) {

												if (paginationDotsThree.isDisplayed()) {
													ATUReports.add("Pagination dots is Displayed in Weather last page",
															readFrostData.titleTextFour, LogAs.PASSED,
															new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												} else {
													ATUReports.add(
															"Pagination dots is not Displayed in Weather last page",
															LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

												}
											} else {
												driver.close();
											}
											Thread.sleep(3000);

											// Click on save button
											if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
												weatherPage.getNext_nxt_save_btnn().click();
												ATUReports.add(
														"Save button is enabled in the complete Weather setup and clicked on the Save button",
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											Thread.sleep(4000);

											} else {
												ATUReports.add("Save button is bot enabled in the complete Crop setup ",
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

											}
											Thread.sleep(7000);
											
											
											Thread.sleep(1000);
											
											// Verifying tutorial icon
											Thread.sleep(2000);
											Precondition.tutorialDisalogBox();
											
											
											//Verify arrow buttons in report page								
											if(frostpage.getweatherDownArrow()!=null){
												ATUReports.add("Arrow button is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												if(frostpage.getweatherDownArrow().isDisplayed()){
													ATUReports.add("Clicked on Down arrow button in view report",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
													frostpage.getweatherDownArrow().click();
													Thread.sleep(5000);
													if(frostpage.getweatherViewReportDetailsInformation().isDisplayed()){
												
														ATUReports.add("After clicked on down arrow button it is expanded and displayed view report information",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}else{
														ATUReports.add("View report information is not displayed ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

													}
													
												}else{
													ATUReports.add("Down arrow button is not displayed ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												}
											}else{
												ATUReports.add("Down arrow button is not displayed in vew report",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											
											
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
											ATUReports.add("Click ok button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											

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
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
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

	// This method is display mm units
	public void mmUnits() throws InterruptedException {
		// Verify the 'mm' text
		String in_daily = weatherPage.getInches().getText();
		if (in_daily.isEmpty()) {
			ATUReports.add("mm element is not visible", null, LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} else {
			if (in_daily.equals("mm")) {
				ATUReports.add("mm text is noticed in the screen ", "Fmm", in_daily, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("mm text is not observed in the screen ", in_daily, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
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
