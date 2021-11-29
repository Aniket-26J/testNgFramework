package g.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import g.base.InstaBase;

public class InstaPage extends InstaBase {
		
	public InstaPage() {
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]/div[1]/div/label/input" ) WebElement Username;
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]/div[2]/div/label/input" ) WebElement Password;
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]/div[3]/button/div" ) WebElement LoginButton;
	
	public String validateTitle() {
		return driver.getTitle();
	}
	public DBP invalidLogin(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
		return new DBP();
	}
	
}