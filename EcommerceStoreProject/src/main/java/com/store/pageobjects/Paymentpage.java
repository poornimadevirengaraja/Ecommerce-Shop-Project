package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Paymentpage extends baseclass{
	actionsclass actions=new actionsclass();
	public Paymentpage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
		
	public Ordersummarypage clickOnPaymentMethod() {
		actions.click(getDriver(), bankWireMethod);
		return new Ordersummarypage();
	}

}
