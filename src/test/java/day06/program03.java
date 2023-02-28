package day06;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class program03 {

	WebDriver driver; 
	
	@DataProvider(name="login")
	public Object[][] testdata()
	{
		return new Object[][]{{"username1","password1"},
			{"username2","password2"},
			{"username3","password3"},
			{"username4","password4"}};
	}
	
	@Test(dataProvider = "login")
	public void logIn(String username, String pwd) {
	
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.findElement(By.name("uid")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("pwds");
	}
	
}
