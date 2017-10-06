package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author bharat anand
 * Implements action on the login page
 */
public class LoginPage extends BasePage {
    By emailId = By.id("edit_text_email");
    By password = By.id("edit_text_password");
    By login_Button = By.id("btn_login");
    By existingUser_login = By.id("btn_mlogin");
    By alertTitle=By.id("alertTitle");
    By messageText=By.id("message");
    By button=By.id("button1");
    By createAccount=By.id("text_view_create_account");
    
    static String messageNotRegistered="User name/password not found. Are you registered?";
    static String alertError="something happened with alert";
    /**
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * @return
     */
    public LoginPage invalidLogin() {
    	waitForVisibilityOf(emailId);
    	driver.findElement(emailId).clear();
    	driver.findElement(emailId).sendKeys("someone@testvfloow.com");
    	driver.findElement(password).sendKeys("test123789708");
    	driver.findElement(login_Button).click();
    	driver.findElement(alertTitle).click();
    	return new LoginPage(driver);
    }
    
    /**
     * @return
     */
    public LoginPage notRegisteredLogin(){
    	//fail test if text doesnt match
    	Assert.assertEquals(driver.findElement(messageText).getText(), messageNotRegistered,alertError); 
    	driver.findElement(button).click();
    	return new LoginPage(driver);
    }
    
    public LoginPage validLogin() {
    	waitForVisibilityOf(emailId);
    	driver.findElement(emailId).clear();
    	driver.findElement(emailId).sendKeys("abrbharat2@gmail.com");
    	driver.findElement(password).sendKeys("qwerty1234");
    	driver.findElement(login_Button).click();
    	return new LoginPage(driver);
    }
    
    /**
     * 
     */
    public void createAccount(){
    	waitForVisibilityOf(createAccount);
    	driver.findElement(createAccount).click();
    }
}
