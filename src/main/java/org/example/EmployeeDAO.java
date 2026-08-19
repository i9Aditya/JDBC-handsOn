package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    int createEmployee(String name, double salary, Connection con){
        int ans = 0;
        try(PreparedStatement ps =con.prepareStatement(
                "INSERT INTO employees(name,salary) values (?,?)"
        );){
            ps.setString(1,name);
            ps.setDouble(2,salary);

            ans = ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Insert could'nt take place");
            e.printStackTrace();
        }
        return ans;
    }

    Employee findEmployee(int id,Connection con){
        // Employee employee = new Employee(0,"",0);
        try(PreparedStatement ps = con.prepareStatement(
                "Select id,name, salary from employees where id = ?"
        );){
            ps.setInt(1,id);
            try(ResultSet resultSet = ps.executeQuery(); ){
                if(resultSet.next()){
                    System.out.println("DB ID: " + resultSet.getInt("id"));
                    System.out.println("DB Name: " + resultSet.getString("name"));
                    System.out.println("DB Salary: " + resultSet.getDouble("salary"));

                    return new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("salary")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    int updateEmployee(int id,int salary,Connection con){
        int ans = 0;
        try(PreparedStatement ps = con.prepareStatement(
                "UPDATE employees set salary = ? where id = ?"
        );){
            ps.setDouble(1,salary);
            ps.setInt(2,id);
            ans = ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

    int deleteEmployee(int id,Connection con){
        int ans = 0;
        try(PreparedStatement ps = con.prepareStatement(
                "DELETE from employees where id = ?"
        );){
            ps.setInt(1,id);
            ans = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
