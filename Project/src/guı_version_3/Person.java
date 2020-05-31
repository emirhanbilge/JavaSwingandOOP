package guı_version_3;
public interface Person {

	String displayName();

	void updateName(String name);

	String displaySurname();

	void updateSurname(String surname);

	Phone displayPhone();

	void updatePhone(int countryCode, int operatorCode, int number);

	Address displayAddress();

	void updateAddress(String country, String city, String street, int zipCode);
}
