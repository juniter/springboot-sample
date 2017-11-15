package com.juniter.sample.service;

@FunctionalInterface
public interface TransactionExecuter<T> {
	T doTransaction(Object... o) throws Exception;
}
