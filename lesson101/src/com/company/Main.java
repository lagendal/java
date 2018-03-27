package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;

        try  {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "admin", "admin");
            PreparedStatement ps = conn.prepareStatement("SELECT*FROM users");
            ResultSet result = ps.executeQuery();
            while (result.next()){
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("reg_date"));
            }
            ps.executeQuery();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(name, login, reg_date, password)VALUES(?,?,NOW(),?)");
            ps.setString(1,"Igor2");
            ps.setString(2, "lagendal2");
            ps.setString(3,"123");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
