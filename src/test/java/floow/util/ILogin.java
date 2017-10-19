package floow.util;

import org.openqa.selenium.By;

import floow.constants.CHomeTab;
import floow.constants.CLogin;

public interface ILogin {
	By emailId = By.id(CLogin.emailId);
	By password = By.id(CLogin.password);
	By login_Button = By.id(CLogin.login_Button);
	By existingUser_login = By.id(CLogin.existingUser_login);
	By alertTitle = By.id(CLogin.alertTitle);
	By messageText = By.id(CLogin.messageText);
	By button = By.id(CLogin.button);
	By createAccount = By.id(CLogin.createAccount);
	
	By firstName=By.id(CLogin.firstName);
	By surname=By.id(CLogin.surname);
	By dateofbirth=By.id(CLogin.dateOfBirth);
	By email=By.id(CLogin.emailId);
	By postcode=By.id(CLogin.postcode);
	By companyName=By.id(CLogin.companyName);
	By comfirmPassword=By.id(CLogin.confirmPassword);
	By prev=By.id(CLogin.prev);
	By okButton=By.id(CLogin.okButton);
	By submitButton=By.id(CLogin.submitButton);
	
	By userId = By.id(CHomeTab.agreeBtn );
	By loginAfterRegister=By.id(CLogin.loginAfterResgister);
	By closeButton=By.id(CLogin.close);

	public void invalidLogin();

	public String notRegisteredLogin();

	public void validLogin();

	public void createAccount();
	
	public void registerNewAccount();
}
