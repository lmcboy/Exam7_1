package com.hand.javabean;

import java.util.HashSet;
import java.util.Set;

public class Address {
	private int addressId;
	private String address;
	private String address2;
	private String district;
	private int cityId;
	private String postalCode;
	private String phone;
	private Set<Customer> customer = new HashSet<Customer>(0);
	private Set<Store> store = new HashSet<Store>(0);
	public Address(){}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
	public Set<Store> getStore() {
		return store;
	}
	public void setStore(Set<Store> store) {
		this.store = store;
	}
	
}
