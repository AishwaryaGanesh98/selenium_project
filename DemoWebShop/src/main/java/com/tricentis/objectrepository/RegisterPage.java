package com.tricentis.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-male")
	private WebElement maleGenderRB;

	public WebElement getMaleGenderRB() {
		return maleGenderRB;
	}
	
	@FindBy(id = "gender-female")
	private WebElement femaleGenderRB;

	public WebElement getFemaleGenderRB() {
		return femaleGenderRB;
	}

	@FindBy(id = "FirstName")
	private WebElement firstNameTF;

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	@FindBy(id = "LastName")
	private WebElement lastNameTF;

	public WebElement getLastNameTF() {
		return lastNameTF;
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

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmpasswordTF;

	public WebElement getConfirmPasswordTF() {
		return confirmpasswordTF;
	}

	@FindBy(id = "register-button")
	private WebElement registerButton;

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')] ")
	private WebElement confirmMessage;

	public WebElement getConfirmMessage() {
	    return confirmMessage;
	}
}
