package floow.util;

import org.openqa.selenium.By;

import floow.constants.CHomeTab;
import floow.constants.CScoreTab;

public interface IScore {
	By scoreTabBtn = By.id(CHomeTab.scoreTab);
	By monthlyBtn = By.id(CScoreTab.monthlyBtn);
	By informationBtn = By.id(CScoreTab.informationBtn);
	By scoreDetailBtn=By.id(CScoreTab.componentScoreBtnId);
	public boolean changeScoreToMonthly();

	public boolean openScoreDetails();
}
