package com.feicuiedu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DaoSelect {
	
	public void query() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root","123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from user_  where id= 0 ";
			PreparedStatement statement = con.prepareStatement(sql);
			// statement.setString(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String account = rs.getString(8);
				String password = rs.getString(7);
				String card = rs.getString(3);

				//System.out.println("姓名" + name + "密码" + password);

			}
			// 关闭资源
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
