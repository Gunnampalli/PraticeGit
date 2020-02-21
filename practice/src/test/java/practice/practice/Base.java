package practice.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public Base() {
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream(
					"D:\\Vijay 2\\practice\\src\\test\\java\\" + "environment_Variables\\config.properties");
			prop.load(fp);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public static void initialization() throws MalformedURLException, Throwable {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\venkatG\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			// driver=new ChromeDriver();
			/*
			 * ChromeOptions opt=new ChromeOptions(); opt.addArguments("headless");
			 * opt.addArguments("Window-size=1200*600"); driver=new ChromeDriver(opt);
			 */
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setPlatform(Platform.WIN10);
			// dc.setCapability(capabilityName, value);
			dc.setBrowserName("chrome");
			driver = new RemoteWebDriver(new URL(""), dc);

			//*********************Connection to Database************************//
			/*Connection c = DriverManager.getConnection("", "", "");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("");
			while(rs.next())
			{
				System.out.println(rs.getString(""));
			}*/
			}

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}

}
