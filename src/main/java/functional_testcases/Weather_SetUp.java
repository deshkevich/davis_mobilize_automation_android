package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Read_Frost_Data;

public class Weather_SetUp {

	private AndroidDriver driver;
	private WeatherPage weatherPage;
	private NewViewScreenPage newviewscreenpage;
	private Read_Frost_Data readFrostData;
	private FrostPage frostPage;

	@SuppressWarnings("unused")
	@Test
	public void weather_SetUp() {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		weatherPage = new WeatherPage(driver);
		new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		new LoginPage(driver);
		readFrostData = new Read_Frost_Data();
		frostPage = new FrostPage(driver);
		try {

			// Calling precondition
			Create_view addClass = new Create_view();
			addClass.createView();
			Thread.sleep(10000);

			// Verify tap on WEATHER.
			MobileElement weatherTitle = newviewscreenpage.getweatherElement();
			System.out.println(readFrostData.titleText);
			String weatherTitleText = weatherTitle.getText();
			if (weatherTitle != null) {
				if (weatherTitle.isDisplayed()) {
					if (weatherTitleText.equals("WEATHER")) {
						ATUReports.add("Mobilize " + weatherTitleText + "  tab is displayed.", readFrostData.titleText,
								weatherTitleText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						weatherTitle.click();
						ATUReports.add("Mobilize frost tab is clicked", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);

					} else {
						ATUReports.add("Mobilize Report title " + weatherTitleText + " tab is not displayed",
								readFrostData.titleText, weatherTitleText, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			} else {
				driver.close();
				return;
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
					ATUReports.add("Verify the WEATHER SENSOR INPUT caption text  in the screen ",
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
						driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
					Thread.sleep(2000);
					}else{
						ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					if (frostPage.getNext_nxt_save_btn().isEnabled()) {

						ATUReports.add("moved the slider ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Slider is not visible and unable to move the slider ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add("Next button is enabled in the HIGH WIND ALERT and clicked on the Skip button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
					} else {
						ATUReports.add("Next button is enabled in the HIGH WIND ALERT and clicked on the Skip button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
					}

					  //Verify optional 
					driver.swipe(856, 429, 954, 429, 4000);
					ATUReports.add("Optional tab is enalbed",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(3000);

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
					

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add("Next button is enabled in the DAILY RAIN ALERT and clicked on the next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
					} else {
						ATUReports.add("Next button is enabled in the DAILY RAIN ALERT and clicked on the next button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
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

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add("next button is enabled in the DAILY RAIN ALERT and clicked on the next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(5000);
					} else {
						ATUReports.add("next button is enabled in the DAILY RAIN ALERT and clicked on the next button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
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

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add(
								"Skip button is enabled in the HIGH RAIN RATE ALERT and clicked on the Skip button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(6000);
					} else {
						ATUReports.add(
								"Skip button is not enabled in the HIGH RAIN RATE ALERT and clicked on the Skip button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
					}

					// Verify weather title text.
					String hightemplert_title = weatherPage.gethighTempTilte().getText();

					if (hightemplert_title.isEmpty()) {
						ATUReports.add("Verify the HIGH TEMPERATURE ALERT text  in the screen ",
								"HIGH TEMPERATURE ALERT", hightemplert_title, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (hightemplert_title.contains("High Temperature Alert")) {
							ATUReports.add("High Temperature Alert is noticed in the screen ", "High Temperature Alert",
									hightemplert_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("High Temperature Alert is not observed in the screen ", hightemplert_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					Thread.sleep(6000);

					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add(
								"Skip button is enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(6000);
					} else {
						ATUReports.add(
								"Skip button is not enabled in the HIGH TEMPERATURE ALERT and clicked on the Skip button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
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
					
					// Click on the next button if enabled
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add(
								"Skip button is enabled in the LOW TEMPERATURE ALERT and clicked on the Skip button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);

					} else {
						ATUReports.add(
								"Skip button is not enabled in the LOW TEMPERATURE ALERT and clicked on the Skip button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
					}

					// Click on save button
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add(
								"Save button is enabled in the complete Weather setup and clicked on the Save button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add(
								"Save button is not enabled in the complete Weather setup and clicked on the Save button",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
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

}
