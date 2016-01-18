package com.manifera.meshop.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Embeddable
public class Billing implements Serializable {
	
	private static final long serialVersionUID = -1800664183680083149L;

	@Column(name = "billing_first_name")
	private String firstName;
	
	@Column(name = "billing_last_name")
	private String lastName;
	
	@Column(name = "billing_company")
	private String company;
	
	@Column(name = "billing_address")
	private String address;
	
	@Column(name = "billing_company_address")
	private String companyAddress;
	
	@Column(name = "billing_city")
	private String city;
	
	@Column(name = "billing_phone")
	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "billing_country_id")
	private Country country;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
