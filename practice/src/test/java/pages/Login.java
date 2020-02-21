package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.practice.Base;

public class Login extends Base {
	@FindBy(xpath="//input[contains(@id,'email')]")
	WebElement UID;
	@FindBy(xpath="//input[contains(@id,'pass')]")
	WebElement pass;
	@FindBy(xpath="//input[starts-with(@id,'u_0_')]")
	WebElement btn;
	public Login()  {
		PageFactory.initElements(driver, this);
	}
	 public void username()
	 {
		 UID.sendKeys(prop.getProperty("UID"));
	 }
	 public void password()
	 {
		 pass.sendKeys(prop.getProperty("pass"));
	 }
	 public void login_Click()
	 {
		 btn.click();
	 }
	 public String validateTitle()
	 {
		return driver.getTitle();
	 }
	 

}
