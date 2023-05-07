public class Main {
    public static void main(String[] args) {
        final Display b1 = new StringDisplay("Hello, world!");
        final Display b2 = new SideBorder(b1, '#');
        final Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        final Display b4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("Hello, word.")
                                        ),
                                        '*'
                                )
                        )
                ),
                '/'
        );
        b4.show();
    }
}