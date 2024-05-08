package org.page;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends Baseclass {
	public Checkout() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[text()='Checkout: Your Information']")
	private WebElement checkOutPageValidation;
	public WebElement getCheckOutPageValidation() {
		return checkOutPageValidation;
	}
@FindBy(id = "first-name")
private WebElement firstName;
public WebElement getFirstName() {
	return firstName;
}
@FindBy(id = "last-name")
private WebElement lastname;
public WebElement getLasrtname() {
	return lastname;
}
@FindBy(id = "postal-code")
private WebElement postalcode;
public WebElement getPostalcode() {
	return postalcode;
}
@FindBy(xpath = "//input[@value='CONTINUE']")
private WebElement continuePayment;
public WebElement getContinuePayment() {
	return continuePayment;
}
@FindBy(xpath = "//div[text()='Checkout: Overview']")
private WebElement checkoutOverveiwValidation;
public WebElement getCheckoutOverveiwValidation() {
	return checkoutOverveiwValidation;
}
@FindBy(xpath = "//a[@class='btn_action cart_button']")
private WebElement finish;
public WebElement getFinish() {
	return finish;
}
@FindBy(xpath = "//div[text()='Finish']")
private WebElement finishValidation;
public WebElement getFinishValidation() {
	return finishValidation;
}


}
