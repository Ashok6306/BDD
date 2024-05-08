package org.page;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends Baseclass{
	public AddToCart() {
PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement cartItems;
	public WebElement getCartItems() {
		return cartItems;
	}
	
	
	@FindBy(xpath = "//span[text()='6']")
	private WebElement cartValidation;
	public WebElement getCartValidation() {
		return cartValidation;
	}
	@FindBy(xpath = "//button[text()='REMOVE']")
	private WebElement remove;
	public WebElement getRemove() {
		return remove;
	}
	@FindBy(xpath = "//span[text()='4']")
	private WebElement cartReValidation;
	public WebElement getCartReValidation() {
		return cartReValidation;
		
	}
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	private WebElement cartButton;
	public WebElement getCartButton() {
		return cartButton;
	}
	@FindBy(xpath = "//a[text()='CHECKOUT']")
	private WebElement checkout;
	public WebElement getCheckout() {
		return checkout;
	}
	//@FindBy
	//@FindBy
	
	
	
	
	
	
}
