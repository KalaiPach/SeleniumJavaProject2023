package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.beust.jcommander.Parameters;


public class program05 {
	
	WebDriver driver;
	
	@Test
	@Parameters({"username","pwd"})
	public void testcase(String username,String pwd) {
	driver = new ChromeDriver();
	driver.get("https://demo.guru99.com/V1/index.php");
	driver.findElement(By.name("uid")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(pwd);	 

}
}
