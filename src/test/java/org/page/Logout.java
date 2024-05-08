package org.page;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout extends Baseclass{
	public Logout() {
PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement openMenu;
	public WebElement getOpenMenu() {
		return openMenu;
	}
	@FindBy(id = "logout_sidebar_link")
	private WebElement logout;
	public WebElement getLogout() {
		return logout;
	}
	@FindBy(xpath = "//h4[text()='Accepted usernames are:']")
	private WebElement logoutValidation;

	public WebElement getlogoutValidation() {
		return logoutValidation;
	}
}
