package com.atguigu.hrManagement.dao;

import java.util.Collection;

public interface Dao {
	/**
	 * Get all records in a database table
	 * @return a collection containing the records
	 */
	public <E> Collection<E> getAll();
	
	/**
	 * Get the records that are eligible for the search condition
	 * @param condition - search condition for searching in a database table
	 * @return a collection containing the eligible records
	 */
	public Collection<Object> get(Object condition);
	
	/**
	 * Insert a new record into a database table
	 * @param record - new record that should be inserted into a database table
	 */
	public void save(Object record);
	
	/**
	 * Delete a record from a database table
	 * @param condition - search condition for searching in a database table
	 */
	public void delete(Object condition);
	
}
