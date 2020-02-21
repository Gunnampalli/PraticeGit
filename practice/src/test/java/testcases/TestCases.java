package testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilites.Testutils;
import pages.Login;
import practice.practice.Base;

public class TestCases extends Base{
 Login l;
 Testutils u;
	public TestCases() throws Throwable {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		 l=new Login();
		 u=new Testutils();
		 
	}
	@Test
	public void tc1() throws InterruptedException, IOException
	{
		l.username();
		Thread.sleep(2000);
		l.password();
		Thread.sleep(2000);
		l.login_Click();
		Thread.sleep(2000);
		String title=l.validateTitle();
		if(title.equalsIgnoreCase("Log in to Facebook | Facebook"))
		{
			u.screenShot();
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
