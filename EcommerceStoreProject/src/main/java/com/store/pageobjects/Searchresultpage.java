package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Searchresultpage extends baseclass{
	
actionsclass actions=new actionsclass();
	
	//constructor
	public Searchresultpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="(//img[@alt='Printed Summer Dress'])[1]" )
	WebElement productresult;
	
	public boolean productresultisdisplayed() {
		actions.fluentWait(getDriver(), productresult, 20);
		return actions.isDisplayed(getDriver(), productresult);
	}
	
	
	public Addtocartpage clickonproductresult() {
		actions.fluentWait(getDriver(), productresult, 20);
		actions.click(getDriver(), productresult);
		return new Addtocartpage();
		
		
	}
	
	
	
}
