package org.phl.model;

import java.io.Serializable;

public class User implements Serializable {
	public int user_id;
	public String user_name;
	public int age;
	public char sex;
	public int tel;
	public String Password;
	public String RePassword;

	public User() {
		super();
		this.setName(user_name);
		this.setPassword(Password);
		this.setRePassword(RePassword);
	}

	public String getRePassword() {
		return RePassword;
	}

	public void setRePassword(String rePassword) {
		RePassword = rePassword;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String name) {
		this.user_name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String toString() {
		return (new StringBuilder("Admin [user_id=")).append(user_id).append(", user_name=").append(user_name)
				.append(", Password=").append(Password).append("]").toString();
	}

}
