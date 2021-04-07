public class App {
    public static void main(String[] args) throws Exception {
        delimiter();
    }

    private static void delimiter() {
        String a = "A";
        String b = "B";
        String c = "C";
        String value = String.join(", ", a, b, c);
        System.out.println("delimiter: " + value);
    }
}