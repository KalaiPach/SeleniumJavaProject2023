package day10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class program04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://accounts.google.com/signup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement sp = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		
			
	}

}
