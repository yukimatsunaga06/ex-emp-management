package jp.co.sample.domain;

public class Administor {
	private Integer ID;
	private String name;
	private String mail;
	private String password;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administor [ID=" + ID + ", name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}
	
}
