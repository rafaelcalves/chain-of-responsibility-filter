package com.unisinos.dev2.filter.impl;

import com.unisinos.dev2.filter.Filter;
import com.unisinos.dev2.filter.StudentsFilter;
import com.unisinos.dev2.model.Student;

import java.util.List;


public class CourseStudentFilter extends StudentsFilter<String>
{
	public CourseStudentFilter(String filterBy)
	{
		super(filterBy);
	}

	public CourseStudentFilter(String filterBy, Filter<List<Student>> next)
	{
		super(filterBy, next);
	}

	@Override
	protected boolean matchFilterBy(Student student)
	{
		return student.getCourse().equalsIgnoreCase(getFilterBy());
	}
}
