package Model;

public class RegisterUser {
//	name,email,password,gender,country
	private String name;
    private String email;
    private String password;
    private String gender;
    private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public RegisterUser(String name, String email, String password, String gender, String country) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.country = country;
	}
	@Override
	public String toString() {
		return "RegisterUser [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender
				+ ", country=" + country + "]";
	}
    
    

}
