import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ディレクトリを表すクラス
 */
public class Directory extends Entry implements Iterable<Entry> {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    /**
     * ディレクトリに含まれるディレクトリエントリ（ファイルやディレクトリ）の一覧を得るための
     * Iterator<Entry>を返す
     *
     * @return Iterator<Entry>
     */
    @Override
    public Iterator<Entry> iterator() {
        return directory.iterator();
    }
}
