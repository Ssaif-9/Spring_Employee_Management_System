package com.ebi.web;

public class Employee {
	private int id;
	private String first_name;
	private String second_name;
	private String salary;
	
	public Employee () {}
	
	public Employee (int id ,String first_name,String second_name,String salary)
	{
		this.id=id;
		this.first_name=first_name;
		this.second_name=second_name;
		this.salary=salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
	

}
