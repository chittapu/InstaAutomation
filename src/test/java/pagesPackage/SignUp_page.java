package pagesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp_page {
	WebDriver driver;
	public SignUp_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[text()='Sign up']")
	WebElement signUP_Btn;
	public WebElement getsignUP_Btn() {
		return signUP_Btn;
	}
	@FindBy(name = "emailOrPhone")
	WebElement mobNum;
	public WebElement getmobNum() {
		return mobNum;
	}
	@FindBy(name = "fullName")
	WebElement fullName;
	public WebElement getfullName() {
		return fullName;
	}
	@FindBy(name = "username")
	WebElement userName;
	public WebElement getuserName() {
		return userName;
	}
	@FindBy(name = "password")
	WebElement password;
	public WebElement getpassword() {
		return password;
	}
	@FindBy(xpath = "//*[@type='submit']")
	WebElement submit;
	public WebElement getsubmit() {
		return submit;
	}
	@FindBy(xpath = "//*[@title='Month:']")
	WebElement DOBmonth;
	public WebElement getDOBmonth() {
		return DOBmonth;
	}
	@FindBy(xpath = "//*[@title='Day:']")
	WebElement DOBday;
	public WebElement getDOBday() {
		return DOBday;
	}
	@FindBy(xpath = "//*[@title='Year:']")
	WebElement DOByear;
	public WebElement getDOByear() {
		return DOByear;
	}
	@FindBy(xpath = "//*[text()='Next']")
	WebElement nextBtn;
	public WebElement getnextBtn() {
		return nextBtn;
	}
	

}
