package com.atguigu.bean;

public class User {
	private String username;
	private String password;
	private int age;
	private Adress adress;
	
	public User(String username, String password, int age, Adress adress) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.adress = adress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", adress=" + adress + "]";
	}
	
	
}
