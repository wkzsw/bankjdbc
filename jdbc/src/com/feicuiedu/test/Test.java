package com.feicuiedu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicuiedu.dao.UserSelect;
import com.feicuiedu.entity.RegisterUser;
import com.feicuiedu.server.UserServer;

public class Test {

	public static void main(String[] args)  {
		//RegisterServer rs=new RegisterServer();
		//rs.closing();
		RegisterUser user=new RegisterUser();
		UserServer us=new UserServer();
		UserSelect uss=new UserSelect();
		uss.query();
		//us.query1();
		/**try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "insert into users (name,sex,card,brithday,balance,password,state,account,remark)value (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);

			// statement.setInt(1, user.getId());
			statement.setString(1, user.getName());
			statement.setString(2, user.getSex());
			statement.setString(3, user.getCard());
			statement.setString(4, user.getBirthday());
			statement.setDouble(5, user.getBalance());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getState());
			statement.setString(8, user.getAccount());
			statement.setString(9, user.getRemark());

			// 执行sql语句,返回结果 -- 新增
			int rsCount = statement.executeUpdate();

			System.out.println("注册完成" + rsCount + "客户");

			// 调用选择方法
			//rs1.selsct();

			// 关闭资源
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
	
}
