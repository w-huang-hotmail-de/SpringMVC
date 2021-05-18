package com.atguigu.hrManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.atguigu.hrManagement.bean.Department;


/**
 * Define the behavior of accessing the schema table department
 */
@Repository
public class DepartmentDao implements Dao<Department> {
	
	static {	// load and register mysql driver
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private String url = "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
	private String user = "root";
	private String password = "12345";
	private String sql;	//query statement
	
	private Map<Integer, Department> map = new HashMap<Integer, Department>();	//a map containing records retrieved from database table
	
	
	/**
	 * Get all records in a schema table
	 * @return a collection containing the records
	 */
	@Override
	public Collection<Department> getAll() {
		sql = "SELECT * FROM department";
		
		try(Connection connec = DriverManager.getConnection(url, user, password);	//connection with a schema (database)
			Statement state = connec.createStatement();	//create query statement
			ResultSet result = state.executeQuery(sql))	//result set containing the records retrieved from schema table
		{
			map.clear();
			while(result.next()) {
				int id = result.getInt("departmentId");
				String name = result.getString("departmentName");
				Department depart = new Department(id, name);
				map.put(id, depart);	
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		return map.values();
	}

	
	/**
	 * Get a record that is eligible for the ID
	 * @param id - ID number of record in schema table
	 * @return the record encapsulated with an suitable object
	 */
	@Override
	public Department getById(Integer id) {
		Department depart = null;	
		sql = "SELECT * FROM department WHERE departmentId=" + id;	//query statement
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement();
			ResultSet result = state.executeQuery(sql))
		{
			depart = null;
			if(result.next()) //nothing or only one record can be retrieved by id number 
				depart = new Department(result.getInt("departmentId"), result.getString("departmentName"));
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return depart;
	}
	
	
	/**
	 * Get records that is eligible for name
	 * @param name - the name of record in schema table
	 * @return the records being suitable for name
	 */
	@Override
	public Collection<Department> getByName(String departName) {
		sql = "SELECT * FROM department WHERE departmentName=" + departName;	//query statement
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement();
			ResultSet result = state.executeQuery(sql))
		{
			map.clear();
			while(result.next()) {
				int id = result.getInt("departmentId");
				String name = result.getString("departmentName");
				map.put(id, new Department(id, name));
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		return map.values();
	}

	
	/**
	 * Insert a new record into a schema table
	 * @param t - new record that should be inserted into a schema table
	 */
	@Override
	public void save(Department depart) {
		String name = depart.getDepartName();
		sql = "INSERT INTO department (departmentName) VALUES (" + name + ")";
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement())
		{
			int rowCount = state.executeUpdate(sql);	//row count being manipulated
			if(rowCount == 0)
				System.out.println("Failed to save the new record with name: " + name);
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	
	/**
	 * Delete a record from a schema table
	 * @param id - ID of a record to be deleted from a schema table
	 */
	@Override
	public void deleteById(Integer id) {
		sql = "DELETE FROM department WHERE departmentId=" + id;
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement())
		{
			int rowCount = state.executeUpdate(sql);	//row count being manipulated
			if(rowCount == 0)
				System.out.println("Failed to delete record with Id: " + id);
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}


	/**
	 * Update a record in table department
	 * @param depart - department containing new data
	 */
	@Override
	public void update(Department depart) {
	
	}

}
