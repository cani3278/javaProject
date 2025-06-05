package Model;

import java.util.Objects;

public class Person {
	private String id;
    private String name;
  
	private String email;
    private String phone;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName()) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), email);
    }

    public Person(String id, String name, String email) {
    	this.id=id;
        this.name = name;
        this.email = email;

    }
    public Person(String id, String name, String email,String phone) {
    	this(id,name,phone);
        this.phone=phone;

    }
    public String getId() {
  		return id;
  	}

  	public void setId(String id) {
  		this.id = id;
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

  	public String getPhone() {
  		return phone;
  	}

  	public void setPhone(String phone) {
  		this.phone = phone;
  	}

}
