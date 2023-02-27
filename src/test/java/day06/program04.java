package day06;

import java.sql.Driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class program04 {
	
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
	
	 
		System.out.println("UserName"+"....."+"Password");
	}
	
}
