package com.tricentis.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

		@FindBy(id = "Email")
		private WebElement emailTF;

		public WebElement getEmailTF() {
			return emailTF;
		}

		@FindBy(id = "Password")
		private WebElement passwordTF;

		public WebElement getPasswordTF() {
			return passwordTF;
		}

		@FindBy(xpath = "//input[@value = 'Log in']")
		private WebElement loginButton;

		public WebElement getLoginButton() {
			return loginButton;
		}
}
