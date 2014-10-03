package com.vmware;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest {

	private Employee employee;
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Construct a new Employee per Test");
		employee = new Employee(Pattern.compile("\\d{3}-\\d{2}-\\d{4}"));
	}
	
	@Test
	public void createEmployeeAndGetName() {
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}
	
	//Eclipse : F2 brings up the helper
	//CTRL+F11 Run
	//CTRL+E Recent Files
	@Test
	public void addASocialSecurityNumber() {
		employee.setSocialSecurityNumber("123-45-6789");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
	}
	
	@Test
	public void addAnotherSocialSecurityNumber() {
		employee.setSocialSecurityNumber("123-45-6710");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
	}
	
	@Test
	public void fixDE30201_SocialSecurityMustBeACertainFormat() {
		String badSSN = "sfsFSf";
		try {
			employee.setSocialSecurityNumber(badSSN);
			fail("This line should not have reached");			
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "sfsFSf is not a valid SSN");
		}
	}
}
