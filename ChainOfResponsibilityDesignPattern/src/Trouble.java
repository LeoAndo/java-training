/**
 * 発生したトラブルを表す
 */
public class Trouble {
    private int number; // トラブル番号

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}
