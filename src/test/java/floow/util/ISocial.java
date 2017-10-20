package floow.util;

import org.openqa.selenium.By;

import floow.constants.CHomeTab;
import floow.constants.CScoreTab;
import floow.constants.CSocialTab;

public interface ISocial {
	By socialTab = By.id(CHomeTab.socialTab);
	By friendsBtn = By.id(CSocialTab.friendsBtn);
	By addFriendBtn = By.id(CSocialTab.friendsAddBtn);
	By addFriendWithEmail = By.id(CSocialTab.friendsEmailBtn);
	By emailTextBox = By.id(CSocialTab.addFriendEmail);
	By nextBtn = By.id(CSocialTab.addFriendNext);
	By finishBtn = By.id(CSocialTab.addFriendFinish);
	By profileBtn = By.id(CSocialTab.profileBtn);
	By editProfileBtn = By.id(CSocialTab.editProfileBtn);
	By updateNameBox = By.id(CSocialTab.updateName);
	By saveName = By.id(CSocialTab.saveProfile);

	public boolean addFriendByEmail(String email);

	public boolean editProfileName(String newName);

}
