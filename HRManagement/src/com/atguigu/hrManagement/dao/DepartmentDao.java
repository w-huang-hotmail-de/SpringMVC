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

@Repository
public class DepartmentDao implements Dao {
	private String url = "jdbc:mysql://localhost:3306/company?serverTimeZone=UTC";
	private String user = "root";
	private String password = "12345";

	
	/**
	 * Get all records in a database table
	 * @return a collection containing the records
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Department> getAll() {
		Map<Integer, Department> map = new HashMap<Integer, Department>();	//a map containing records retrieved from database table
		String sql = "SELECT * FROM department";
		
		try(Connection connec = DriverManager.getConnection(url);
			Statement state = connec.createStatement();
			ResultSet result = state.executeQuery(sql))
		{
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

	
	@Override
	public Collection<Object> get(Object condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object condition) {
		// TODO Auto-generated method stub

	}

}
