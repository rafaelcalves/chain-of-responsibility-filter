package com.unisinos.dev2.filter.impl;

import com.unisinos.dev2.filter.Filter;
import com.unisinos.dev2.filter.StudentsFilter;
import com.unisinos.dev2.model.Student;

import java.util.List;


public class NameStudentsFilter extends StudentsFilter<String>
{
	public NameStudentsFilter(String filterBy)
	{
		super(filterBy);
	}

	public NameStudentsFilter(String filterBy, Filter<List<Student>> next)
	{
		super(filterBy, next);
	}

	@Override
	protected boolean matchFilterBy(Student student)
	{
		return student.getName().toLowerCase().contains(getFilterBy().toLowerCase());
	}
}
