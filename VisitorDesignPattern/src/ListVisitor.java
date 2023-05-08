/**
 * ファイルやディレクトリの一覧を表示する
 * データ構造を渡り歩きながら一覧を表示する
 */
public class ListVisitor extends Visitor {
    // 現在注目しているディレクトリ名
    private String currentdir = "";

    /**
     * File訪問時
     *
     * @param file
     */
    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    /**
     * Directory訪問時
     *
     * @param directory
     */
    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        for (Entry entry : directory) {
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
