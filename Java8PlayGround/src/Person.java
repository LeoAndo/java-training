import java.util.Objects;

public class Person {
    String lastName;
    String firstName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // 同値比較できるようにする.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return Objects.equals(lastName, p.lastName) && Objects.equals(firstName, p.firstName);
        }
        return false;
    }
}