package com.feicuiedu.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.feicuiedu.dao.UserSelect;
import com.feicuiedu.entity.User;

/**
 * 用户运行系统
 * 
 * @author www.99071491
 *
 */
public class UserServer {
	Scanner sc = new Scanner(System.in);
	User user = new User();
	//UserSelect us = new UserSelect();

	/**
	 * 存款
	 */
	public void deposit() {
		
		System.out.println("请输入存款金额");
		double index = Double.valueOf(sc.nextLine());
		//System.out.println("1.确认  2.重新输入 3.返回菜单");
		query1();
		String number = sc.next();
		while (true) {
			if ("1".equals(number)) {
				System.out.println("账户姓名:" + user.getUserName());
				double balance = index + user.getUserBalance();
				System.out.println("余额" + balance);
				System.out.println("存款成功");
				user.setUserBalance(balance);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
				// 义字符串的形式显示
				String time = format.format(Calendar.getInstance().getTime());
				user.setUserTime(time);
				// 列表
				StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您存入了：" + index
			     + "元钱。");
				User user=new User();

			} else if ("2".equals(number)) {
				
				break;
				

			} else if ("3".equals(number)) {
				// UserSelect us=new UserSelect();
                 break;
				//us.selsct();
			} else {
				System.out.println("请重新输入");
				// UserSelect us=new UserSelect();
				//us.selsct();
				break;
			}

		}

	}

	// 取款
	public void withdrawal() {
		System.out.println("请输入取款金额");
		double index = Double.valueOf(sc.nextLine());
		//System.out.println("1.确认2.重新输入3.返回菜单");
		query1();
		String number = sc.next();
		while (true) {
			if ("1".equals(number)) {
				if (index < user.getUserBalance()) {
					System.out.println("请输入取款金额");
					System.out.println("账户姓名" + user.getUserName());
					double balance = user.getUserBalance() - index;
					System.out.println("余额" + balance);
					// 时间
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
					// 义字符串的形式显示
					String time = format.format(Calendar.getInstance().getTime());
					// 列表
					// StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您存入了：" + index
					// + "元钱。");
					user.setUserBalance(balance);
					user.setUserTime(time);

				} else if (index > user.getUserBalance()) {
					System.out.println("余额不足请重新输入");
					break;

				} else {
					System.out.println("余额不足请重新输入");
					break;
				}

			} else if ("2".equals(number)) {
				System.out.println("请重新输入取款金额");
				double index1 = Double.valueOf(sc.nextLine());
				if (index < user.getUserBalance()) {
					System.out.println("请输入取款金额");
					System.out.println("账户姓名" + user.getUserName());
					double balance = user.getUserBalance() - index1;
					System.out.println("余额" + balance);
					// 时间
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
					// 义字符串的形式显示
					String time = format.format(Calendar.getInstance().getTime());
					user.setUserTime(time);
					// 列表
					// StringBuffer flow = new StringBuffer("时间:" + time + "交易记录:" + "您存入了：" + index
					// + "元钱。");
					user.setUserBalance(balance);

				} else if (index > user.getUserBalance()) {
					System.out.println("余额不足请重新输入");
					break;

				} else {
					System.out.println("余额不足请重新输入");
					break;
				}
			} else if ("3".equals(number)) {
				break;

			} else {
				break;
			}

		}

	}

	// 转账
	public void transfer() {
		System.out.println("请输入对方账号");
		String userOrAccount = sc.next();
		System.out.println("请输入转账金额");
		double money = Double.valueOf(sc.next());
		query1();
		String number = sc.next();
		while (true) {
			if ("1".equals(number)) {

			}
		}

	}

	// 查询(账务流水号|源账户|目标账户|账务类型|账务时间|交易金额|交易后账户金额)
	/*
	 * public void query(User user) { System.out.println("账户名"+user.getUserName());
	 * System.out.println("余额"+user.getUserBalance()); System.out.println("1.返回上级");
	 * String number=sc.next(); while (true) { if("1".equals(number)) { UserSelect
	 * us=new UserSelect(); us.selsct(); }else { System.out.println("输入错误");
	 * UserSelect us=new UserSelect(); us.selsct(); } }
	 * 
	 * }
	 */
	// 查询
	public void query() {

		System.out.println("请输如账号");
		int accountInput = sc.nextInt();

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from userad  where userId = ? ";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String card = rs.getString(3);
				// int sex = Integer.valueOf(rs.getString("sex"));
				String sex = rs.getString(4);
				String account = rs.getString(7);
				double balance = rs.getDouble(6);

				System.out.println(
						"主键:" + id + "姓名:" + name + "身份证:" + card + "性别:" + sex + "账号:" + account + "余额:" + balance);
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
	//选择列表
	public void query1() {

		try {

			// 注册驱动,创建连接
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root",
					"123456");

			// 获取执行sql的PreparedStatement对象
			String sql = "select * from userselect where id= 1";
			PreparedStatement statement = con.prepareStatement(sql);
			//statement.setString(1, accountInput);

			// System.out.println("sql="+sql);

			// 执行sql语句,返回结果 -- 查询
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				String notarize = rs.getString(2);
				String resume = rs.getString(3);
				String exit = rs.getString(4);
				

				System.out.println(notarize+resume+exit);
				
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
