package com.atguigu.bean;

public class Adress {
	private String province;
	private String city;
	private String country;
	
	public Adress(String province, String city, String country) {
		this.province = province;
		this.city = city;
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "[province=" + province + ", city=" + city + ", country=" + country + "]";
	}
	
}
