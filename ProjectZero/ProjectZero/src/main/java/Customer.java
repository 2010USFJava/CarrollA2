import java.util.ArrayList;

public class Customer {
	private String firstName;
	private String lastName;
	private String birthday;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String username;
	private String password;
	private ArrayList<Integer> accountId;
	private int customerId;
	
	protected Customer() {
	
	}
	protected Customer(String firstName, String lastName, String birthday, String street, String city, String state,
			String zip, String username, String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.username = username;
		this.password = password;
	}
	protected Customer(int accountId, int customerId, Customer customer) {
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.birthday = getBirthday();
		this.street = getStreet();
		this.city = getCity();
		this.state = getState();
		this.zip = getZip();
		this.username = getUsername();
		this.password = getPassword();
		this.accountId.add(accountId);
		this.customerId = customerId;
	}
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public ArrayList<Integer> getAccountId() {
		return accountId;
	}
	public void setAccountId(Account account) {
		this.accountId.add(account.getAccountId());
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
