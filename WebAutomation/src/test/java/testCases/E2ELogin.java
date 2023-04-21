package testCases;

import org.testng.annotations.Test;

import components.Components;
import pageObjects.Boards;
import pageObjects.ListPage;

public class E2ELogin extends Components {

	
	@Test
	public void e2eLoginTrello() {
		Boards boards = homePage.loginApplication("your email", "your password");
		ListPage listPage = boards.createBoards("testBoard1");
		listPage.createList("List A");
		listPage.addCardToSpecificList("List A", "Card A_1");
		listPage.createList("List B");
		listPage.dragCardtoAnotherList();
		listPage.getCoordinates();
		listPage.logOutTrello();
	}
	
	
	
	
	
}
