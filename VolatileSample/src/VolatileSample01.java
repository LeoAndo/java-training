public class VolatileSample01 {
    private static volatile int count = 0; // メインメモリの変数に対して読み書きする
    //private static int count = 0; // 各スレッドの対応するキャッシュした変数に対して読み書きする

    public static void main(String[] args) {
        new MultiThread1().start();
        new MultiThread2().start();
    }

    // Thread-0
    private static class MultiThread1 extends Thread {
        public void run() {
            while (count < 10) {
                count++; // カウントアップする.
                System.out.printf("%s: after count = %d\n", getName(), count);
            }
            System.out.println("Thread-0 finish" + count);
        }
    }

    // Thread-1
    private static class MultiThread2 extends Thread {
        public void run() {
            while (count < 10) {}
            System.out.println("Thread-1 finish" + count);
        }
    }
}