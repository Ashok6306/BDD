package org.page;

import org.base.Baseclass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageclass extends Baseclass{
	public Pageclass() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;

	}
    @FindBy(xpath = "//input[@type='login']")
    private WebElement Login;
    public WebElement getLogin() {
		return Login;
    	
    
    }
    @FindBy(id = "login-button")
    private WebElement loginbuttion;
    public WebElement getLoginbuttion() {
		return loginbuttion;
	}
    @FindBy(xpath = "//div[@class='product_label']")
    private WebElement loginValidation;
    public WebElement getLoginValidation() {
		return loginValidation;
		
	}
	
	
	 

}
