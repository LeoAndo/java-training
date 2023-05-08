/**
 * ファイルやディレクトリを訪れる訪問者を表す抽象クラス
 */
public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
