package com.att.test;

public class Employee {

	public String name;
	public int age;
	public double salary;
	public String dept;
	
	
	public Employee(String name, int age, double salary, String dept) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
