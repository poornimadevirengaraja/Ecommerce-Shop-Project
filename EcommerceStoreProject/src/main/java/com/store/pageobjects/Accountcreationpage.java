package com.store.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.actions.actionsclass;
import com.store.base.baseclass;


/**
 * @author Poornimadevi
 *
 */
public class Accountcreationpage extends baseclass{
	actionsclass actions=new actionsclass();
	
	//constructor
	public Accountcreationpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//h1[text()='Create an account']" )
	WebElement createanaccounttitle;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year
			/*String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone*/) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			actions.click(driver, mr);
		} else {
			actions.click(driver, mrs);
		}
		
		actions.type(firstName, fName);
		actions.type(lastName, lName);
		actions.type(passWord, pswd);
		actions.selectByValue(days, day);
		actions.selectByValue(months, month);
		actions.selectByValue(years, year);
		/*actions.type(companyName, comPany);
		actions.type(address, addr);
		actions.type(city, cityString);
		actions.selectByVisibleText(state,stateName);
		actions.type(postCode, zip);
		actions.selectByVisibleText(country,countryName);
		actions.type(mobile, mobilePhone)*/;
	}
	
	public Homepage validateRegistration() throws Throwable {
		registerBtn.click();
		return new Homepage();
	}
	
	public boolean myaccountisdisplayed() {		
		actions.fluentWait(getDriver(), createanaccounttitle, 20);
		return actions.isDisplayed(getDriver(), createanaccounttitle);
	}
}

	
