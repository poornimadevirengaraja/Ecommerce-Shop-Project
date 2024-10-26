package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Shippingpage extends baseclass {
actionsclass actions=new actionsclass();
	
	// constructor
	public Shippingpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public void checktheterms() throws Throwable {
		actions.click(driver, terms);
	}
	
	public Paymentpage clickonproceedtocheckout() throws Throwable {
		actions.click(driver, proceedToCheckOutBtn);
		return new Paymentpage();
	}
}
