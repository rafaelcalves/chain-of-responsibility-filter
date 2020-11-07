package com.unisinos.dev2.filter;

public abstract class AbstractFilter<T> implements Filter<T>
{
	private Filter<T> next;
	private T toFilter;

	public AbstractFilter(T toFilter)
	{
		this.toFilter = toFilter;
	}

	public AbstractFilter(Filter<T> next, T toFilter)
	{
		this.next = next;
		this.toFilter = toFilter;
	}

	@Override public Filter<T> setNext(Filter<T> next)
	{
		this.next = next;
		return this;
	}

	public Filter<T> getNext()
	{
		return next;
	}

	public T getToFilter()
	{
		return toFilter;
	}

	public void setToFilter(T toFilter)
	{
		this.toFilter = toFilter;
	}
}
