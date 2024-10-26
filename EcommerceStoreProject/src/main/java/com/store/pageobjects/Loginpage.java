package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;

public class Loginpage extends baseclass {

	actionsclass actions = new actionsclass();

	// constructor
	public Loginpage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailaddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//button[@name='SubmitLogin']")
	WebElement signinbtn;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailfornewaccount;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement createaccountbtn;

	@FindBy(xpath ="//div[@class='alert alert-danger']//li")
	WebElement invalidcrendentialmsg;
	
		
	public Homepage Login(String usernm, String Pwd) throws InterruptedException {
		actions.fluentWait(getDriver(), emailaddress, 30);
		actions.type(emailaddress, usernm);
		actions.type(password, Pwd);
		actions.fluentWait(getDriver(), signinbtn, 30);
		actions.click(getDriver(), signinbtn);		
		return new Homepage();
	}

	/*
	 * public Homepage Login(String usernm, String Pwd, Homepage Homepage) throws
	 * Throwable { actions.scrollByVisibilityOfElement(getDriver(), emailaddress);
	 * actions.type(emailaddress, usernm); actions.type(password, Pwd);
	 * actions.JSClick(getDriver(), signinbtn); Thread.sleep(2000); return new
	 * Homepage(); }
	 */

	public Addresspage Loginfromshoppingcart(String usernm, String Pwd) {
		actions.fluentWait(getDriver(), emailaddress, 20);
		actions.type(emailaddress, usernm);
		actions.type(password, Pwd);
		actions.click(getDriver(), signinbtn);
		return new Addresspage();

	}

	public Accountcreationpage createnewaccount(String newemail) {
		actions.type(emailfornewaccount, newemail);
		actions.click(getDriver(), createaccountbtn);
		return new Accountcreationpage();
	}
	
	public String Validateinvalidcredentialmsg() {
		String invalidcrdmsg=invalidcrendentialmsg.getText();
		return invalidcrdmsg;
	}

	
}
