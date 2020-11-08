package com.unisinos.dev2.filter;

import com.unisinos.dev2.model.Student;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public abstract class StudentsFilter<T> extends AbstractFilter<List<Student>>
{
	private T filterBy;

	public StudentsFilter(T filterBy)
	{
		this.filterBy = filterBy;
	}

	public StudentsFilter(T filterBy, Filter<List<Student>> next)
	{
		super(next);
		this.filterBy = filterBy;
	}

	@Override
	public List<Student> doFilter(List<Student> students) throws Exception
	{
		List<Student> filterResult = students
				.stream()
				.filter(this::matchFilterBy)
				.collect(Collectors.toList());

		if(!isNull(getNext())) return callNext(filterResult);
		return filterResult;
	}

	private List<Student> callNext(List<Student> filterResult) throws Exception
	{
		return getNext().doFilter(filterResult);
	}

	protected abstract boolean matchFilterBy(Student student);

	public T getFilterBy()
	{
		return filterBy;
	}
}

