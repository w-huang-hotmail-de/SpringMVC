package com.atguigu.hrManagement.dao;

import java.util.Collection;

public interface Dao<T> {
	/**
	 * Get all records in a schema table
	 * @return a collection containing the records
	 */
	public Collection<T> getAll();
	
	
	/**
	 * Get a record that is eligible for the ID
	 * @param id - ID number of record in schema table
	 * @return the record encapsulated with an suitable object
	 */
	public T getById(Integer id);
	
	
	/**
	 * Get records that is eligible for name
	 * @param name - the name of record in schema table
	 * @return the records being suitable for name
	 */
	public Collection<T> getByName(String name);
	
	
	/**
	 * Insert a new record into a schema table
	 * @param t - new record that should be inserted into a schema table
	 */
	public void save(T t);
	
	
	/**
	 * Delete a record from a schema table
	 * @param t - a record to be deleted from a schema table
	 */
	public void delete(T t);
	
}
