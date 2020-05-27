package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.private-page__title");
	By accountName = By.cssSelector("span.account-name ");

	By primaryContactLink = By.id("nav-primary-contacts-branch");
	By secondaryContactLink = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageHeaderText() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getLoggedInUser() {
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}

	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}

	private void clickOnContacts() {
		elementUtil.doClick(primaryContactLink);
		elementUtil.doClick(secondaryContactLink);
	}

}
