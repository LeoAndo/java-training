/**
 * 指定した番号のトラブルに限って解決するクラス
 */
public class SpecialSupport extends Support {
    private int number; // この番号未満なら解決できる

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
