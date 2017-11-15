package com.juniter.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

/**
 * 
 * 提供事务处理方法
 * 
 * @author Juniter
 *
 */
public class SuperService {
	protected static final Logger logger = LoggerFactory.getLogger(SuperService.class.getName());
	private final TransactionTemplate transactionTemplate;

	public SuperService(PlatformTransactionManager transactionManager) {
		Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
		this.transactionTemplate = new TransactionTemplate(transactionManager);
		this.transactionTemplate.setTimeout(30);
		this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
	}

	protected <T> T doTransaction(final TransactionExecuter<T> executer,Object...o) {
		return transactionTemplate.execute(new TransactionCallback<T>() {

			@Override
			public T doInTransaction(TransactionStatus status) {
				T t = null;
				try {
					t = executer.doTransaction(o);
				} catch (Exception e) {
					status.setRollbackOnly();
					logger.error(e.getMessage());
				}
				return t;
			}

		});
	}

	protected <T> void doTransactionWithoutResult(final TransactionExecuter<T> executer,Object...o) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					executer.doTransaction(o);
				} catch (Exception e) {
					status.setRollbackOnly();
					logger.error(e.getMessage());
				}
			}

		});
	}
}
