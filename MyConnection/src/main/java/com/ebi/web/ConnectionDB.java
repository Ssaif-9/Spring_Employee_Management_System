package com.ebi.web;

import java.sql.*;


public class ConnectionDB {
	 private final String url = "jdbc:mysql://localhost:3306/emp";
	    private final String userName = "root";
	    private final String password = "root";

	    
	    
	    public int addEmployee(Employee emp)    {	
	    	int resultSet =0;
	        try {
	        	try {
	        	
				Class.forName("com.mysql.cj.jbdc.Driver");}catch(ClassNotFoundException e) {e.printStackTrace();}
				
	        	Connection connection = DriverManager.getConnection(url, userName, password);
	            
	            String SQL ="INSERT INTO employee (id, first_name, second_name,salary) VALUES (?,?,?,?)";

	            PreparedStatement statement = connection.prepareStatement(SQL);

	            statement.setInt(1, emp.getId());
	            statement.setString(2, emp.getFirst_name());
	            statement.setString(3, emp.getSecond_name());
	            statement.setString(4, emp.getSalary());
	            
	            
	            resultSet=statement.executeUpdate();

	     
	            statement.close();
	            connection.close();

	        } catch (SQLException sqlEx) {
	            System.out.println(sqlEx);
	        } 
		    return resultSet;
	    }
}
