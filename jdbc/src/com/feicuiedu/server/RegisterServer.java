package com.feicuiedu.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.feicuiedu.dao.RegisterSelect;
import com.feicuiedu.dao.UserDao;
import com.feicuiedu.dao.UserSelect;
import com.feicuiedu.dao.jdbcDao;
import com.feicuiedu.entity.RegisterUser;

/**
 * 用户注册程序
 * 
 * @author www.99071491
 *
 */
public class RegisterServer {
	Scanner sc = new Scanner(System.in);
	private RegisterSelect rs1 = new RegisterSelect();

	/**
	 * 注册用户方法
	 * 
	 * @throws Exception
	 */
	public void openUser() throws Exception {
		boolean flag = true;

		while (flag) {

			System.out.println("请输入姓名");
			String name = sc.next();
			// 省份证账号
			System.out.println("请输入身份证号");
			String card = sc.next();
			if (!card.equals("^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$")) {

			} else {
				System.out.println("输入错误请重新输入");
				break;
			}

			// 姓名
			System.out.println("请输入性别(男；01，女；02)");
			String sex = sc.next();
			if (sex.equals("男")) {
				sex = "01";

			} else if (sex.equals("女")) {
				sex = "02";

			} else {
				System.out.println("输入有误请重新输入");
				openUser();

			}
			// 请输入出生年月
			System.out.println("请输入出生年月");
			String birthday = sc.next();

			// 原始余额
			double balance = 0.0;
			// 状态
			String state = "1";
			//
			String remark = "";
			// 账号
			int number = (int) ((Math.random() * 10) * 1000);
			String account = "BC18" + sex + birthday + number;
			System.out.println("开户成功");
			// 密码
			System.out.println("请输入密码");
			String password = sc.next();
			if (password.equals("^[a-z0-9A-Z]{0,6}")) {
				System.out.println("密码输入错误");
				openUser();

			}

			RegisterUser user = new RegisterUser(name, card, sex, birthday, balance, password, state, account, remark);
			// UserDao<RegisterUser> userDao = new jdbcDao<RegisterUser>();
			// List<RegisterUser> users = userDao.findAllByConditions(null,
			// RegisterUser.class);
			// for (RegisterUser ru : users) {
			// System.out.println(user);
			// }
			try {

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
				rs1.selsct();

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

		flag = false;

	}

	// 销户
	public void closing() throws Exception {
		System.out.println("请输入销户账号");

		String accountInput = sc.next();

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "update users set state= 2 where account =?; ";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, accountInput);
			rs1.selsct();
		

			

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

	// 检所普通账户正常登陆（主键，姓名，身份证，性别，账号，余额）
	public void query() throws Exception {

		//System.out.println("请输入账号");
		//String accountInput = sc.next();

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from users where state= 1";
			PreparedStatement statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String card = rs.getString(4);
				double balance = rs.getDouble(6);
				String account = rs.getString(8);

				System.out.println("主键:" + id + " 姓名:" + name + " 身份证:" + card + " 性别:" + sex + " 账号:" + account
						+ " 余额:" + balance);
				rs1.selsct();
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

	// 检索已销户账户（主键，姓名，身份证，性别，账号，余额，状态）
	public void query1() throws Exception {


		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象ad
			String sql = "select * from users where state=2 ";
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String card = rs.getString(4);
				double balance = rs.getDouble(6);
				String account = rs.getString(8);
				String state = rs.getString(9);

				System.out.println("主键:" + id + " 姓名:" + name + " 身份证:" + card + " 性别:" + sex + " 账号:" + account
						+ " 余额:" + balance + "状态" + state);
				rs1.selsct();
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

	// 检索锁定账户
	public void query2() throws Exception {

		

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象ad
			String sql = "select * from users where state=3 ";
			PreparedStatement statement = con.prepareStatement(sql);
			
			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String card = rs.getString(4);
				double balance = rs.getDouble(6);
				String account = rs.getString(8);
				String state = rs.getString(9);

				System.out.println("主键:" + id + " 姓名:" + name + " 身份证:" + card + " 性别:" + sex + " 账号:" + account
						+ " 余额:" + balance + "状态" + state);
				rs1.selsct();
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

	// 解除锁定账号
	public void relieve() throws Exception {
		System.out.println("请输入解锁定账号");
		String accountInput = sc.next();

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "update users set state= 1 where account =?; ";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, accountInput);
			rs1.selsct();

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

	// 重置密码
	public void reset() throws Exception {
		System.out.println("请输入销户账号");

		String accountInput = sc.next();

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
			
			// 获取执行sql的statement对象
			Statement statement = con.createStatement();
			
			// 执行sql语句,返回结果 -- 更改
			int rsCount = statement.executeUpdate("update users set password=?where account =?;");
			((PreparedStatement) statement).setString(1, accountInput);
			System.out.println("请输入密码");
			String password = sc.next();
			while(true) {
				if (password.equals("^[a-z0-9A-Z]{0,6}")) {
					System.out.println("密码输入错误");
					break;

				}else {
					int rsCount1 = statement.executeUpdate("update users set password=?where account =?;");
					((PreparedStatement) statement).setString(2, password);
				}
				
			}
			
			
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
