package com.unisinos.dev2.model;

public class Student
{
	private String name;
	private Integer age;
	private String course;

	public Student(String name, Integer age, String course)
	{
		this.name = name;
		this.age = age;
		this.course = course;
	}

	public String getName()
	{
		return name;
	}

	public Integer getAge()
	{
		return age;
	}

	public String getCourse()
	{
		return course;
	}

	@Override public String toString()
	{
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", course='" + course + '\'' + "}\n";
	}
}
