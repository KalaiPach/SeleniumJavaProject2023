package day06;

import org.testng.annotations.Test;

public class program02 {

	@Test(groups = {"smoke"})
	public static void testCase01() {
		System.out.println("Test Case01");
	}
	
	@Test
	public static void testCase02() {
		System.out.println("Test Case02");
	}
	
	@Test
	public static void testCase03() {
		System.out.println("Test Case03");
	}

	@Test(groups = {"smoke"})
	public static void testCase04() {
		System.out.println("Test Case04");
	}
	
	@Test(groups = {"smoke"})
	public static void testCase05() {
		System.out.println("Test Case05");
	}

}
