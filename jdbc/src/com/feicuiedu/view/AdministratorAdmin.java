package com.feicuiedu.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import com.feicuiedu.dao.RegisterSelect;

/**
 * 管理员登录
 * 
 * @author www.99071491
 *
 */
public class AdministratorAdmin {
	//Scanner sc = new Scanner(System.in);

	// 登录方法
	public void admin() throws Exception {

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from admin where id= 1 "
					+ "";
			PreparedStatement statement = con.prepareStatement(sql);
			// statement.setString(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				String name = rs.getString(2);
				String password = rs.getString(3);
				
                Scanner sc =new Scanner(System.in);
				//System.out.println("姓名"+name+"密码"+password);
				System.out.println("请输入账号");
				while (true) {
					String name1 = sc.next();
					if (name1.equals(name)) {

					} else {
						break;
					}
					System.out.println("请输入密码");
					String password1 = sc.next();
					if (password1.equals(password)) {
						
						RegisterSelect rs1=new RegisterSelect();
						rs1.selsct();

					} else {
						break;
					}
				}
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
