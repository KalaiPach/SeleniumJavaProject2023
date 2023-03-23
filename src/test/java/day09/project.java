package day09;

import org.testng.annotations.Test;

public class project extends Framework {

	@Test
	
	public static void testcase01() {
		
		reportStart("Mar23");
		testCaseStart("Testcase01", "Verify values entered in all fields");
		browser ("Chrome");
		application("https://demo.automationtesting.in/Register.html");
		typeIn("FirstName");
		typeIn("LastName");
		selectDropDownbyValue("Skill");
		selectDropDownByIndex("Country");
		testCaseEnd();
		reportEnd();
		
		
		
		
	
	}

}
