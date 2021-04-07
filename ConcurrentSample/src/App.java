import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class App {
    private static AtomicLong counter = new AtomicLong();
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable(){
            @Override
            public void run() {
                IntStream.range(0, 100).forEach(
                    i -> counter.incrementAndGet()
                );
                System.out.println("counter: " + counter);
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                IntStream.range(0, 100).forEach(
                    i -> counter.incrementAndGet()
                );
                System.out.println("counter: " + counter);
            }
        }).start();
    }
}
