package day02;

public class project extends Framework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		browser ("Chrome");
		application("https://demo.automationtesting.in/Register.html");
		typeIn("//input[@placeholder='First Name']", "Kalaivani");
		typeIn("//input[@placeholder='Last Name']", "Pachai");
		selectDropDownbyValue("//select[@id='Skills']","Android");
		selectDropDownByIndex("//input[@class='select2-search__field']",0);
		
		
		
		
	
	}

}
