package com.feicuiedu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.feicuiedu.server.UserServer;

public class UserSelect {
	private Scanner sc = new Scanner(System.in);
	private UserServer uss=new UserServer();
	// 普通用户选择方法
	public void selsct() {
		query();
		while (true) {

			String number = sc.next();

			if ("1".equals(number)) {
				number = "存款";
				uss.deposit();

			} else if ("2".equals(number)) {
				number = "取款";
				uss.withdrawal();

			} else if ("3".equals(number)) {
				number = "转账";
				uss.transfer();

			} else if ("4".equals(number)) {
				number = "个人信息查询";
				uss.query();

			} else {
				System.out.println("输入错误请重新输入");
				break;
			}

		}
		return;

	}
	public void query() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from userselect3 where id= 1";
			PreparedStatement statement = con.prepareStatement(sql);
			//statement.setString(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				String deposit = rs.getString(2);
				String withdrawal = rs.getString(3);
				String transfer = rs.getString(4);
				String query=rs.getString(5);

				System.out.println(deposit+ withdrawal+transfer+query);
				
			}
			//rs1.selsct();

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
