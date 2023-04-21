package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(linkText ="Log in")
	WebElement login;
	
	@FindBy(id="user")
	WebElement emailUser;
	
	@FindBy(id="login")
	WebElement continueLogin;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy(id="login-submit")
	WebElement loginUser;
	
	
	public void goTo() {
		driver.get("https://trello.com/home");
	}
	
	
	public Boards loginApplication(String user,String password) {
		login.click();
		emailUser.sendKeys(user);
		continueLogin.click();
		explicitWaitUntilVisibilityOfElements(userPassword);
		userPassword.sendKeys(password);
		loginUser.click();
		return new Boards(driver);
		
	}

}
