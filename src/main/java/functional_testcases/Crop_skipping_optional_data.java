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
import utility.ReadUserData;

import java.util.List;

public class Crop_skipping_optional_data{
	private AndroidDriver driver;
	private CropPage cropPage;
	private HomePage homepage;
	private LoginPage loginpage;
	private Account_Page accountPage;
	private ReadUserData readUserData;	
	private NewViewScreenPage newviewscreenpage;
	@Test
	public void addingCrop() throws InterruptedException {
		try {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		cropPage = new CropPage(driver);
		homepage = new HomePage(driver);
		new NewViewScreenPage(driver);
		loginpage = new LoginPage(driver);
		new WeatherPage(driver);
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		readUserData=new ReadUserData();
		readUserData.start();
		Thread.sleep(2000);
		newviewscreenpage = new NewViewScreenPage(driver);
		Log.startTestCase("***Crop_skipping_optional_data  test Case start***");
		System.out.println("**********Crop_skipping_optional_data test Case start ********");

		
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
						
						
						//Verifying tutorial icon
						Precondition.tutorialDisalogBox();		

						// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
						Thread.sleep(1000);
						List <WebElement> cropTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));				
						for(int i=0;i<=cropTitle.size();i++){
							String cropTitleText =cropTitle.get(i).getText();
							System.out.println(cropTitleText + "---accessabilityid---");							
							if (cropTitleText.contains("CROP")) {
								ATUReports.add("Mobilize " + cropTitleText + "  tab is displayed.", "CROP", cropTitleText,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								cropTitle.get(i).click();
								
								Thread.sleep(2000);
								ATUReports.add("Mobilize CROP tab is clicked", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								break;
							} else {
								ATUReports.add("Mobilize Report title " + cropTitleText + " tab is not displayed", "CROP",
										cropTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							
							}
							
						}
						
			

			// Verify the Edit Crop text
			String editcrop = cropPage.getEditcorp().getText();
			if (editcrop.isEmpty()) {
				ATUReports.add("Verify the Edit Crop in the screen ", "Edit Crop", editcrop, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else if (editcrop.equals("Edit Crop")) {
				ATUReports.add("Edit Crop is noticed in the screen ", "Edit Crop", editcrop, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Verify the title text
				String crop_sensor_title = cropPage.getTitletxt().getText();
				if (crop_sensor_title.isEmpty()) {
					ATUReports.add("Verify the CROP SENSOR INPUT text  in the screen ", "CROP SENSOR INPUT",
							crop_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_sensor_title.equals("Crop Sensor Input")) {
						ATUReports.add("Crop Sensor Input is noticed in the screen ", "Crop Sensor Input",
								crop_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Crop Sensor Input is not observed in the screen ", crop_sensor_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				Thread.sleep(3000);
				

				// Verify the body text in the crop sensor
				String cropbody = cropPage.getBodytxt().getText();
				if (cropbody.isEmpty()) {
					ATUReports.add("Verify the Crop Sensor Input caption text  in the screen ",
							"Select the appropriate device and temperature sensor input for monitoring crop data.",
							cropbody, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (cropbody.contains(
							"Select the appropriate device and temperature sensor input for monitoring crop data.")) {
						ATUReports.add("Crop Sensor Input caption text is dispalyed in the screen ",
								"Select the appropriate device and temperature sensor input for monitoring crop data.",
								cropbody, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Crop Sensor Input caption text is not dispalyed in the screen ", cropbody,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}				
				}

				Thread.sleep(2000);

				// Select any option from device drop down -
				//cropPage.getdDevicestxt().click();
				Thread.sleep(2000);
				cropPage.getDevicedropdown().click();
				Thread.sleep(2000);
				ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Select any option from sensor drop down
				//cropPage.getSensortxt().click();
				Thread.sleep(2000);
				cropPage.getSensordropdown().click();
				Thread.sleep(2000);
				ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Click on next button in the Crop Sensor Input
				if (cropPage.getNext_nxt_save_btn().isEnabled()) {
					cropPage.getNext_nxt_save_btn().click();
					ATUReports.add("Next button is enabled in the Crop Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled Crop Sensor Input", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
				
				//Verifying tutorial icon
				Precondition.tutorialDisalogBox();		

				// Verify Crop title text.
				String crop_sensor_title1 = cropPage.getcropandVariety().getText();
				// System.out.println(title);
				if (crop_sensor_title1.isEmpty()) {
					ATUReports.add("Verify the CROP & VARIETY text  in the screen ", "CROP", crop_sensor_title1,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_sensor_title1.equals("Crop & Variety")) {
						ATUReports.add("Crop & Variety is noticed in the screen ", "Crop & Variety", crop_sensor_title1, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("CROP is not observed in the screen ", crop_sensor_title1, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				// Verify the body text in the crop
				String crop_body = cropPage.getvarietyBody().getText();

				if (crop_body.isEmpty()) {
					ATUReports.add("Verify the Crop caption text  in the screen ", "What type of crop are you growing?",
							crop_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop_body.equals("Enter the crop type and variety to build a crop specific profile.")) {
						ATUReports.add("Crop caption text is dispalyed in the screen ",
								"Enter the crop type and variety to build a crop specific profile.", crop_body, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Crop caption text is not dispalyed in the screen ", cropbody, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				// Click on Skip button in the Edit Crop -Crop screen.
				if (cropPage.getNext_nxt_save_btn().isEnabled()) {
					cropPage.getNext_nxt_save_btn().click();
					ATUReports.add("Skip button is enabled in the Crop and clicked on the Next button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Skip button is not enabled Crop ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				// Verify Growing degree start date title text.
				String growing_degree_title = cropPage.getgddTitle().getText();
				// System.out.println(growing_degree_title+"growing_degree_title------");
				if (growing_degree_title.isEmpty()) {
					ATUReports.add("Verify the GROWING DEGREE START DATE (GDD) text  in the screen ",
							"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (growing_degree_title.contains("Growing Degree Start")) {
						ATUReports.add("GROWING DEGREE START DATE (GDD) is noticed in the screen ",
								"Growing Degree Start", growing_degree_title, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("GROWING DEGREE START is not observed in the screen ", growing_degree_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					if (growing_degree_title.contains("Date (GDD)")) {

						ATUReports.add("Date (GDD) is noticed in the screen ", "Date (GDD)", growing_degree_title,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Date (GDD) is not observed in the screen ", growing_degree_title, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(3000);

				// Click on Skip button in the Edit Crop -Crop screen.
				if (cropPage.getNext_nxt_save_btn().isEnabled()) {
					cropPage.getNext_nxt_save_btn().click();
					ATUReports.add("Skip button is enabled in the Crop Sensor Input and clicked on the Next button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Skip button is not enabled Crop ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				Thread.sleep(3000);

				

				// Verify Growing degree start date title text.
				String error_title = cropPage.getalertTitle().getText();
				System.out.println(error_title + "error_title");
				if (error_title.isEmpty()) {
					ATUReports.add("Verify the Skip the GDD Start Date? text  in the screen ",
							"Skip the GDD Start Date?", error_title, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (error_title.equals("Skip GDD Start Date")) {
						ATUReports.add("Skip GDD Start Date is noticed in the screen ", "Skip the GDD Start Date?",
								error_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Skip GDD Start Date is not observed in the screen ", error_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(3000);
				

				// Verify Growing degree start date error title
				// text.
				String error_body = cropPage.getalertBody().getText();
				if (error_body.isEmpty()) {
					ATUReports.add("Verify the text under the title in the Alert ",
							"You will not be able to monitor GDD if you skip this step.",
							error_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (error_body.equals(
							"You will not be able to monitor GDD if you skip this step.")) {
						ATUReports.add("Text under the title is present in the Alert ",
								"You will not be able to monitor GDD if you skip this step.",
								error_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Text under the title is not present in the Alert ", error_body, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(3000);

				// Click on alert
				cropPage.getalertHelpOk().click();
				Thread.sleep(5000);
				
				
			
				// Verify Chill start date title text.
				String chill_start_title = cropPage.getTitletxt().getText();
				if (chill_start_title.isEmpty()) {
					ATUReports.add("Verify the CHILL START DATE text  in the screen ", "CHILL START DATE",
							chill_start_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (chill_start_title.contains("Chill Start Date")) {
						ATUReports.add(
								"Chill Start Date is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
								"Chill Start Date", chill_start_title, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Chill Start Date is not observed in the screen ", chill_start_title,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(2000);
				
			

				// Click on the skip button
				if (cropPage.getNext_nxt_save_btn().isEnabled()) {
					cropPage.getNext_nxt_save_btn().click();
					ATUReports.add("Skip  button is enabled and Clicked on Skip button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Clicked on the Skip button", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				
				
				// Verify Chill start date title text.
				String complete_crop_setup = cropPage.getTitletxt().getText();
				if (complete_crop_setup.isEmpty()) {
					ATUReports.add("Verify the Complete Crop Setup text  in the screen ", "COMPLETE CROP SETUP",
							complete_crop_setup, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					if (complete_crop_setup.equals("Complete Crop Setup")) {
						ATUReports.add(
								"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
								"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Complete Crop SetupP is not observed in the screen ", complete_crop_setup,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				Thread.sleep(2000);

				// Click on save button
				if (cropPage.getNext_nxt_save_btn().isEnabled()) {
					cropPage.getNext_nxt_save_btn().click();
					ATUReports.add("Save button is enabled in the complete Crop setup and clicked on the Save button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Save button is bot enabled in the complete Crop setup ",

							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
				
				//Verify alert 
				String cropAlertText=cropPage.getcropAlertTitle().getText();
				if(cropPage.getcropAlertTitle().isDisplayed()){
					if(cropAlertText.contains("Cancel Adding Crop?")){
					
					ATUReports.add("Cancel Adding Crop Alert is displayed in current screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Cancel Adding Crop Alert is displayed in wrong screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
					
					
					// Verify go back button
					MobileElement goBackButton = cropPage.getcropGoBack();
					String goBackText = goBackButton.getText();
					System.out.println(goBackText+"goBackText");
					if (goBackText.contains("Go Back")) {
						ATUReports.add(
								"Go back  button is Displayed in the crop 'Cancel adding crop dialog box' and clicked on Go Back button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						goBackButton.click();
						Thread.sleep(2000);
					} else {
						ATUReports.add(
								"Go back  button is not Displayed in the crop 'Cancel adding crop dialog box'",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					Thread.sleep(2000);
					
					
				
					// Verify Growing degree start date title text.
					if (growing_degree_title.isEmpty()) {
						ATUReports.add("Verify the GROWING DEGREE START DATE (GDD) text  in the screen ",
								"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (growing_degree_title.contains("Growing Degree Start")) {
							ATUReports.add("GROWING DEGREE START DATE (GDD) is noticed in the screen ",
									"Growing Degree Start", growing_degree_title, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("GROWING DEGREE START is not observed in the screen ", growing_degree_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						if (growing_degree_title.contains("Date (GDD)")) {

							ATUReports.add("Date (GDD) is noticed in the screen ", "Date (GDD)", growing_degree_title,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Date (GDD) is not observed in the screen ", growing_degree_title, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					Thread.sleep(3000);
					
					//click on skip
					cropPage.getNext_nxt_save_btn().click();
					Thread.sleep(3000);
					
					//Clicked on skip button in growing start date page
					cropPage.getalertHelpOk().click();
					Thread.sleep(3000);
					
					//click on skip
					cropPage.getNext_nxt_save_btn().click();
					Thread.sleep(2000);
					
					//Click on save button
					cropPage.getNext_nxt_save_btn().click();
					System.out.println("Clicked on skip button at last ");
					
					
					//Verify continue button
					MobileElement continueButton = cropPage.getcropContinue();
					String continueText = continueButton.getText();
					System.out.println(continueText+"goBackText");
					if (continueText.contains("Continue")) {
						ATUReports.add(
								"Continue button is Displayed in the crop 'Cancel adding crop dialog box' and clicked on Continue button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						continueButton.click();
						Thread.sleep(2000);
					} else {
						ATUReports.add(
								"Continue  button is not Displayed in the crop 'Cancel adding crop dialog box'",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					Thread.sleep(3000);
					
					
					
					// verify the Add button
					if (homepage.getAddbtn().isDisplayed() || homepage.getAddbtn().isEnabled()) {
						ATUReports.add("Successfully created the crop setup by skipping optional data, After clicked on continue buton",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Unable to create crop by skipping the optional data", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
							
				
				
			} else {
				ATUReports.add("Cancel Adding Crop Alert is not displayed in the screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			
				//Click on Manage Account    				
				homepage.getAccountbtn().click();
				ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(3000);
				
				//Verifying tutorial icon
				Precondition.tutorialDisalogBox();		
						
				 //Click on Settings button
				accountPage.getsettings().click();
				Thread.sleep(3000);
				System.out.println("Clicked on settings");
				ATUReports.add("Click Settings/Gear button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
	           //Click on log out button
				accountPage.getsettingsLogoutBtn().click();
				System.out.println("Clicked on logout");
				Thread.sleep(5000);
				ATUReports.add("Click Logout button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
	            //Click on Ok Button
				accountPage.getlogoutAlertOk().click();
				System.out.println("Clicked on ok");
				Thread.sleep(2000);
				ATUReports.add("Click ok button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				

			} else {
				ATUReports.add("Edit Crop is not noticed in the screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

		} catch (Exception e) {
			// TODO: handle exception
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

	private void verify_Back_button() {

		// Verify the back button text
		String back_btn;
		try {
			back_btn = cropPage.getCancelbtn().getText();

			if (back_btn.isEmpty()) {
				ATUReports.add("Back button element is not visible", "Back", back_btn, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (back_btn.equals("Cancel")) {
					ATUReports.add("Back text is noticed in the screen ", "Back", back_btn, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Back is not observed in the screen ", back_btn, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verify_require_text() {
		// Verify the required button text
		String required;
		try {
			required = cropPage.getRequiretxt().getText();

			if (required.isEmpty()) {
				ATUReports.add("Required element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (required.equals("Required")) {
					ATUReports.add("Required text is noticed in the screen ", "Required", required, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Required text is not observed in the screen ", required, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
