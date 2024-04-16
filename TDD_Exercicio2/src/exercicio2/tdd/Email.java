package exercicio2.tdd;

public class Email {
	private String email;
	
	public Email(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isValidName() {
		return email.matches(".+@.+\\..+");
	}

}
