package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


public class Orderpage extends baseclass {
	actionsclass actions=new actionsclass();
	// constructor
	public Orderpage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//td[@class='cart_unit']//li")
	WebElement unitprice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalprice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	@FindBy(xpath = "//h1[text()='Authentication']")
	WebElement Authentication;
	
	
	public double getunitprice() {
		actions.fluentWait(getDriver(), unitprice, 20);
		String uprice = unitprice.getText();
		String stringuprice=uprice.replaceAll("[^a-zA-Z0-9]", ""); //This regex pattern matches a string that consists entirely of one or more alphanumeric characters (no spaces or special characters allowed).
		double doubleunitprice = Double.parseDouble(stringuprice);
		return doubleunitprice;
	}

	public double gettotalprice() {
		actions.fluentWait(getDriver(), totalprice, 20);
		String totprice = totalprice.getText();
		String stringtprice=totprice.replaceAll("[^a-zA-Z0-9]", ""); //This regex pattern matches a string that consists entirely of one or more alphanumeric characters (no spaces or special characters allowed).
		double doubletprice = Double.parseDouble(stringtprice);
		return doubletprice;
	}
	
	public Loginpage clickonproceedtocheckout() {
		actions.fluentWait(getDriver(), proceedtocheckout, 20);
		actions.click(driver, proceedtocheckout);
		return new Loginpage();
	}
	public boolean validateAuthentication() {
		actions.fluentWait(getDriver(), Authentication, 20);
		return actions.isDisplayed(driver, Authentication);
				
	}
	
	
	
}
