package com.unisinos.dev2.filter;

public interface Filter<T> {
	T doFilter();
	Filter<T> setNext(Filter<T> next);
	void setToFilter(T toFilter);
}
