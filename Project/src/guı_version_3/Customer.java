package guı_version_3;

import java.util.ArrayList;

public class Customer implements Person {

	private String CustomerName;
	private String CustomerSurname;
	Address address;
	Phone phone;
	private int ID;
	private int IdentityNumber;
	private int roomId;

	public Customer(String customerName, String customerSurname, Address address, Phone phone, int identityNumber,int Id,int roomID) {
		super();
		CustomerName = customerName;
		CustomerSurname = customerSurname;
		this.address = address;
		this.phone = phone;
		IdentityNumber = identityNumber;
		this.ID = Id;
		this.roomId = roomID;
	}
        
        public Customer(String customerName, String customerSurname,int Id,int roomID) {
		super();
		CustomerName = customerName;
		CustomerSurname = customerSurname;
		this.address = address;
		this.phone = phone;
		this.ID = Id;
		this.roomId = roomID;
	}
	
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIdentityNumber() {
		return IdentityNumber;
	}

	public void setIdentityNumber(int identityNumber) {
		IdentityNumber = identityNumber;
	}

	@Override
	public String toString() {
		return "Custemer [CustomerName=" + CustomerName + ", CustomerSurname=" + CustomerSurname + ", address="
				+ address + ", phone=" + phone + ", ID=" + ID + ", IdentityNumber=" + IdentityNumber + "]";
	}

	@Override
	public String displayName() {
		return this.CustomerName;
	}

	@Override
	public void updateName(String name) {
		this.CustomerName = name;
	}

	@Override
	public String displaySurname() {
		return CustomerSurname;
	}

	@Override
	public void updateSurname(String surname) {
		this.CustomerSurname = surname;
	}

	@Override
	public Phone displayPhone() {
		return this.phone;
	}

	@Override
	public void updatePhone(int countryCode, int operatorCode, int number) {
		this.phone.setCountryCode(countryCode);
		this.phone.setOperatorCode(operatorCode);
		this.phone.setNumber(number);
	}

	@Override
	public Address displayAddress() {
		return this.address;
	}

	@Override
	public void updateAddress(String country, String city, String street, int zipCode) {
		this.address.setCountry(country);
		this.address.setCity(city);
		this.address.setStreet(street);
		this.address.setZipCode(zipCode);
	}
	
	public ArrayList<Object> displayCustomer() {

		ArrayList<Object> ret_list = new ArrayList<Object>();
		ret_list.add(CustomerName);
		ret_list.add(CustomerSurname);
		ret_list.add(phone.getNumber());
		ret_list.add(IdentityNumber);
		return ret_list;

	}

}
