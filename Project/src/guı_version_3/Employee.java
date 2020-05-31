
package guı_version_3;
import java.util.ArrayList;

public class Employee implements Person {
	private int employee_id;
	private String employeeName;
	private String employeSurname;
	Address address;
	Phone phone;
	ArrayList<Customer> customers;
	private int salary;
	private String department;

	public Employee(String employeeName, String employeSurname, Address address, Phone phone, String department,
			int employee_id) {
		super();
		this.employeeName = employeeName;
		this.employeSurname = employeSurname;
		this.address = address;
		this.phone = phone;
		this.salary = 2500;
		this.department = department;
		this.employee_id = employee_id;
		this.customers = new ArrayList<Customer>();
	}

	public Employee(int employee_id, String employeeName, String employeSurname, Address address, Phone phone,
			int salary, String department) {
		super();
		this.employee_id = employee_id;
		this.employeeName = employeeName;
		this.employeSurname = employeSurname;
		this.address = address;
		this.phone = phone;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String displayName() {

		return employeeName;
	}

	@Override
	public void updateName(String name) {
		this.employeeName = name;

	}

	@Override
	public String displaySurname() {

		return employeSurname;
	}

	@Override
	public void updateSurname(String surname) {
		this.employeSurname = surname;

	}

	@Override
	public Phone displayPhone() {

		return phone;
	}

	@Override
	public void updatePhone(int countryCode, int operatorCode, int number) {
		this.phone.setCountryCode(countryCode);
		this.phone.setOperatorCode(operatorCode);
		this.phone.setNumber(number);

	}

	@Override
	public Address displayAddress() {

		return address;
	}

	@Override
	public void updateAddress(String country, String city, String street, int zipCode) {
		this.address.setCountry(country);
		this.address.setCity(city);
		this.address.setStreet(street);
		this.address.setZipCode(zipCode);

	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void addCustomer(Customer e) {
		this.customers.add(e);
		SalaryIncrese();
	}

	public String printCustomer() {
		String cus = "";
		for (Customer customer : customers) {
			cus += customer.getID() + " " + customer.displayName() + " " + customer.displaySurname() + "\n";
		}
		return cus;
	}

	public void SalaryIncrese() {
		this.salary += customers.size() * 100;
	}

	public int getSalary() {
		return salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employeeName=" + employeeName + ", employeSurname="
				+ employeSurname + ", address=" + address + ", phone=" + phone + ", customers=" + customers
				+ ", salary=" + salary + ", department=" + department + "]";
	}

	public ArrayList<Object> displayEmployee() {	
		ArrayList<Object>employeList=new ArrayList<Object>();
		employeList.add(employee_id);
		employeList.add(employeeName);
		employeList.add(employeSurname);
		employeList.add(salary);
		employeList.add(department);
		return employeList;
	}

}