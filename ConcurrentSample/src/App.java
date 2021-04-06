import java.util.stream.IntStream;

public class App {
    private static long counter = 0;
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable(){
            @Override
            public void run() {
                IntStream.range(0, 100).forEach(
                    i -> counter += 1
                );
                System.out.println("counter: " + counter);
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                IntStream.range(0, 100).forEach(
                    i -> counter += 1
                );
                System.out.println("counter: " + counter);
            }
        }).start();
    }
}
