package day05;

import org.testng.annotations.Test;

public class program01 {

	@Test(priority=0)
	public void testcase01() {
		System.out.println("Runing test!!!");
	}
	
	@Test (priority=3, enabled=false)
	public void testcase02() {
		System.out.println("Runing test!!!");
	}

	@Test (priority=2)
	public void testcase03() {
		System.out.println("Runing test!!!");
	}
	
	@Test (priority=5)
	public void testcase04() {
		System.out.println("Runing test!!!");
	}
	
	@Test (priority=4)
	public void testcase05() {
		System.out.println("Runing test!!!");
	}
}
