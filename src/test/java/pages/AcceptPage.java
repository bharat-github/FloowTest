package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author bharat anand
 * handles the very first page during first access to app
 */
public class AcceptPage extends BasePage {
	By userId = By.id("btn_agree");
	
	public AcceptPage(WebDriver driver) {
		super(driver);
		
	}
	public AcceptPage agree(){
		waitForVisibilityOf(userId);
		driver.findElement(userId).click();
		return new AcceptPage(driver);
	}
}
