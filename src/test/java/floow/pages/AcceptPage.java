package floow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import floow.constants.CHomeTab;
import floow.util.ActionUtil;

/**
 * @author bharat anand
 * handles the very first page during first access to app
 */
public class AcceptPage extends ActionUtil {
	By userId = By.id(CHomeTab.agreeBtn );
	
	public AcceptPage(WebDriver driver) {
		super(driver);
		
	}
	public AcceptPage agree(){
		waitForVisibilityOf(userId);
		driver.findElement(userId).click();
		return new AcceptPage(driver);
	}
}
