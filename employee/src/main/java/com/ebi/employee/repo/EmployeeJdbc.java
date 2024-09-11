package com.ebi.employee.repo;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.entity.EmployeeEntity;


import java.sql.*;

public class EmployeeJdbc {
    private String url = "jdbc:mysql://localhost:3306/emp";
    private String user = "root";
    private String password = "root";


    public EmployeeEntity getEmployeeFromDb(String id) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        String sqlQuery = "SELECT * FROM employee WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employeeEntity.setId(resultSet.getInt(1));
                employeeEntity.setFirstName(resultSet.getString(2));
                employeeEntity.setSecondName(resultSet.getString(3));
                employeeEntity.setSalary(resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeEntity;
    }


}
