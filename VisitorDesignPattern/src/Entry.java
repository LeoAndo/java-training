/**
 * FileとDirectoryのスーパクラスとなる抽象クラス
 * (Acceptorインタフェースを実装)
 */
public abstract class Entry implements Element {
    public abstract String getName(); // 名前を得る

    public abstract int getSize(); // サイズを得る

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
