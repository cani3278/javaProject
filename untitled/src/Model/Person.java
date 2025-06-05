package Model;

import java.util.Objects;

public class Person {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


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

    public Person(String name, String email) {
        this.name = name;
        this.email = email;

    }
}
