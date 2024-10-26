package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Orderconfirmationpage extends baseclass{
	actionsclass actions=new actionsclass();
	
	public Orderconfirmationpage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='center_column']/p[1]")
	private WebElement confirmMessag;
		
	public String validateConfirmMessage() {
		actions.fluentWait(driver, confirmMessag, 20);
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}
}
