package com.tricentis.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

		@FindBy(linkText = "Log out")
		private WebElement logoutLink;

		public WebElement getLogoutLink() {
			return logoutLink;
		}

		@FindBy(partialLinkText = "BOOKS")
		private WebElement booksLink;

		public WebElement getBooksLink() {
		    return booksLink;
		}
		
		@FindBy(partialLinkText = "COMPUTERS")
		private WebElement computersLink;

		public WebElement getComputersLink() {
		    return computersLink;
		}
		
		@FindBy(partialLinkText = "ELECTRONICS")
		private WebElement electronicsLink;

		public WebElement getElectronicsLink() {
		    return electronicsLink;
		}
		
		@FindBy(xpath = "//input[@value='Add to cart']")
		private List<WebElement> addToCartButtons;

		public List<WebElement> getAddToCartButtons() {
		    return addToCartButtons;
		}
		
		@FindBy(xpath = "//p[contains(text(), 'The product has been added')]")
		private WebElement confirmMessage;

		public WebElement getConfirmMessage() {
		    return confirmMessage;
		}	
		
		@FindBy(linkText = "Shopping cart")
		private WebElement shoppingCartLink;

		public WebElement getShoppingCartLink() {
			return shoppingCartLink;
		}
}
