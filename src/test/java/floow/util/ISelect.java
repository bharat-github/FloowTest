package floow.util;

import org.openqa.selenium.By;

import floow.constants.CHelpTab;
import floow.constants.CHomeTab;
import floow.constants.CLogin;

public interface ISelect {
	public boolean startJourney();
	public boolean sendfeedback();
	public boolean declareEmergency();
	
	By feedbackBtn = By.id(CHomeTab.feedbackButton);
	By dropDownList=By.id(CHomeTab.dropdown);
	By editBox=By.id(CHomeTab.textBoxID);
	By selectType=By.id(CHomeTab.selectCategoryID);
	By sendBtn=By.id(CHomeTab.sendButton);
	By sendOptions=By.id(CHomeTab.sendOptionsClass);
	By sendEmail=By.id(CHelpTab.sendGmailBtn);
	By typeOptions=By.className(CHomeTab.sendTypeClass);
	By breakDown=By.id(CHomeTab.breakDownButton);
	By accident=By.id(CHomeTab.accidentButton);
	By callNow=By.id(CHomeTab.callNow);
	By emergency=By.id(CHomeTab.emergencyButton);
}
