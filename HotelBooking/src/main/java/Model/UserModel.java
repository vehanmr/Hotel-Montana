package Model;

public class UserModel {
	
	int userid,contact;
	String name,email,gender,password,cat;
	
	public UserModel(int userid, int contact, String name, String email, String gender, String password, String cat) {
		
		this.userid = userid;
		this.contact = contact;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.cat = cat;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
	
	

}
