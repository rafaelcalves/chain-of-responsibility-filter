package com.unisinos.dev2.filter.impl;

import com.unisinos.dev2.filter.StudentsFilter;
import com.unisinos.dev2.model.Student;

import java.util.List;


public class NotImplementedFilter extends StudentsFilter<Object>
{
	public NotImplementedFilter()
	{
		super(null);
	}

	@Override protected boolean matchFilterBy(Student student)
	{
		return false;
	}

	@Override public List<Student> doFilter() throws Exception
	{
		throw new IllegalAccessException("Filtro não implementado!");
	}
}
