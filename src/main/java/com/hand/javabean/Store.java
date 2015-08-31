package com.hand.javabean;

public class Store {
	private int storeId;
	private int managerStaffId;
	private int addressId;
	private Customer customer;
	private Address address;
	
	public Store(){}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public int getManagerStaffId() {
		return managerStaffId;
	}
	public void setManagerStaffId(int managerStaffId) {
		this.managerStaffId = managerStaffId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
