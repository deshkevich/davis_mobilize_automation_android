package Pages;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CropPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public CropPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructo " + driver);
	}

	private static MobileElement element = null;
	By verticalHelp=By.id("com.davis.mobilize:id/vertical_question");
	By singleSignHelp=By.id("com.davis.mobilize:id/single_sine_question");
	By integrationHelp=By.id("com.davis.mobilize:id/integration_question");
	By upthreshold = By.id("com.davis.mobilize:id/upperThreshold");
	By setcroptarget = By.id("com.davis.mobilize:id/target");
    By alertTitle=By.id("android:id/alertTitle");
    By alertBody=By.id("android:id/message");
    By alertHelpTitle=By.id("android:id/alertTitle");
    
	By cancelbtn = By.id("com.davis.mobilize:id/back_icon");
	By next_nxt_save_btn = By.id("com.davis.mobilize:id/nextButton");
	By editcorp = By.id("com.davis.mobilize:id/title");
	By requiretxt = By.id("com.davis.mobilize:id/optionalText");
	By cropandVariety=By.id("com.davis.mobilize:id/crop_and_variety_text");
	By varietyBody=By.id("com.davis.mobilize:id/crop_and_variety_text_desc");
	By bodytxt = By.id("com.davis.mobilize:id/sensor_input_text");
	By gddTitle=By.id("com.davis.mobilize:id/gdd");
	By gddCaption=By.id("com.davis.mobilize:id/gdd_desc");		
	By titletxt = By.id("com.davis.mobilize:id/sensor_input");
	By togglebtn = By.id("com.davis.mobilize:id/toggleButton");
	By devicestxt = By.id("com.davis.mobilize:id/device");
	By sensortxt = By.id("com.davis.mobilize:id/sensor");
	By pageindicator = By.className("android.widget.LinearLayout");
	By devicedropdown = By.id("com.davis.mobilize:id/name");
	By sensordropdown = By.name("Davis GroWeather, FARS");
	By optionaltxt = By.name("optional");
	By cropText = By.id("com.davis.mobilize:id/genus");
	By varietyText = By.id("com.davis.mobilize:id/species");
	By croptxtfld = By.id("com.davis.mobilize:id/genusText");
	By varietytxtfld = By.id("com.davis.mobilize:id/speciesText");
	By GDDstartdate = By.id("com.davis.mobilize:id/gddStartDate");
	By GDDtxtfield = By.id("com.davis.mobilize:id/calendarEntry");
	By datebtn = By.id("com.davis.mobilize:id/tv_gdd_calender");
	By dateTab=By.id("com.davis.mobilize:id/tv_chill_start_date");
	By firstCheckBoxBtnText = By.id("com.davis.mobilize:id/firstTickText");
	By secondCheckBoxBtnText = By.id("com.davis.mobilize:id/secondTickText");
	By firstCheckButton = By.id("com.davis.mobilize:id/firstTick");
	By secondCheckButton = By.id("com.davis.mobilize:id/secondTick");
	By setthresholdtxt = By.id("com.davis.mobilize:id/averagewindtext");
	By f = By.id("com.davis.mobilize:id/tv_lower_temp_units");
	By thresholdtxtfld = By.id("com.davis.mobilize:id/lowThreshold");
	By thresoldswipe = By.id("com.davis.mobilize:id/sb_lowThreshold");
	By thirdCheckBoxButtonText = By.id("com.davis.mobilize:id/thirdTickText");
	By thirdCheckBoxButton = By.id("com.davis.mobilize:id/thirdTick");
	By savebtntxt = By.id("com.davis.mobilize:id/saveButton");
	By alertHelpText=By.id("com.davis.mobilize:id/alert_message");
	By alertHelpOk=By.id("android:id/button1");
	By hozontalHelp=By.id("com.davis.mobilize:id/horizontal_question");
	By IntermediateHelp=By.id("com.davis.mobilize:id/intermediate_question");
	By dynamicHelp=By.id("com.davis.mobilize:id/chilling_portion_question");
	By chillingHelp=By.id("com.davis.mobilize:id/chilling_hour_question");
	By utahChillingHelp=By.id("com.davis.mobilize:id/chilling_unit_question");
	By cropTempUnits=By.id("com.davis.mobilize:id/tv_lower_temp_units");
	By chillingtargetTextBx=By.id("com.davis.mobilize:id/et_target_value");
	By chillingTargetUnits=By.id("com.davis.mobilize:id/measure");
	By cropVerietyOptinal=By.id("com.davis.mobilize:id/toggle_crop");
	By cropGddOptional=By.id("com.davis.mobilize:id/toggle_gdd");
	By cropLowerThresholdSlider=By.id("com.davis.mobilize:id/sb_lowThreshold");
	By cropUpperOptional=By.id("com.davis.mobilize:id/upper_threshold_alert");
	By cropUpperTempThresholdSlider=By.id("com.davis.mobilize:id/sb_upper_threshold");
	By cropChillstartDateOptional=By.id("com.davis.mobilize:id/tb_chill_start_date");
	By cropChillingTarget=By.id("com.davis.mobilize:id/sb_chill_target");
	By cropAlertTitle=By.id("android:id/alertTitle");
	By cropGoBack=By.id("android:id/button2");
	By cropContinue=By.id("android:id/button1");
	
	
	
	public MobileElement getalertHelpTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(alertHelpTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("alertHelpTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :alertHelpTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropContinue() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropContinue)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropContinue element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropContinue element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropGoBack() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropGoBack)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropGoBack element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropGoBack element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropAlertTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropAlertTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropAlertTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropAlertTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropChillingTarget() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropChillingTarget)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropChillingTarget element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropChillingTarget element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropChillstartDateOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropChillstartDateOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropChillstartDateOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropChillstartDateOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropUpperTempThresholdSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropUpperTempThresholdSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropUpperTempThresholdSlider element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropUpperTempThresholdSlider element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropUpperOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropUpperOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropUpperOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropUpperOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getcropLowerThresholdSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropLowerThresholdSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropLowerThresholdSlider element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropLowerThresholdSlider element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropGddOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropGddOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropGddOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropGddOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropVerietyOptinal() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropVerietyOptinal)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropVerietyOptinal element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropVerietyOptinal element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getchillingTargetUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(chillingTargetUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("chillingTargetUnits caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :chillingTargetUnits caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getchillingtargetTextBx() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(chillingtargetTextBx)));
		} catch (NoSuchElementException e) {
			ATUReports.add("chillingtargetTextBx caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :chillingtargetTextBx caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getcropTempUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropTempUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropTempUnits caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropTempUnits caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public MobileElement getgddTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(gddTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("gddTitle caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :gddTitle caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getgddCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(gddCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("gddCaption caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :gddCaption caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getvarietyBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(varietyBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropandVariety caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropandVariety caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	//cropandVariety
	public MobileElement getcropandVariety() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropandVariety)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropandVariety element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :cropandVariety  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public MobileElement getutahChillingHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(utahChillingHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("utahChillingHelp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :utahChillingHelp  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getchillingHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(chillingHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("chillingHelp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :chillingHelp  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getdynamicHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dynamicHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("dynamicHelp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :dynamicHelp  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getIntermediateHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(IntermediateHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("IntermediateHelp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :IntermediateHelp  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
			
	
	
			
		public MobileElement gethozontalHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(hozontalHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("hozontalHelp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :hozontalHelp element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
			
			
	
	public MobileElement getverticalHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(verticalHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("verticalHelp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :verticalHelp element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getalertHelpOk() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(alertHelpOk)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Help alert Ok element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Help alert Ok element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getalertHelpText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(alertHelpText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Help alert message Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Help alert message Text  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getsingleSignHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(singleSignHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("singleSignHelp tab element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :singleSignHelp tab element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getintegrationHelp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(integrationHelp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("integrationHelp tab element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :integrationHelp tab element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getdateTab() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dateTab)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Date tab element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Date tab element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getupthreshold() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(upthreshold)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Upper threshold element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Upper threshold target  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

		
	
	public MobileElement gesetcroptarget() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(setcroptarget)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Set crop target element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Set crop target  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getalertBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(alertBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Alert Body element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Alert Body  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	
	public MobileElement getalertTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(alertTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Alert Title element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Alert Title  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public MobileElement getCancelbtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cancelbtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Cancel Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Cancel Button  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getNext_nxt_save_btn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(next_nxt_save_btn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Next Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Next Button  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getEditcorp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(editcorp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Editcorp element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Editcorp element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getRequiretxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(requiretxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Require text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Require text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getBodytxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(bodytxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Body text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Body text is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getTitletxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(titletxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Title text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Title text is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getTogglebtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(togglebtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Toggle Button  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Toggle Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getdDevicestxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(devicestxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Devices text  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Devices text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSensortxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(sensortxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sensor text  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sensor text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getPageindicator() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(pageindicator)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Pageindicator element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Pageindicator element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getDevicedropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(devicedropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Device dropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Device dropdown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSensordropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(sensordropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sensor dropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sensor dropdown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getOptionaltxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(optionaltxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Optional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Optional Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getCropText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Crop Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Crop Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getVarietyText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(varietyText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Variety Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Variety Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getCroptxtfld() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(croptxtfld)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Crop Text field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Crop Text field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getVarietytxtfld() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(varietytxtfld)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Variety Text field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Variety Text field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getGDDstartdate() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(GDDstartdate)));
		} catch (NoSuchElementException e) {
			ATUReports.add("GDD tart date field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :GDD tart date field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getGDDtxtfield() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(GDDtxtfield)));
		} catch (NoSuchElementException e) {
			ATUReports.add("GDD enter text field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :GDD enter text field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getDatebtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(datebtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Date picker element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Date picker element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getFirstCheckBoxBtnText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(firstCheckBoxBtnText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("First Check Box Button Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :First Check Box Button Text is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSecondCheckBoxBtnText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(secondCheckBoxBtnText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Second Check Box Button Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Second Check Box Button Text is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getFirstCheckButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(firstCheckButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("First Check Box Button 	element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :First Check Box Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSecondCheckButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(secondCheckButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Second Check Box Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Second Check Box Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSetthresholdtxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(setthresholdtxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Set threshold text element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Set threshold text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getF() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(f)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Temparature units 'F' element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Temparature units 'F' element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getthresholdtxtfld() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thresholdtxtfld)));
		} catch (NoSuchElementException e) {
			ATUReports.add("threshold text element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :threshold text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getThresoldswipe() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thresoldswipe)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Thresold swipe element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Thresold swipe element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getThirdCheckBoxButtonText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thirdCheckBoxButtonText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Third Check Box Button Text element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Third Check Box Button Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getThirdCheckBoxButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thirdCheckBoxButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Third Check Box Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Third Check Box Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSavebtntxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(savebtntxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Save Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Save Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
}

//By gddTitle=By.id("com.davis.mobilize:id/gdd");
	//By gddCaption=By.id("com.davis.mobilize:id/gdd_desc");
	// By chillstartdate = By.name("Chill Start date:");
		// By setcroptarget = By.name("Set crop target:");
