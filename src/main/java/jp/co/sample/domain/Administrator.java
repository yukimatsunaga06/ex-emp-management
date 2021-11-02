package jp.co.sample.domain;
/**
 * 管理者情報を表すドメイン
 * 
 * @author yukimatsunaga
 *
 */

public class Administrator {
	private Integer id;
	private String name;
	private String mailAdress;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		return "Administor [id=" + id + ", name=" + name + ", mailAdress=" + mailAdress + ", password=" + password
				+ "]";
	}
	
	
}
