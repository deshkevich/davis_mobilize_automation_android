package functional_testcases;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.AuthorDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utility.ReadDeviceConfiguration;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parallel_Test {


	public static AndroidDriver iOSdriver ;
	public static AppiumDriver apdriver ;
	DesiredCapabilities capabilities ;
	public static AndroidDriver driver ;
	atu.testng.reports.utils.AuthorDetails ad= new AuthorDetails();
	private ReadDeviceConfiguration rdc ;

	public  Parallel_Test() throws MalformedURLException,IllegalStateException {

	}
	 


@BeforeTest
@Parameters("device")
public void searchTest(String device) throws MalformedURLException,InterruptedException{
	rdc = new ReadDeviceConfiguration();
	rdc.start();
	Thread.sleep(10000);

	try{

		if(driver==null){

			DesiredCapabilities capabilities = null;

			if(device.equalsIgnoreCase("mobile1")){

				//System.out.println("************1st ****************"+device);
				//Setting up the desired capabilities
				capabilities = new DesiredCapabilities();
				System.out.println("*************Mobile1**************");
				
				capabilities.setCapability("automationName", "Appium");
				capabilities.setCapability("appium-version", "1.0");
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("platformName", rdc.PlatformName);
				capabilities.setCapability("platformVersion", rdc.platformVersion);
				capabilities.setCapability("deviceName", rdc.DeviceName);
				capabilities.setCapability("bundleId",rdc.packagename);
				//capabilities.setCapability("app", rdc.Applicationpath);
				//capabilities.setCapability("udid", rdc.UDID);
				
				
				System.out.println("*************BundleID**************");

				apdriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				(new TestAppiumDriver()).setAppiumDriver(apdriver);
				//ATUReports.indexPageDescription = " Mobilize test results ";
				//ATUReports.currentRunDescription = "This is a test Run";
				ATUReports.setAuthorInfo("Appium User", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "Ver 1.0");
				driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
				//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				ATUReports.setWebDriver(driver);
				setAuthorInfoForReports();
				setIndexPageDescription();
			   // ATUReports.setAuthorInfoAtClassLevel("Automation Tester", Utils.getCurrentTime(),"2.0");

			}
			else if(device.equals("mobile2")){

				//Setting up the desired capabilities
				capabilities = new DesiredCapabilities();
				System.out.println("****************Mobile2****************");

				capabilities.setCapability("automationName", "Appium");
				capabilities.setCapability("appium-version", "1.0");
				capabilities.setCapability("platformName", rdc.PlatformName);
				capabilities.setCapability("platformVersion", rdc.platformVersion);
				capabilities.setCapability("deviceName", rdc.DeviceName);
				capabilities.setCapability("bundleId",rdc.packagename);
				//capabilities.setCapability("app", "/Users/sasiswetha/Desktop/HoN_masterlink/HoneyWell.MasterLink.iOS-1.0.ipa");
				capabilities.setCapability("udid", "0c52997db00728a1c1bf79e7b05061d680e2dd88");
				apdriver = new AndroidDriver(new URL("http://0.0.0.0:4728/wd/hub"), capabilities);
				(new TestAppiumDriver()).setAppiumDriver(apdriver);
				driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
				ATUReports.setWebDriver(driver);
				setIndexPageDescription();
				setAuthorInfoForReports();

			}
			//driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			//System.out.println("driver ******"+driver);
			//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			//driver.quit();

		}
	}catch(IllegalArgumentException e){
		e.printStackTrace();
	}

}

private void setIndexPageDescription() {

	ATUReports.indexPageDescription = "Mobilize Project Description <br/> <b>Can include Full set of HTML Tags</b>";
}

private void setAuthorInfoForReports() {
    ATUReports.currentRunDescription = rdc.DeviceName+""+rdc.PlatformName+""+rdc.platformVersion;

}

public AndroidDriver getInstance(){
	System.out.println(" in get instance method "+ driver);
	return (AndroidDriver) driver;
}

@AfterTest
public void finish(){

	//driver.quit();

}
}

//Below code for future reference

/*@DataProvider(parallel=true)
public Object[][] getData(){

	Object data[][] = new Object[2][1];

	data[0][0] = "mobile1";

	data[1][0] = "mobile2";

	return data;





}*/
