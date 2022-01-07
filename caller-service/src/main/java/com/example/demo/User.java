package com.example.demo;

import java.util.List;


public class User {

	private Integer id;

	private String name;

	private Integer age;
	
	Float salary;

	private List<Address> addresses;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="address_id", referencedColumnName = "id")
//	private Address address;
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

//	@UniqueConstraint(columnNames = "name")
	public void setName(String name) {
		this.name = name;
	}
}
