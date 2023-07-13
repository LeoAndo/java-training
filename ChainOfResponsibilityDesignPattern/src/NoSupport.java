/**
 * 自分では何も問題を解決しないクラス
 */
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false; // 自分は何も解決しない
    }
}
