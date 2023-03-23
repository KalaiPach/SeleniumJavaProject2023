package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class program01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://accounts.google.com/signup");
		
		WebElement fn = driver.findElement(By.name("firstName"));
		
		System.out.println(fn.isDisplayed());
		
		if(fn.isDisplayed()){
			fn.sendKeys("FirstName");
		}
		else {
			System.out.println("FirstName is not displayed");
		}
	
	}

}
