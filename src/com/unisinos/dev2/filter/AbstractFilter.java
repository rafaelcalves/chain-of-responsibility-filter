package com.unisinos.dev2.filter;

public abstract class AbstractFilter<T> implements Filter<T>
{
	private Filter<T> next;

	public AbstractFilter(Filter<T> next)
	{
		this.next = next;
	}

	public AbstractFilter() {}

	@Override
	public Filter<T> setNext(Filter<T> next)
	{
		this.next = next;
		return this;
	}

	public Filter<T> getNext()
	{
		return next;
	}
}
