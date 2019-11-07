package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MembersPage {

	public WebDriver driver;

	public MembersPage(WebDriver driver) {
		this.driver = driver;
	}

	By membersHeaderLink = By.xpath("//a[contains(text(),'Members')]");
	By membersList = By.xpath("//div[contains(@class,'infinite-scroll-component')]");
	By firstMember = By.xpath("//div[contains(@class,'infinite-scroll-component')]//div[1]//a[1]");
	By firstMemberSpan = By.xpath("//span[@class='wod-members__list-header']");
	By membersSearchBox = By.xpath("//input[@placeholder='All members']");
	By noMembersHeader = By.xpath("//h3[contains(text(),'No members yet')]");
	By createNewMember = By.xpath("//div[@class='wod-fab']//a");
	By memberNameField = By.xpath("//input[@id='name']");
	By memberSurnameField = By.xpath("//input[@id='surname']");
	By memberEmailField = By.xpath("//input[@id='username']");
	By memberSaveInfoButton = By.xpath("//button[@class='btn-block wod-button btn btn-primary']");
	By clubDropdown = By.xpath("//select[@id='clubID']");
	By groupDropdown = By.xpath("//select[@id='group']");
	By validDateFrom = By.xpath("//input[@id='dateFrom']");
	By validDateTo = By.xpath("//input[@id='dateTo']");
	By numberOfSessions = By.xpath("//input[@id='individualSessions']");
	By saveMembershipButton = By.xpath("//button[@class='btn-block wod-button btn btn-primary']");
	By membershipCard = By.xpath("//div[@class='wod-membership-card card']");
	By logoutButton = By.xpath("//a[@class='wod-portal__nav__logout nav-link']");

	public WebElement getMembersHeaderLink() { return  driver.findElement(membersHeaderLink); }

	public WebElement getMembersList() {
		return driver.findElement(membersList);
	}
	
	public WebElement getMembersSearchBox() {
		return driver.findElement(membersSearchBox);
	}

	public WebElement getNoMembersHeader() { return  driver.findElement(noMembersHeader); }

	public WebElement getCreateNewMember() {
		return driver.findElement(createNewMember);
	}
	
	public WebElement getMemberNameField() {
		return driver.findElement(memberNameField);
	}
	
	public WebElement getMemberSurnameField() {
		return driver.findElement(memberSurnameField);
	}
	
	public WebElement getNewMemberEmailField() {
		return driver.findElement(memberEmailField);
	}
	
	public WebElement getNewMemberSaveInfoButton() {
		return driver.findElement(memberSaveInfoButton);
	}
	
	public WebElement getClubDropdown() {
		return driver.findElement(clubDropdown);
	}
	
	public WebElement getGroupDropdown() {
		return driver.findElement(groupDropdown);
	}
	
	public WebElement getValidDateFrom() {
		return driver.findElement(validDateFrom);
	}
	
	public WebElement getValidDateTo() {
		return driver.findElement(validDateTo);
	}
	
	public WebElement getNumberOfSessions() {
		return driver.findElement(numberOfSessions);
	}
	
	public WebElement getSaveMembershipButton() {
		return driver.findElement(saveMembershipButton);
	}
	
	public WebElement getMembershipCard() {
		return driver.findElement(membershipCard);
	}

	public WebElement getFirstMember() {return  driver.findElement(firstMember); }

	public WebElement getFirstMemberSpan() { return  driver.findElement(firstMemberSpan); }

	public WebElement getLogoutButton() {return  driver.findElement(logoutButton);}

}
