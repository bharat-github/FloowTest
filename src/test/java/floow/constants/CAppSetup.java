package floow.constants;

/**
 * contains essential information for setting up the test framework. This
 * information is required for appium integration and can be updated, based on
 * the types of test devices used
 *
 */

public class CAppSetup {
	public static final String appiumVersion = "1.0";
	public static final String platformName = "Android";
	public static final String platformVersion = "7.0";
	public static final String deviceName = "Galaxy S7";
	public static final String app = "/Users/swatianand/Desktop/floow/flowdrive.apk";
	public static final String appPackage = "com.thefloow.flo";
	public static final String appActivity = "com.thefloow.flo.activity.LauncherActivity";
	public static final String urlEndPoint = "http://0.0.0.0:4723/wd/hub";
}
