package abstractComponents;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import pageObjects.ListPage;



public class AbstractComponents {

	WebDriver driver;
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	@FindBy(xpath="//button[@data-testid='header-create-menu-button']")
	WebElement create;
	
	@FindBy(xpath="//section[@data-testid='header-create-menu-popover']")
	WebElement createPopOver;
	
	
	@FindBy(xpath="//button[@data-testid='header-create-board-button']")
	WebElement createBoardButton;
	
	@FindBy(xpath="//input[@data-testid='create-board-title-input']")
	WebElement boardName;
	
	
	@FindBy(xpath="//button[@data-testid='create-board-submit-button']")
	WebElement createBoard;
	
	@FindBy(xpath="//button[@data-testid='header-member-menu-button']")
	WebElement logoutTrello;
	

	@FindBy(xpath="//div[@data-testid=\"account-menu\"]")
	List<WebElement> logoutMenu;
	
	
	@FindBy(xpath="//button[@data-testid=\"account-menu-logout\"]")
	WebElement logout;
	
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void explicitWaitUntilVisibilityOfElements(WebElement findBy) {
		Wait explicit = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicit.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public Actions actionMouse(WebDriver driver) {
		return new Actions(driver);
	}
	
	
	public ListPage createBoards(String boardname) {
		 explicitWaitUntilVisibilityOfElements(create);
		 create.click();
		 explicitWaitUntilVisibilityOfElements(createBoardButton);
		 createBoardButton.click();
		 boardName.sendKeys(boardname);
		 createBoard.click();
		 return new ListPage(driver);
		 
	}
	
	
	
	public void logOutTrello() {
		logoutTrello.click();
		logout.click();
	}
	

	

	
}
