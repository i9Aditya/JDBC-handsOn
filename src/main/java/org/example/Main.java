package org.example;
import javax.sound.midi.Soundbank;
import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String username = "root";
        String password = "root@123";

        EmployeeDAO dao = new EmployeeDAO();

        try(Connection con = DriverManager.getConnection(url,username,password)){
            int rows = dao.createEmployee("Rohit",50000,con);
            System.out.println("Insterted : " + rows);

            Employee emp = dao.findEmployee(4,con);
            emp.printEmp();
            dao.updateEmployee(5,8500,con);



        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
//        try {
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
//            System.out.println("DataBase Connection Successful");
//            while(resultSet.next()){
//                System.out.print(resultSet.getInt("id") + " ");
//                System.out.print(resultSet.getString("name") + " ");
//                System.out.println(resultSet.getDouble("salary"));
//            }
//
//           // int ans = statement.executeUpdate("INSERT into employees(name,salary) values ('Aman',45000)");
//            //System.out.println("Number of rows Inserted : " + ans);
//
//            PreparedStatement ps = connection.prepareStatement(
//                    "UPDATE employees set salary = ? where id = ?"
//            );
//            ps.setDouble(1,55000);
//            ps.setInt(2,5);
//            int rows = ps.executeUpdate();
//            System.out.println("rows changed after preparedStatement : " + rows);
//            System.out.println();
//            System.out.println();
//
//            PreparedStatement ps1 = connection.prepareStatement(
//              "Select * from employees where id > ?"
//            );
//            PreparedStatement ps2 = connection.prepareStatement(
//                    "INSERT INTO employees (name,salary) values (?,?)"
//            );
//            String name = "Kiran";
//            double salary = 57000;
//
//            ps2.setString(1,name);
//            ps2.setDouble(2,salary);
//            ps1.setInt(1,3);
//            int result2 = ps2.executeUpdate();
//
//
//
//            ResultSet resultSet1 = ps1.executeQuery();
//            while(resultSet1.next()){
//                System.out.print(resultSet1.getInt("id") + " ");
//                System.out.print(resultSet1.getString("name") + " ");
//                System.out.println(resultSet1.getDouble("salary"));
//            }
//
//            statement.close();
//            ps.close();
//            ps1.close();
//            ps2.close();
//            resultSet.close();
//            resultSet1.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            System.out.println("DataBase Connection failed");
//            e.printStackTrace();
//        }

//        try (Connection connection =
//                     DriverManager.getConnection(url, username, password)) {
//
//            System.out.println("Database Connection Successful");
//
//            // SELECT
//            try (Statement statement = connection.createStatement();
//                 ResultSet resultSet =
//                         statement.executeQuery("SELECT * FROM employees")) {
//
//                while (resultSet.next()) {
//                    System.out.print(resultSet.getInt("id") + " ");
//                    System.out.print(resultSet.getString("name") + " ");
//                    System.out.println(resultSet.getDouble("salary"));
//                }
//            }
//
//            // UPDATE
//            try (PreparedStatement ps = connection.prepareStatement(
//                    "UPDATE employees SET salary = ? WHERE id = ?")) {
//
//                ps.setDouble(1, 55000);
//                ps.setInt(2, 5);
//
//                int rows = ps.executeUpdate();
//
//                System.out.println(
//                        "Rows changed: " + rows
//                );
//            }
//
//            // SELECT with parameter
//            try (PreparedStatement ps1 = connection.prepareStatement(
//                    "SELECT * FROM employees WHERE id > ?")) {
//
//                ps1.setInt(1, 3);
//
//                try (ResultSet resultSet1 = ps1.executeQuery()) {
//
//                    while (resultSet1.next()) {
//                        System.out.print(resultSet1.getInt("id") + " ");
//                        System.out.print(resultSet1.getString("name") + " ");
//                        System.out.println(resultSet1.getDouble("salary"));
//                    }
//                }
//            }
//
//            // INSERT
//            try (PreparedStatement ps2 = connection.prepareStatement(
//                    "INSERT INTO employees (name, salary) VALUES (?, ?)")) {
//
//                ps2.setString(1, "Kiran");
//                ps2.setDouble(2, 57000);
//
//                int rows = ps2.executeUpdate();
//
//                System.out.println("Rows inserted: " + rows);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Database operation failed");
//            e.printStackTrace();
//        }


