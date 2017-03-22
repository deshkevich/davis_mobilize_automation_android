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

public class FrostPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public FrostPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructo " + driver);
	}

	private static MobileElement element = null;

	By cancelbtn = By.id("com.davis.mobilize:id/back_icon");
	By next_nxt_save_btn =By.id("com.davis.mobilize:id/nextButton");
	By editfrost = By.id("com.davis.mobilize:id/title");
	By bodytxt = By.id("com.davis.mobilize:id/sensor_input_text");
	By titletxt = By.id("com.davis.mobilize:id/sensor_input");
	By devicestxt = By.id("com.davis.mobilize:id/device");
	By sensortxt = By.id("com.davis.mobilize:id/sensor");
	By pageindicator = By.className("android.widget.LinearLayout");
	By devicedropdown = By.id("com.davis.mobilize:id/name");
	By sensordropdown =By.name("Davis GroWeather, FARS"); //By.id("com.davis.mobilize:id/name");	
	By frostTempUnitsF=By.id("com.davis.mobilize:id/tv_temp_units");
	By frostPreferences=By.className("android.widget.TextView");
	By frostTempTextbox=By.id("com.davis.mobilize:id/et_temp");
	By earlyFrostTemptxtbx=By.id("com.davis.mobilize:id/et_early_temp");
	By optionalSlider=By.id("com.davis.mobilize:id/sw_early_temp_alert");
	By completeSaveBtn=By.id("com.davis.mobilize:id/saveButton");
	By earlyFrostTempSlider=By.id("com.davis.mobilize:id/sb_early_temp");	
	By frostFText=By.name("°F");//taking name because all titles have same id:
	By frostRadioButton=By.id("com.davis.mobilize:id/first_radio_btn");//com.davis.mobilize:id/first_radio_btn///com.davis.mobilize:id/radio_deg_f
	By tempCText=By.name("°C");//taking name because all text's have same id:
	By tempCRadioButton=By.id("com.davis.mobilize:id/second_radio_btn");
	By tempList=By.name("Temperature");//taking name because all titles have same id:
	By preferencesList=By.id("com.davis.mobilize:id/recycler_view_preferences"); //com.davis.mobilize:id/recycler_view_preferences	-com.davis.mobilize:id/recycler_view_common
	By rainEtUnits=By.name("Rain & Et");
	By inchesText=By.name("in");
	By mmText=By.name("mm");
	By presureUnits=By.name(" Pressure");
	By windSpeedUnits=By.name("Wind Speed");
	By mphText=By.name("mph");
	By knotsText=By.name("knots");
    By TempSlier=By.id("com.davis.mobilize:id/seek_bar");
    By optionalSliderSwipe=By.id("com.davis.mobilize:id/sw_early_temp_alert");
    By plusIcon=By.id("com.davis.mobilize:id/tv_plus");
    By minusIcon=By.id("com.davis.mobilize:id/tv_minus");
    By barometricText=By.name("Barometric Pressure");
    By flowTtxt=By.name("Flow");
    By frostDownArrowButton=By.id("com.davis.mobilize:id/showDetails");
    By viewDetaisInfromationInReport=By.id("com.davis.mobilize:id/recycler_frost_details");
    By cropDownArrowButton=By.id("com.davis.mobilize:id/cropDownArrow");
    By croViewReportInfromation=By.id("com.davis.mobilize:id/recycler_crop_details");
    By irrigationDownArrow=By.id("com.davis.mobilize:id/irrigationDropDown");
    By irrigatinViewReportInformation=By.id("com.davis.mobilize:id/recycler_irrigation_details");
    By weatherDownArrow=By.id("com.davis.mobilize:id/weatherDownArrow");
    By weatherViewReportDetailsInformation=By.id("com.davis.mobilize:id/recycler_weather_details");
    By TimeLablePrefrences=By.id("com.davis.mobilize:id/heading");
    By timeFirstRadioButtonText=By.id("com.davis.mobilize:id/first_radio_text");////android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]
    By timeSecondRadioButton=By.id("com.davis.mobilize:id/second_radio_btn");////android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]/android.widget.TextView[4]	
    
    
    public MobileElement gettimeSecondRadioButton() throws InterruptedException {
      	try {
      		element = (MobileElement) ((new WebDriverWait(driver, 10))
      				.until(ExpectedConditions.presenceOfElementLocated(timeSecondRadioButton)));
      	} catch (NoSuchElementException e) {
      		ATUReports.add("timeSecondRadioButton Button element  is not found in the screen ", LogAs.WARNING,
      				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
      		return null;
      	} catch (TimeoutException te) {
      		ATUReports.add("Time out :timeSecondRadioButton element is not found in the screen", LogAs.WARNING,
      				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
      		return null;
      	}
      	return element;
      }
    
    public MobileElement gettimeFirstRadioButtonText() throws InterruptedException {
      	try {
      		element = (MobileElement) ((new WebDriverWait(driver, 10))
      				.until(ExpectedConditions.presenceOfElementLocated(timeFirstRadioButtonText)));
      	} catch (NoSuchElementException e) {
      		ATUReports.add("timeFirstRadioButtons Button element  is not found in the screen ", LogAs.WARNING,
      				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
      		return null;
      	} catch (TimeoutException te) {
      		ATUReports.add("Time out :timeFirstRadioButtons element is not found in the screen", LogAs.WARNING,
      				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
      		return null;
      	}
      	return element;
      }
    
  public MobileElement getTimeLablePrefrences() throws InterruptedException {
  	try {
  		element = (MobileElement) ((new WebDriverWait(driver, 10))
  				.until(ExpectedConditions.presenceOfElementLocated(TimeLablePrefrences)));
  	} catch (NoSuchElementException e) {
  		ATUReports.add("TimeLablePrefrences Button element  is not found in the screen ", LogAs.WARNING,
  				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  		return null;
  	} catch (TimeoutException te) {
  		ATUReports.add("Time out :TimeLablePrefrences element is not found in the screen", LogAs.WARNING,
  				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  		return null;
  	}
  	return element;
  }
    
    public MobileElement getweatherViewReportDetailsInformation() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(weatherViewReportDetailsInformation)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("weatherViewReportDetailsInformation Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :weatherViewReportDetailsInformation element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getweatherDownArrow() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(weatherDownArrow)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("weatherDownArrow Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :weatherDownArrow element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getirrigatinViewReportInformation() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(irrigatinViewReportInformation)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("irrigatinViewReportInformation Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :irrigatinViewReportInformation element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    public MobileElement getirrigationDownArrow() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(irrigationDownArrow)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("irrigationDownArrow Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :irrigationDownArrow element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getcroViewReportInfromation() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(croViewReportInfromation)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("croViewReportInfromation Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :croViewReportInfromation element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    public MobileElement getcropDownArrowButton() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(cropDownArrowButton)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("cropDownArrowButton Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :cropDownArrowButton element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getviewDetaisInfromationInReport() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(viewDetaisInfromationInReport)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("viewDetaisInfromationInReport Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :viewDetaisInfromationInReport element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getfrostDownArrowButton() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(frostDownArrowButton)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("frostDownArrowButton Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :frostDownArrowButton element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getflowTtxt() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(flowTtxt)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("flowTtxt Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :flowTtxt element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    public MobileElement getbarometricText() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(barometricText)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("barometricText Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :barometricText element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getminusIcon() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(minusIcon)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("minusIcon Button element  is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Time out :minusIcon element is not found in the screen", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    

public MobileElement getplusIcon() throws InterruptedException {
	try {
		element = (MobileElement) ((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(plusIcon)));
	} catch (NoSuchElementException e) {
		ATUReports.add("plusIcon Button element  is not found in the screen ", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	} catch (TimeoutException te) {
		ATUReports.add("Time out :plusIcon element is not found in the screen", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	}
	return element;
}


public MobileElement getoptionalSliderSwipe() throws InterruptedException {
	try {
		element = (MobileElement) ((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(optionalSliderSwipe)));
	} catch (NoSuchElementException e) {
		ATUReports.add("optionalSliderSwipe Button element  is not found in the screen ", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	} catch (TimeoutException te) {
		ATUReports.add("Time out :optionalSliderSwipe element is not found in the screen", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	}
	return element;
}


public MobileElement getTempSlier() throws InterruptedException {
	
	
	
	try {
		element = (MobileElement) ((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(TempSlier)));
	} catch (NoSuchElementException e) {
		ATUReports.add("TempSlier Button element  is not found in the screen ", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	} catch (TimeoutException te) {
		ATUReports.add("Time out :TempSlier element is not found in the screen", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	}
	return element;
}


	
	
	public MobileElement getwindSpeedUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(windSpeedUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("windSpeedUnits Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :windSpeedUnits element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getknotsText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(knotsText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("knotsText Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :knotsText element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getmphText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(mphText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("mphText Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :mphText element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getpresureUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(presureUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("presureUnits Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :presureUnits element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getmmText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(mmText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("mmText Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :mmText element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getinchesText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(inchesText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("inchesText Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :inchesText element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getrainEtUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(rainEtUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("rainEtTitle Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :rainEtTitle element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public MobileElement getearlyFrostTempSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyFrostTempSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyFrostTempSlider Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :earlyFrostTempSlider element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getcompleteSaveBtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(completeSaveBtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("completeSaveBtn Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :completeSaveBtn element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getoptionalSliderl() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(optionalSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("optional Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :optional element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getpreferencesList() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(preferencesList)));
		} catch (NoSuchElementException e) {
			ATUReports.add("preferencesList Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :preferencesList element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement gettempList() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(tempList)));
		} catch (NoSuchElementException e) {
			ATUReports.add("tempList Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :tempList element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement gettempCRadioButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(tempCRadioButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("tempCRadioButton Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :tempCRadioButton element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement gettempCText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(tempCText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("tempCText Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :tempCText element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getfrostRadioButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostRadioButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostRadioButton Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :frostRadioButton element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getfrostFText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostFText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostFText Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :frostFText Button element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	 
	 public MobileElement getearlyFrostTemptxtbx() throws InterruptedException {
			try {
				element = (MobileElement) ((new WebDriverWait(driver, 10))
						.until(ExpectedConditions.presenceOfElementLocated(earlyFrostTemptxtbx)));
			} catch (NoSuchElementException e) {
				ATUReports.add("fostEarlyFrostTemptxtbx Button element  is not found in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			} catch (TimeoutException te) {
				ATUReports.add("Time out :fostEarlyFrostTemptxtbx Button element is not found in the screen", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}
			return element;
		}
	
	public MobileElement getfrostTempTextbox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostTempTextbox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostTempTextbox Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :frostTempTextbox Button element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getfrostPreferences() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostPreferences)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostPreferences Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Time out :frostPreferences Button element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getfrostTempUnitsF() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostTempUnitsF)));
		} catch (NoSuchElementException e) {
			ATUReports.add("FrostTempUnitsF Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add(" Time out :FrostTempUnitsF Button element is not found in the screen", LogAs.WARNING,
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
			ATUReports.add("Cancel Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Cancel Button element is not found in the screen", LogAs.WARNING,
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
			ATUReports.add("Next Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Next Button element is not found in the screen", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getEditfrost() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(editfrost)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Editfrost element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Editfrost element is not found in the screen", LogAs.WARNING,
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
			ATUReports.add("Frost Body Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Frost Body Text  is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Title Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Title Text is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getDevicestxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(devicestxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Devices Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Devices Text is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Sensor Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sensor Text is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Pageindicator not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Pageindicator is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Device dropdown not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Device dropdown is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Sensor dropdown not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sensor dropdown is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
