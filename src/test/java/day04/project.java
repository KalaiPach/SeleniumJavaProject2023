package day04;

public class project extends Framework {

	public static void main(String[] args) {
		
		reportStart("Feb22");
		testCaseStart("Testcase01", "Verify values entered in all fields");
		browser ("Chrome");
		application("https://demo.automationtesting.in/Register.html");
		typeIn("//input[@placeholder='First Name']", "Kalaivani", "FirstName");
		typeIn("//input[@placeholder='Last Name']", "Pachai", "LastName");
		selectDropDownbyValue("//select[@id='Skills']","Android", "Skill");
		selectDropDownByIndex("//input[@class='select2-search__field']",0,"Country");
		testCaseEnd();
		reportEnd();
		
		
		
		
	
	}

}
