package guı_version_3;
public class Phone {

	private int CountryCode;
	private int OperatorCode;
	private int Number;
	
	
	
	public Phone(int countryCode, int operatorCode, int number) {
		CountryCode = countryCode;
		OperatorCode = operatorCode;
		Number = number;
	}
	public int getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(int countryCode) {
		CountryCode = countryCode;
	}
	public int getOperatorCode() {
		return OperatorCode;
	}
	public void setOperatorCode(int operatorCode) {
		OperatorCode = operatorCode;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	
	public void UpdateNumber(int countryCode, int operatorCode, int number) {
		CountryCode = countryCode;
		OperatorCode = operatorCode;
		Number = number;
	}
	@Override
	public String toString() {
		return "Phone [CountryCode=" + CountryCode + ", OperatorCode=" + OperatorCode + ", Number=" + Number + "]";
	}
	
	
	
}
