import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        delimiter();
        floorMod();
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