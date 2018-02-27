package com.feicuiedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.feicuiedu.entity.RegisterUser;

/**
 * 创建工具类
 * @author www.99071491
 *
 */
public class CommonUtils {
	//增加
	public void add() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");
			
			// 获取执行sql的PreparedStatement对象
			String sql = "insert into user_       \r\n"
					+ "      (id,name,card,sex,birthday,balance,password,account)\r\n"
					+ "value (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, "3701111");
			statement.setString(2, "翡翠皮皮虾");
			statement.setString(3, "1");
			statement.setString(4, "aaaa");
			statement.setString(5, "2");
			statement.setString(6, "ffff");
			statement.setString(7, "121212");
			statement.setString(8, "123");
			
			// 执行sql语句,返回结果 -- 新增
			int rsCount = statement.executeUpdate();
			
			System.out.println("该操作影响了" + rsCount + "行");
			
			// 关闭资源
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
	//删除
	public void delete() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			
			// 执行sql语句,返回结果 -- 新增
			int rsCount = statement.executeUpdate("delete from user_ where  account='1234567';");
			
			System.out.println("该操作删除" + rsCount + "行");
			
			// 关闭资源
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
	//根据账号查询
	public void query() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输如账号");
		String accountInput = scan.nextLine();
		
		try {
			
			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");
			
			// 获取执行sql的PreparedStatement对象
			String sql = "select * from user_  where account = ? ";
			PreparedStatement statement = con.prepareStatement(sql);
			//statement.setString(1, accountInput);
			
			//System.out.println("sql="+sql);
			
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String account = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				//int sex = Integer.valueOf(rs.getString("sex"));
				double amount = Double.valueOf(rs.getString(8));
				
				System.out.println(account+","+name+","+password+","+amount);
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
	//根据账号更改
	public void update() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			
			// 执行sql语句,返回结果 -- 更改
			int rsCount = statement.executeUpdate("update usersset card='123456'where account ='3701111';");
			
			System.out.println("该操作更新" + rsCount + "行");
			
			// 关闭资源
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
