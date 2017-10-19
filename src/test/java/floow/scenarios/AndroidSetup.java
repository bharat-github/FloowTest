package floow.scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import floow.constants.CAppSetup;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author bharat anand
 *
 */

/**
 * @author basic setup for appium server. This creates a driver with given
 *         capabilities and help to interact with test code
 */
public class AndroidSetup {
	protected AndroidDriver driver;

	/**
	 * @throws MalformedURLException
	 */
	protected AndroidDriver prepareAndroidForAppium() throws MalformedURLException {

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
		driver = new AndroidDriver(new URL(CAppSetup.urlEndPoint), capabilities);
		return driver;
	}
}
