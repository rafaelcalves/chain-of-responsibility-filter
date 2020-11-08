package com.unisinos.dev2.filter;

public interface Filter<T> {
	T doFilter(T toFilter) throws Exception;
	Filter<T> setNext(Filter<T> next);
}
