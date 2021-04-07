import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
/**
 * Playground.
 */
public class App {
    public static void main(String[] args) throws Exception {
        delimiter();
        floorMod();
        comparing();
        equalsObject();
    }

    private static void equalsObject() {
        System.out.println("==========equalsObject-START==========");
        Person p1 = new Person("endo", "shozo");
        Person p2 = new Person("endo", "shozo");
        Person p3 = new Person("endo", "dayo");

        boolean isEquals = p1.equals(p2);
        boolean isEquals2 = p1.equals(p3);
        System.out.println("isEquals: " + isEquals);
        System.out.println("isEquals2: " + isEquals2);
        System.out.println("==========equalsObject-END==========");
    }

    private static List<Person> persons = Arrays.asList(
        new Person("endo", "shozo"),
        new Person("endo", "akio"),
        new Person("anzai", "akio"),
        new Person("wakita", "yoshio")
    );
    private static void comparing() {
        Comparator<Person> byLastName = Comparator.comparing(t -> t.lastName);
        Comparator<Person> byFullName = byLastName.thenComparing(t -> t.firstName);
        Collections.sort(persons, byFullName);
        for (Person person : persons) {
            System.out.println("person: " + person.lastName + " " + person.firstName);
        }

        System.out.println("======== sort by lastName Length. ========");
        Comparator<Person> lastNameLength = Comparator.comparingInt(t -> t.lastName.length());
        Collections.sort(persons, lastNameLength);
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