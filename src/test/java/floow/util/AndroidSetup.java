package floow.util;

import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import floow.constants.CAppSetup;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author bharat anand
 *
 */

/**
 *  basic setup for appium server. This creates a driver with given
 *         capabilities and help to interact with test code
 */
public class AndroidSetup {
	protected AndroidDriver driver;
	private static final Logger logger= Logger.getLogger(AndroidSetup.class); 
	
	protected AndroidDriver driverInit()  {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", CAppSetup.appiumVersion);
		capabilities.setCapability("platformName", CAppSetup.platformName);
		capabilities.setCapability("platformVersion", CAppSetup.platformVersion);
		capabilities.setCapability("deviceName", CAppSetup.deviceName);
		capabilities.setCapability("app", CAppSetup.app);
		// test app package name
		capabilities.setCapability("appPackage", CAppSetup.appPackage);
		// test app activity name
		capabilities.setCapability("appActivity", CAppSetup.appActivity);
		try {
			driver = new AndroidDriver(new URL(CAppSetup.urlEndPoint), capabilities);
		} catch (MalformedURLException e) {
			logger.error("mal formed URL endpoint for appium server");
		}
		return driver;
	}
}
