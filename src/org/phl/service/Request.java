package org.phl.service;

import java.io.Serializable;

import org.phl.model.Car;

public class Request implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LOGIN_MESSAGE = 0;
	public static final int REGISTER_MESSAGE = 1;
	public static final int SEARCH_MESSAGE = 2;
	public static final int OFFLINE_MESSAGE = 3;
	public static final int PAY_MESSAGE = 4;
	private int type;
	private String user_name;
	private String Password;
	private String GoodsName;
	private Car car;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public static int getLoginMessage() {
		return LOGIN_MESSAGE;
	}

	public static int getRegisterMessage() {
		return REGISTER_MESSAGE;
	}

	public static int getSearchMessage() {
		return SEARCH_MESSAGE;
	}

	public static int getOfflineMessage() {
		return OFFLINE_MESSAGE;
	}

	public static int getPayMessage() {
		return PAY_MESSAGE;
	}

	public String toString() {
		if (type == 0)
			return (new StringBuilder("\u767B\u5F55\u7528\u6237\u540D\uFF1A[")).append(user_name)
					.append("],\u5BC6\u7801\uFF1A[").append(Password).append("]").toString();
		if (type == 1)
			return (new StringBuilder("\u6CE8\u518C\u7528\u6237\u540D\uFF1A[")).append(user_name)
					.append("],\u5BC6\u7801\uFF1A[").append(Password).append("]").toString();
		if (type == 2)
			return (new StringBuilder("\u60F3\u8981\u67E5\u627E\u7684\u5546\u54C1\u540D\u79F0\uFF1A["))
					.append(GoodsName).append("]").toString();
		if (type == 3)
			return "\u6211\u8981\u4E0B\u7EBF\u4E86";
		else
			return (new StringBuilder("\u8D2D\u7269\u8F66\u4E3A\uFF1A")).append(car).toString();
	}

	public Request() {

	}

}
