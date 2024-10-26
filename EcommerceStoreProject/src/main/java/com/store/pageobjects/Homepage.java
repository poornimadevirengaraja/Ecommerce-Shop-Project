package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Homepage extends baseclass{
	
	actionsclass actions=new actionsclass();
	
	//constructor
	public Homepage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='breadcrumb clearfix']" )
	WebElement myaccounttitle;
	
	@FindBy(xpath="//span[text()='My addresses']" )
	WebElement addmyfirstaddress;
	
	@FindBy(xpath="//span[text()='Order history and details']" )
	WebElement orderhistory;
	
	@FindBy(xpath="//*[@id=\"center_column\"]//p[1]" )
	WebElement accountcreatedmsg;
	
	
		
	public boolean myaccountisdisplayed() {		
		return actions.isDisplayed(getDriver(), myaccounttitle);
	}
	public boolean addmyfirstaddressisdisplayed() {		
		return actions.isDisplayed(getDriver(), addmyfirstaddress);
	}
	public boolean orderhistoryisdisplayed() {		
		return actions.isDisplayed(getDriver(), orderhistory);
	}
	public String getcurrenturlhomepage() {		
		return actions.getCurrentURL(getDriver());
	}
	public boolean accountcreatedmsgisdisplayed() {	
		actions.fluentWait(getDriver(), accountcreatedmsg , 10);
		return actions.isDisplayed(getDriver(), accountcreatedmsg);
	}
}
