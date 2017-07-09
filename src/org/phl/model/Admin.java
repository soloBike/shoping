package org.phl.model;

public class Admin {
	public int admin_id;
	public String apass;

	public char aname;
	public char sex;
	public int age;
	public int tel;
	public String address;

	public char getName() {
		return aname;
	}

	public void setName(char name) {
		this.aname = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCustomer_id() {
		return admin_id;
	}

	public void setCustomer_id(int customer_id) {
		this.admin_id = customer_id;
	}

	public String getPassword() {
		return apass;
	}

	public void setPassword(String password) {
		apass = password;
	}

	public String toString() {
		return (new StringBuilder("User [admin_id=")).append(admin_id).append(", adminname=").append(aname)
				.append(", password=").append(apass).append("]").toString();
	}

}
