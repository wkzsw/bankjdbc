package com.feicuiedu.entity;

import com.feicuiedu.dao.Column;
import com.feicuiedu.dao.Entity;
import com.feicuiedu.dao.Id;

@Entity("user_")
public class RegisterUser {
	//主键字段
	@Id("id")
	private int id;
	//姓名
	@Column("name")
	private String name;
	//省份证
	@Column("card")
    private String card;
    //性别
	@Column("sex")
    private String sex;
    //出生日期
	@Column("birthday")
    private String birthday;
    //余额
	@Column("value =balance")
    private Double balance;
    //密码
	@Column("password")
    private String password;
    //账号
	@Column("account")
    private String account;
	//状态
	//@Column("state")
	private String state;
    //备注
	@Column("remark")
    private String remark;
    
    public RegisterUser() {
    	
    }
    public RegisterUser(String name,String card,String sex,String birthday,Double balance,String password,String state,String account,String remark) {
    	//this.id=id;
    	this.name=name;
    	this.card=card;
    	this.sex=sex;
    	this.birthday=birthday;
    	this.balance=balance;
    	this.password=password;
    	this.state=state;
    	this.account=account;
    	this.remark=remark;
    	
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String  getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "RegisterUser [id=" + id + ", name=" + name + ", card=" + card + ", sex=" + sex + ", birthday="
				+ birthday + ", balance=" + balance + ", password=" + password + ", account=" + account + ", state="
				+ state + ", remark=" + remark + "]";
	}
    
    
	
    

    
   
    

}
