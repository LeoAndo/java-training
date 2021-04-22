public class App {
    public static void main(String[] args) throws Exception {
        testWhileLoop();
        testDoWhileLoop();
    }

    private static void testWhileLoop() {
        System.out.println("============testWhileLoop-START===========");
        int num = 0;

        while(num < 5) {
            System.out.println(num);
            num++;
        }
        System.out.println("============testWhileLoop-END===========");
    }

    private static void testDoWhileLoop() {
    }
}
