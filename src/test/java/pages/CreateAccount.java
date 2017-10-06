package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author bharatanand
 * class that implements new account creation on Accounts View
 */
public class CreateAccount extends BasePage{
	
	/*can move these constants to another file*/
	
	By firstName=By.id("edit_text_first_name");
	By surname=By.id("edit_text_surname");
	By dateofbirth=By.id("edit_text_date_of_birth");
	By email=By.id("edit_text_email");
	By postcode=By.id("edit_text_postcode");
	By company_name=By.id("edit_text_company_name");
	By password=By.id("edit_text_password");
	By comfirmPassword=By.id("edit_text_confirm_password");
	By prev=By.id("prev");
	By okButton=By.id("button1");
	By submitButton=By.id("button_register");
	
	public CreateAccount(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * inputs various fields and clicks submit
	 */
	public void useAccountDetails(){
		waitForVisibilityOf(firstName);
		driver.findElement(firstName).sendKeys("testMe");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(surname).sendKeys("surnameTest");
		driver.findElement(dateofbirth).click();
		/*
		 * trying to go as far as 20
		 */
		for(int iterator=0;iterator<20;iterator++){
			driver.findElement(prev).click();
		}
		driver.findElement(okButton).click();
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(email).sendKeys("testMe1123@gmail.com");
		driver.findElement(postcode).sendKeys("testMe");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(company_name).sendKeys("testMe");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(password).sendKeys("testMe12345");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(comfirmPassword).sendKeys("testMe12345");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(submitButton).click();
		
	}
	
	
}
