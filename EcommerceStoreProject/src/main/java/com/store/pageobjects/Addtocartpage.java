package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Addtocartpage extends baseclass{
	actionsclass actions=new actionsclass();
	// constructor
	public Addtocartpage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement size;

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(xpath = "//li//a[@name='Black']")
	WebElement colour;

	@FindBy(xpath = "//*[@id='add_to_cart']//button//span")
	WebElement addtocart;
	
	@FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[text()]")
	WebElement addtocartmessage;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckout;
	
	
	public void selectsize(String siz) {
		actions.fluentWait(getDriver(), size, 10);
		actions.selectByVisibleText(size, siz);
	}
	public void enterquantity(String qty) {
		actions.fluentWait(getDriver(), quantity, 10);
		actions.type(quantity, qty);
	}
	
	public void clickoncolour() {
		actions.fluentWait(getDriver(), colour, 10);
		actions.click(getDriver(), colour);
	}
	
	public void clickonaddtocart() {
		actions.fluentWait(getDriver(), addtocart, 10);
		actions.click(getDriver(), addtocart);
	}
	public boolean validateAddtoCart() throws Throwable {
		actions.fluentWait(getDriver(), addtocartmessage, 20);
		return actions.isDisplayed(getDriver(), addtocartmessage);
	}
	
	public Orderpage JSClickproceedtocheckout() {
	   actions.fluentWait(getDriver(), proceedtocheckout, 20);
	   actions.JSClick(getDriver(), proceedtocheckout);	
	   return new Orderpage();
	}
}