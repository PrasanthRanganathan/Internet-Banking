package banking.dto;

import java.io.InputStream;



public class Loan {

	private String name;
	private String dob;
	private String address;
	private String number;
	private InputStream stmt;
	private InputStream photo;
	private InputStream sign;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public InputStream getStmt() {
		return stmt;
	}

	public void setStmt(InputStream stmt) {
		this.stmt = stmt;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

	public InputStream getSign() {
		return sign;
	}

	public void setSign(InputStream sign) {
		this.sign = sign;
	}

	

	

}
