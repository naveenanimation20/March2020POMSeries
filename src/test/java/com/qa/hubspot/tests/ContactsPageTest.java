package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class ContactsPageTest extends BaseTest {
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void contactsSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getConatctsPageTitle();
		System.out.println("contacts page title is : " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void createContactTest() {
		contactsPage.createContact("rahul@gmail.com", "Rahul", "Malhotra", "SDET Manager");
	}

}
