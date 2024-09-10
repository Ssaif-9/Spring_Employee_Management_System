package com.ebi.employee.repo;

import com.ebi.employee.model.EmployeeDto;


import java.sql.*;

public class EmployeeJdbc {
    private String url = "jdbc:mysql://localhost:3306/emp";
    private String user = "root";
    private String password = "root";


    public EmployeeDto getEmployeeFromDb(String id) {
        EmployeeDto employeeDto = new EmployeeDto();
        String sqlQuery = "SELECT * FROM employee WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employeeDto.setId(resultSet.getInt(1));
                employeeDto.setFirstName(resultSet.getString(2));
                employeeDto.setSecondName(resultSet.getString(3));
                employeeDto.setSalary(resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeDto;
    }


}
