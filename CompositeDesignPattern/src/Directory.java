import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private final String name;
    private final List<Entry> directories = new ArrayList<>();// サブディレクトリ

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directories) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directories) {
            entry.printList(prefix + "/" + name);
        }
    }

    // ディレクトリエントリをディレクトリに追加する
    public Entry add(Entry entry) {
        directories.add(entry);
        return this;
    }
}
