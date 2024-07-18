package com.tricentis.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = " //div[contains(text(),'Your Shopping Cart is empty!')] ")
	private WebElement emptyCartMessage;

	public WebElement getEmptyCartMessage() {
	    return emptyCartMessage;
	}
	
	@FindBy(xpath = "//input[@name='removefromcart']")
	private List<WebElement> removeFromCartsRB;

	public List<WebElement> getRemoveFromCartsRB() {
		return removeFromCartsRB;
	}
	
	@FindBy(name = "updatecart")
	private WebElement updateCartButton;

	public WebElement getUpdateCartButton() {
		return updateCartButton;
	}
	
}
