package com.unisinos.dev2.filter;

import com.unisinos.dev2.model.Student;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


public abstract class StudentsFilter<E> extends AbstractFilter<List<Student>>
{
	private E filterBy;

	public StudentsFilter(E filterBy)
	{
		super(null);
		this.filterBy = filterBy;
	}

	public StudentsFilter(List<Student> toFilter, E filterBy)
	{
		super(toFilter);
		this.filterBy = filterBy;
	}

	@Override
	public List<Student> doFilter()
	{
		List<Student> filterResult = getToFilter()
				.stream()
				.filter(this::matchFilterBy)
				.collect(Collectors.toList());

		if(!isNull(getNext())) return callNext(filterResult);
		return filterResult;
	}

	private List<Student> callNext(List<Student> filterResult)
	{
		getNext().setToFilter(filterResult);
		return getNext().doFilter();
	}

	protected abstract boolean matchFilterBy(Student student);

	public E getFilterBy()
	{
		return filterBy;
	}
}

