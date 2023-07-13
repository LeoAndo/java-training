/**
 * limitで指定した番号未満のトラブルを解決するクラス
 */
public class LimitSupport extends Support {
    private int limit; // この番号未満なら解決できる

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }
}
