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
        int[] results = IntStream.range(-5, 5).filter(x -> Math.floorMod(x, 2) == 0).toArray();
        for (int result : results) {
            System.out.println("floorMod: " + result);
        }
    }
}