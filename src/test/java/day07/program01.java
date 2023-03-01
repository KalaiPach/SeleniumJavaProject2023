package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class program01 {

	public static void main(String[] args) throws IOException {
				 
			try {
				File src = new File(".\\src\\test\\resources\\config.properties");
				InputStream ip = new FileInputStream(src);
				Properties property = new Properties();
				property.load(ip);
				
				System.out.println(property.getProperty("url"));
				System.out.println(property.getProperty("browser"));		
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			
				
			}
			
	}
}