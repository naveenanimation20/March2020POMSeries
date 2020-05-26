package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// 1. By locators -- OR
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// 2. create const.. of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);

	}

}
