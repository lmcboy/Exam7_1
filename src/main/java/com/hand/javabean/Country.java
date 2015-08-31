package com.hand.javabean;

import java.util.HashSet;
import java.util.Set;

public class Country {
	private int countryId;
	private String country;
	private Set<City> city = new HashSet<City>(0);
	public Country(){}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Set<City> getCity() {
		return city;
	}
	public void setCity(Set<City> city) {
		this.city = city;
	}
	
	
}
