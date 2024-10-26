package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Ordersummarypage extends baseclass {
	actionsclass actions=new actionsclass();
	
	public Ordersummarypage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public Orderconfirmationpage clickOnconfirmOrderBtn() {
		actions.fluentWait(getDriver(), confirmOrderBtn, 20);
		actions.click(getDriver(), confirmOrderBtn);
		return new Orderconfirmationpage();
	}
}
