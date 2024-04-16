package exercicio2.tdd;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String emails; 

    public Person(Integer id, String name, Integer age, String email, String emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails;
        
    }
    
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public void setEmails(String emails) {
		this.emails = emails;
	}


	public boolean isValidName() {
        return name.matches("[a-zA-Z]+( [a-zA-Z]+)+"); // Verifica se o nome tem pelo menos duas partes e contém apenas letras
    }

    public boolean isValidAge() {
        return age >= 1 && age <= 200; // Verifica se a idade está no intervalo [1, 200]
    }

    public boolean hasEmails() {
        return emails != null && !emails.isEmpty(); // Verifica se há pelo menos um email associado
    }

    public String getEmails() {
        return emails;
    }
}
