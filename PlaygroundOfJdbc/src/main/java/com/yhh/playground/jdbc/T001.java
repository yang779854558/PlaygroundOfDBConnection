package com.yhh.playground.jdbc;

import java.sql.*;

/**
 * @author yhh
 */
public class T001 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=Asia/Shanghai",
                "root",
                "123456");
        String sql = "select * from student where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "yhh");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username") + " : " + resultSet.getInt("age"));
        }
    }
}
