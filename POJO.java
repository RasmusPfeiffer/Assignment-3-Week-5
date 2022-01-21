package assignment3;

public class POJO {

	private String username;
	private String password;
	private String name;
	private int unsuccesfullLogins;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnsuccesfullLogins(int unsuccesfullLogins) {
		this.unsuccesfullLogins = unsuccesfullLogins;
	}
	
	public int getUnsuccesfullLogins() {
		return unsuccesfullLogins;
	}
}
