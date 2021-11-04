package jp.co.sample.form;

public class InsertAdministratorForm {
	private String name;
	private String mailAdress;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAdress=" + mailAdress + ", password=" + password + "]";
	}
	
}
