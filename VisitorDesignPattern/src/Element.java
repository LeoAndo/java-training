/**
 * Visitorクラスのインスタンスを受け入れるデータ構造を表すインタフェース
 */
public interface Element {
    public abstract void accept(Visitor v);
}
