package com.feicuiedu.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.feicuiedu.dao.UserSelect;
import com.feicuiedu.entity.RegisterUser;

/**
 * 普通用户登录
 * 
 * @author www.99071491
 *
 */
public class UserAdmin {
	// 登录方法
	public void admin() {
		Scanner sc = new Scanner(System.in);
		String accountInput = sc.next();

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from users where account = ? ";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String card = rs.getString(4);
				String password = rs.getString(7);
				String account = rs.getString(8);
				// System.out.println(card+password+account);
				System.out.println("请输入账号");
				while (true) {
					if (account.equals(accountInput) || card.equals(accountInput)) {
						System.out.println("请输入密码");
						String password1 = sc.next();
						if (password.equals(password1)) {
							System.out.println("登陆成功");
							UserSelect us = new UserSelect();
							us.selsct();
						} else {
							System.out.println("密码错误请重新输入");
							break;
						}

					} else {
						System.out.println("账号错误重新输入");
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
