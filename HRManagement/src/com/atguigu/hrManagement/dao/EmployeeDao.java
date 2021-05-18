package com.atguigu.hrManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.hrManagement.bean.Department;
import com.atguigu.hrManagement.bean.Employee;

/**
 * Define the behavior of accessing the schema table employee
 */
@Repository
public class EmployeeDao implements Dao<Employee> {
	
	static {	// load and register mysql driver
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Autowired
	private DepartmentDao departDao;
	
	private String url= "jdbc:mysql://localhost:3306/company?serverTimezone=UTC";
	private String user = "root";
	private String password = "12345";
	private String sql = "";	//query statement
	private Map<Integer, Employee> map = new HashMap<Integer, Employee>();	//map to contain employees that are retrieved from schema
	

	/**
	 * Get all records in a schema table
	 * @return a collection containing the records
	 */
	@Override
	public Collection<Employee> getAll() {
		sql = "SELECT * FROM employee";
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement();
			ResultSet result = state.executeQuery(sql))
		{
			map.clear();
			while(result.next()) {
				int id = result.getInt("employeeId");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String email = result.getString("email");
				String gender = result.getString("gender");
				int departmentId = result.getInt("departmentId");
				Employee emp = new Employee(id, firstName, lastName, email, gender, departDao.getById(departmentId));
				map.put(id, emp);
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
	public Employee getById(Integer id) {
		Employee emp = null;
		sql = "SELECT * FROM employee WHERE employeeId=" + id;
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement();
			ResultSet result = state.executeQuery(sql))
		{
			if(result.next()) {
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String email = result.getString("email");
				String gender = result.getString("gender");
				int departmentId = result.getInt("departmentId");
				Department department = departDao.getById(departmentId);
				emp = new Employee(id, firstName, lastName, email, gender, department);
			}
				
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return emp;
	}
	
	
	/**
	 * Get records that is eligible for name
	 * @param name - the name of record in schema table
	 * @return the records being suitable for name
	 */
	@Override
	public Collection<Employee> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Insert a new record into a schema table
	 * @param t - new record that should be inserted into a schema table
	 */
	@Override
	public void save(Employee emp) {
		String firstName = emp.getFirstName();
		String lastName = emp.getLastName();
		String email = emp.getEmail();
		String gender = emp.getGender();
		int departmentId = emp.getDepartment().getId();
		
		String tmp = "'" + firstName + "', '" + lastName + "', '" + email + "', '" + gender + "', " + departmentId; 
		sql = "INSERT INTO employee (firstName, lastName, email, gender, departmentId) VALUES (" + tmp + ")";
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement())
		{
			state.executeUpdate(sql);
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
		sql = "DELETE FROM employee WHERE (employeeId=" + id + ")";
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement())
		{
			int count = state.executeUpdate(sql);
			if(count == 0)
				System.out.println("Failed to delete the employee with id:" + id);
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}


	/**
	 * Update a record in schema table
	 * @param emp - object of type employee containing new updated data
	 */
	@Override
	public void update(Employee emp) {
		int id = emp.getId();
		String firstName = emp.getFirstName();
		String lastName = emp.getLastName();
		String email = emp.getEmail();
		String gender = emp.getGender();
		int departmentId = emp.getDepartment().getId();
		
		String tmp= "firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "', gender='" + gender + "', departmentId="+ departmentId + " ";          
		sql = "UPDATE employee SET " + tmp + "WHERE (employeeId=" + id + ")";
		
		try(Connection connec = DriverManager.getConnection(url, user, password);
			Statement state = connec.createStatement())
		{
			state.executeUpdate(sql);
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
