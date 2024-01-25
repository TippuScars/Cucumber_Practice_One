package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchPage {
	WebDriver driver;

	public BranchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	void clickbtn(WebElement element) {
		element.click();
	}
	
	void senddata(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	void select(WebElement element, String data) {
		new Select(element).selectByVisibleText(data);
	}
	
	// Home page
	
	@FindBy(id = "txtuId")
	WebElement objUser;

	@FindBy(id = "txtPword")
	WebElement objPass;

	@FindBy(id = "login")
	WebElement loginBtn;

	public void username(String user) {
		senddata(objUser, user);
	}

	public void password(String pass) {
		senddata(objPass, pass);
	}

	public void loginbtn() {
		clickbtn(loginBtn);
	}

	
	//Admin page
	
	@FindBy(xpath ="(//img)[5]")
	WebElement branchbtnid;
	
	public void clickbranch() {
		clickbtn(branchbtnid);
	}
	
	@FindBy(xpath ="//input[@id='BtnNewBR']")
	WebElement Newbranchbtnid;
	
	public void clickNewbranch() {
		clickbtn(Newbranchbtnid);
	}
	
	@FindBy(xpath ="//input[@id='txtbName']")
	WebElement branchnameid;
	
	public void branchName(String branchname) {
		senddata(branchnameid, branchname);
	}
	
	@FindBy(xpath ="(//input[@id='txtAdd1'])[1]")
	WebElement address1id;
	
	public void address1(String adds1) {
		senddata(address1id, adds1);
	}
	
	@FindBy(xpath ="(//input[@id='Txtadd2'])[1]")
	WebElement address2id;
	
	public void address2(String adds2) {
		senddata(address2id, adds2);
	}
	
	@FindBy(xpath ="(//input[@id='txtadd3'])[1]")
	WebElement address3id;
	
	public void address3(String adds3) {
		senddata(address3id, adds3);
	}
	
	@FindBy(xpath ="//input[@id='txtArea']")
	WebElement areaid;
	
	public void area(String areadata) {
		senddata(areaid, areadata);
	}
	
	@FindBy(xpath ="//input[@id='txtZip']")
	WebElement pincodeid;
	
	public void zipcode(String zip) {
		senddata(pincodeid, zip);
	}
	
	@FindBy(xpath ="//select[@id='lst_counrtyU']")
	WebElement countryid;
	
	public void country(String countrydata) {
		select(countryid, countrydata);
	}
	
	@FindBy(xpath ="//select[@id='lst_stateI']")
	WebElement stateid;
	
	public void state(String countrydata) {
		select(stateid, countrydata);
	}
	
	@FindBy(xpath ="//select[@id='lst_cityI']")
	WebElement cityid;
	
	public void city(String countrydata) {
		select(cityid, countrydata);
	}
	
	@FindBy(xpath = "//input[@id='btn_insert']")
	WebElement submitbtnid;
	
	public void submit() {
		clickbtn(submitbtnid);
	}

}
