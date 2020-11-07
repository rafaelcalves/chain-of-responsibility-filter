package com.unisinos.dev2.filter.impl;

import com.unisinos.dev2.filter.StudentsFilter;
import com.unisinos.dev2.model.Student;

import java.util.List;


public class AgeBiggerThanStudentFilter extends StudentsFilter<Integer>
{

	public AgeBiggerThanStudentFilter(Integer filterBy)
	{
		super(filterBy);
	}

	public AgeBiggerThanStudentFilter(List<Student> toFilter, Integer filterBy)
	{
		super(toFilter, filterBy);
	}

	@Override protected boolean matchFilterBy(Student student)
	{
		return student.getAge() > getFilterBy();
	}
}
