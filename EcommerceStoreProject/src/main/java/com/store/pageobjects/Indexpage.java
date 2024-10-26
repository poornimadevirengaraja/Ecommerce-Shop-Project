package com.store.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;

public class Indexpage extends baseclass {
	
	// constructor
	public Indexpage() {
		PageFactory.initElements(getDriver(), this);
	}

	actionsclass actions = new actionsclass();

	@FindBy(xpath = "//a[@class='login']")
	WebElement signinbtn;

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchproductbox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchbtn;

	@FindBy(xpath = "//img[@alt='My Shop']")
	WebElement searchlogo;

	public String getstoretitle() {
		actions.fluentWait(getDriver(), signinbtn, 30);
		String storetitle = actions.getTitle(getDriver());
		System.out.println(storetitle);
		return storetitle;
	}

	public boolean logoisdisplayed() throws InterruptedException {
			
		return actions.isDisplayed(getDriver(), searchlogo);	
	}

	public Loginpage clickonsignin() {
		actions.fluentWait(getDriver(), signinbtn, 30);
		actions.click(getDriver(), signinbtn);
		return new Loginpage();
	}

	public Searchresultpage searchproductbox(String productname) {
		actions.type(searchproductbox, productname);
		actions.click(getDriver(), searchbtn);
		return new Searchresultpage();
	}

}
