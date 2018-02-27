package com.feicuiedu.entity;

import com.feicuiedu.dao.Column;
import com.feicuiedu.dao.Entity;
import com.feicuiedu.dao.Id;

@Entity("user_")
public class User {
	//主键
	@Id("id")
	private int userId;
	//姓名
	@Column("userName")
	private String userName;
	//原账号
	@Column("userAccount")
    private String userAccount;
    //目标账户
	@Column("userOrAccount")
    private String userOrAccount;
    //账务类型
	@Column("userType")
    private String userType;
    //账务时
	@Column("userTime")
    private String userTime;
    //交易金额
	@Column("value =userBalance")
    private Double  userBalance;
    //交易后金额
	@Column("value =userAlBalance")
    private Double  userAlBalance;
    //备注
	@Column("remark")
    private String remark;
    
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserOrAccount() {
		return userOrAccount;
	}
	public void setUserOrAccount(String userOrAccount) {
		this.userOrAccount = userOrAccount;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserTime() {
		return userTime;
	}
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	public Double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}
	public Double getUserAlBalance() {
		return userAlBalance;
	}
	public void setUserAlBalance(Double userAlBalance) {
		this.userAlBalance = userAlBalance;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAccount=" + userAccount + ", userOrAccount="
				+ userOrAccount + ", userType=" + userType + ", userTime=" + userTime + ", userBalance=" + userBalance
				+ ", userAlBalance=" + userAlBalance + ", remark=" + remark + "]";
	}
    
    

    

	

}
