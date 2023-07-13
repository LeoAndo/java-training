/**
 * トラブルを解決する連鎖を作るためのクラス
 */
public abstract class Support {
    private String name; // このトラブル解決者の名前
    private Support next; // たらい回し先

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 解決しようとする
    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
