public class VolatileSample02 {
    private static volatile Person person; // メインメモリの変数に対して読み書きする

    //private static Person person; // 各スレッドの対応するキャッシュした変数に対して読み書きする
    // private static final Person person = new Person("Leo", 20);;
    public static void main(String[] args) {
        person = new Person("Leo", 20);
        new MultiThread1().start();
        new MultiThread2().start();
    }

    // Thread-0
    private static class MultiThread1 extends Thread {
        public void run() {
            while (person.getAge() < 25) {
                person.setAge(person.getAge() + 1); // カウントアップする.
                System.out.println(getName() + " : " + person.getAge());
            }
            System.out.println(getName() + " finish" + person.getAge());
        }
    }

    // Thread-1
    private static class MultiThread2 extends Thread {
        public void run() {
            while (person.getAge() < 25) {
                System.out.println(getName() + " : " + person.getAge());
            }
            System.out.println(getName() + " finish" + person.getAge());
        }
    }
}