package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class program02 {

	public static void main(String[] args) throws IOException {
				 
			try {
				File src = new File(".\\src\\test\\resources\\Newconfig.properties");
				OutputStream ip = new FileOutputStream(src);
				Properties property = new Properties();
				
				property.setProperty("browser", "IE");
				property.setProperty("Screenshot", "./src/test/resources/");
				
				property.store(ip, "New Property file added");
				System.out.println(property);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			
			
			}
			
	}
}