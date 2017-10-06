package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AcceptPage;
import pages.CreateAccount;
import pages.LoginPage;


/**
 * @author bharat anand
 * The test class with scenarios implemented
 */
public class AppiumTest extends AndroidSetup {
	LoginPage login;
	CreateAccount account;

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public void setUp() throws Exception {
		prepareAndroidForAppium();
	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * @throws InterruptedException
	 */
	@Test
	public void acceptTest() throws InterruptedException {
		new AcceptPage(driver).agree();
	}

	/**
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = { "acceptTest" })
	void notRegisteredtest() throws InterruptedException {
		login = new LoginPage(driver);
		login.invalidLogin();
		login.notRegisteredLogin();
	}
	
	@Test(dependsOnMethods = { "acceptTest", "notRegisteredtest" })
	public void registeredLogin() throws InterruptedException{
		login.validLogin();
	}
	
	/**
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = { "acceptTest","registeredLogin" })
	void registerNew() throws InterruptedException {
		account = new CreateAccount(driver);
		login.createAccount();
		account.useAccountDetails();
	}

}
