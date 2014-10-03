package com.vmware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	private String name;
	private String ssn;
	private Pattern pattern;

	public Employee(Pattern pattern) {
		this.pattern = pattern;// = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSocialSecurityNumber(String ssn) {
		if(!(pattern.matcher(ssn).matches()))
			throw new IllegalArgumentException(ssn + " is not a valid SSN");
		this.ssn = ssn;
	}

	public String getSocialSecurityNumber() {
		return ssn;
	}
}