package com.coderanch.java;

public class Employee {
	private Integer id;
	private String name;
	
	public Employee(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}	
	
	
}
