package com.feicuiedu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.feicuiedu.view.AdministratorAdmin;
import com.feicuiedu.view.UserAdmin;

public class MainServer {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("****欢迎使用ATM****");
		query();
		String str = sc.next();
		while (true) {
			if ("1".equals(str)) {
				AdministratorAdmin aa = new AdministratorAdmin();
				aa.admin();
				// RegisterSelect rs=new RegisterSelect();
				// rs.selsct();
				break;
			} else if ("2".equals(str)) {
				UserAdmin ua = new UserAdmin();
				ua.admin();
				break;
			} else {
				break;
			}
		}

	}
	public static  void query() {
		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from selset1 where id= 1";
			PreparedStatement statement = con.prepareStatement(sql);
			//statement.setString(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				String admin = rs.getString(2);
				String user = rs.getString(3);

				System.out.println(admin+ user);
				
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
