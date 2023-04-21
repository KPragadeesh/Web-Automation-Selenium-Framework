package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class ListPage extends AbstractComponents {

	WebDriver driver;

	public ListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String listClass = ".js-list.list-wrapper";

	@FindBy(css = ".placeholder")
	WebElement addList;

	@FindBy(xpath = "//input[@name='name']")
	WebElement listName;

	@FindBy(xpath = "//input[@value='Add list']")
	WebElement addListButton;

	@FindBy(xpath = "//div[@id='board']")
	List<WebElement> arrayLists;

	@FindBy(css = ".js-add-a-card")
	WebElement addToCard;

	@FindBy(css = "textarea[placeholder='Enter a title for this card…']")
	WebElement cardName;

	@FindBy(css = "input[value='Add card']")
	WebElement addCard;

	@FindBy(xpath = "(//span[@class='list-card-title js-card-name'])[1]")
	WebElement sourceElement;

	@FindBy(xpath = "(//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable'])[2]")
	WebElement targetElement;

	public void createList(String listname) {
		explicitWaitUntilVisibilityOfElements(listName);
		listName.sendKeys(listname);
		addListButton.click();
	}

	public void addCardToSpecificList(String listName, String cardname) {
		List<WebElement> lists = driver.findElements(By.cssSelector(listClass));

		for (int i = 0; i < lists.size(); i++) {
			WebElement list = lists.get(i).findElement(By.xpath("//textarea[@aria-label='" + listName + "']"));
			if (list.getText().equalsIgnoreCase(listName)) {
				addToCard.click();
				cardName.sendKeys(cardname);
				addCard.click();
			}
		}
	}
	
	  public void dragCardtoAnotherList() { 
		  Actions act = new Actions(driver);
		  explicitWaitUntilVisibilityOfElements(targetElement);
		  act.dragAndDrop(sourceElement, targetElement).build().perform();
	  
	  }
	  
	  
	  
	  
	  public void getCoordinates() { 
		 Rectangle draggedCard=targetElement.getRect();
	  System.out.println("X Coordinate of dragged Card : "+ draggedCard.getX());
	  System.out.println("Y Coordinate of dragged Card : "+ draggedCard.getY()); }
	 

}
