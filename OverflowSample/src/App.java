public class App {
    public static void main(String[] args) throws Exception {
        // int: オーバーフロー.
        // System.out.println(Math.addExact(Integer.MAX_VALUE, 1)); // Exception in thread "main" java.lang.ArithmeticException: integer overflow

        
        System.out.println(Math.atan2(Double.MAX_VALUE, 1));
    }
}
