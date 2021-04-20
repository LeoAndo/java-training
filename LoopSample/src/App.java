public class App {
    public static void main(String[] args) throws Exception {
        testWhileLoop();
    }

    private static void testWhileLoop() {
        int num = 0;

        while(num < 5) {
            System.out.println(num);
            num++;
        }
    }
}
