package org.step;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;

import org.apache.commons.codec.digest.HmacUtils;
import org.base.Baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.page.AddToCart;
import org.page.Checkout;
import org.page.Logout;
import org.page.Pageclass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefinition extends Baseclass{

	public static Baseclass base = new Baseclass();
	public static Pageclass page;
	public static org.page.AddToCart add;
	public static org.page.Checkout check;
	public static org.page.Logout logout;

	
  
@Given("User launches website")
public void user_launches_website() {
	  base.getDriver("Edge");
	  base.getUrl("https://www.saucedemo.com/v1/");
	  base.winMax();
	
}
@When("User login and validates login")
public void user_login_and_validates_login() {
	 page = new Pageclass();
	   page.getUserName().sendKeys("standard_user");
	  page.getPassword().sendKeys("secret_sauce");
	  page.getLoginbuttion().click();
	  WebElement loginValidation = page.getLoginValidation();
	 String  actual = loginValidation.getText();
	 String expected = "Products";
	  Assert.assertEquals(actual, expected, "Not Logged in");
	  

}
@When("User adds products to cart and validate the cart")
public void user_adds_products_to_cart_and_validate_the_cart() {
	add = new AddToCart();
	try {
	for (int i = 0; i < 6; i++) {
		add.getCartItems().click();	
	}
	WebElement cartValidation = add.getCartValidation();
	String actual1 = cartValidation.getText();
	String expected1 = "6";
	Assert.assertEquals(actual1, expected1, "Not added to cart");
	} catch (Exception e) {	
	}
	  
}
@When("User removes two items and re-validates the cart")
public void user_removes_two_items_and_re_validates_the_cart() {
	add = new AddToCart();
	try {
		for (int i = 0; i < 2; i++) {
		add.getRemove().click();
		}
		WebElement cartReValidation = add.getCartReValidation();
	String actual2 = cartReValidation.getText();
	String expected2 = "4" ;
	Assert.assertEquals(actual2, expected2, "cart re-validation unsucess");
	add.getCartButton().click();
	add.getCheckout().click();
	} catch (Exception e) {
	}
	
}
@When("User Checks out and validate the checkout")
public void user_checks_out_and_validate_the_checkout() {
	check = new Checkout();
	try {
     		
		String actual3 = check.getCheckOutPageValidation().getText();
		String expected3 = "Checkout: Your Information";
		Assert.assertEquals(actual3, expected3, "Not checked out");
		System.out.println("checkOutPageValidation sucess");
		Thread.sleep(2000);
		check.getFirstName().sendKeys("Ashok");
		check.getLasrtname().sendKeys("Kumar");
		check.getPostalcode().sendKeys("651659");
		check.getContinuePayment().click();
		WebElement checkoutValidation = check.getCheckoutOverveiwValidation();
		String expected6 = "Checkout: Overview";
		String actual6 = checkoutValidation.getText();
		Assert.assertEquals(actual6, expected6, "checkOut Overveiw  Validation unsucess");
		//System.out.println("checkOut Overveiw  Validation sucess");
		check.getFinish().click();
		WebElement finishValidation = check.getFinishValidation();
		String actual5 = finishValidation.getText();
		String expected5 = "Finish";
		Assert.assertEquals(actual5, expected5, "Finish validation unsuccessfull");
		//System.out.println("Finish validation successfull");
	} catch (Exception e) { 
	}
	
}
@Then("user logout and validate logout")
public void user_logout_and_validate_logout() {
	try {
		logout = new Logout();
		page = new Pageclass();
		logout.getOpenMenu().click();
		logout.getLogout().click();
		WebElement logoutValidation = logout.getlogoutValidation();
		String actual6 = logoutValidation.getText();
		String expected6 = "Accepted usernames are:";
		Assert.assertEquals(actual6, expected6, "logout validation unsuccessfull");
		//System.out.println("logout validation successfull");

		base.quit();

	} catch (Exception e) {
	}


	}
}

	


