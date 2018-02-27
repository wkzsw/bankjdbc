package com.feicuiedu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.feicuiedu.server.RegisterServer;

public class RegisterSelect {
	Scanner sc=new Scanner(System.in);
	
	public void selsct() throws Exception {
		RegisterServer rs=new RegisterServer();
		System.out.println("1.注册 2.销户3.检索普通用户4.检索已销户账号5.检索锁定账号6.解除锁定账号7.重置密码");
		String number=sc.next();
		if("1".equals(number)) {
			number= "注册";
			
			rs.openUser();
			
		}else if("2".equals(number)) {
			number="销户";
			rs.closing();
		}else if("3".equals(number)) {
			number="检索普通账户";
			rs.query();
		}else if("4".equals(number)) {
			number="检索已销户账户";
			rs.query1();
			
		}else if("5".equals(number)) {
			number="检索锁定账户";
			rs.query2();
			
		}else if("6".equals(number)) {
			number="解除锁定账户";
			rs.relieve();
			
		}else if("7".equals(number)) {
			number="重置密码";
			rs.reset();
		}else {
			System.out.println("输入错误请重新输入");
		}

		
	}
	public void query() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from userselect2 where id= 1";
			PreparedStatement statement = con.prepareStatement(sql);
			
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				String register = rs.getString(2);
				String closing = rs.getString(3);
				String query = rs.getString(4);
				String queryclosing=rs.getString(5);
				String querylock=rs.getString(6);
				String unlock=rs.getString(7);
				String reset=rs.getString(8);

				System.out.println(register+ closing+query+queryclosing+querylock+unlock+reset);
				
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
