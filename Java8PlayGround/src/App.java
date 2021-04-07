import java.security.acl.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        delimiter();
        floorMod();
        comparing();
    }

    private static List<Person> persons = Arrays.asList(
        new Person("endo", "shozo"),
        new Person("endo", "akio"),
        new Person("ando", "akio"),
        new Person("wakita", "yoshio")
    );
    private static void comparing() {
        Comparator<Person> byLastName = Comparator.comparing(t -> t.lastName);
        // Comparator<Person> byName = byLastName.thenComparing(t -> t.firstName);
        Collections.sort(persons, byLastName);
        for (Person person : persons) {
            System.out.println("person: " + person.lastName + " " + person.firstName);
        }
    }

    private static void delimiter() {
        String a = "A";
        String b = "B";
        String c = "C";
        String value = String.join(", ", a, b, c);
        System.out.println("delimiter: " + value);
    }

    private static void floorMod() {
        int adjustment = -3;
        IntStream.rangeClosed(1, 12).forEach(x ->System.out.println("floorMod: " + Math.floorMod(x + adjustment, 12)));
    }
}