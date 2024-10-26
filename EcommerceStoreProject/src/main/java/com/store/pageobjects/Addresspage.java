package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Addresspage extends baseclass{
	
	actionsclass actions=new actionsclass();
	
	// constructor
	public Addresspage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	public Shippingpage clickoncheckout() {
		actions.click(driver, proceedtocheckout);
		return new Shippingpage();
	}
}
