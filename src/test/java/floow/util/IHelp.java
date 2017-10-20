package floow.util;

import org.openqa.selenium.By;

import floow.constants.CHelpTab;
import floow.constants.CHomeTab;

public interface IHelp {
	By helpTab=By.id(CHomeTab.helpTab);
	By preferencesButton=By.id(CHelpTab.listElementID);
	By pauseSlider=By.id(CHelpTab.pauseSlider);
	By pauseBtn=By.id(CHelpTab.pauseBtn);
	
}
