package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	protected void prepareAndroidForAppium() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("deviceName", "Galaxy S7");
		capabilities.setCapability("app", "/Users/swatianand/Desktop/floow/flowdrive.apk");
		// test app package name
		capabilities.setCapability("appPackage", "com.thefloow.flo");
		// test app activity name
		capabilities.setCapability("appActivity", "com.thefloow.flo.activity.LauncherActivity");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}
}
