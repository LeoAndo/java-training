public class App {
    public static void main(String[] args) throws Exception {
        overFlowInt();
        overFlowFloat();
        overFlowDouble();
        underFlowFloat();
        underFlowDouble();
    }

    private static void underFlowDouble() {
        System.out.println("==========underFlowDouble-START==========");
        System.out.println(Double.MIN_VALUE / 2.0D);
        System.out.println("==========underFlowDouble-END==========");
    }

    // 浮動小数点の演算で、アンダーフローすると計算結果が0.0になる.
    private static void underFlowFloat() {
        System.out.println("==========underFlowFloat-START==========");
        System.out.println(Float.MIN_VALUE / 2.0F);
        System.out.println("==========underFlowFloat-END==========");
    }

    // 浮動小数点の範囲をオーバーフローするコード.
    private static void overFlowDouble() {
        System.out.println("==========overFlowDouble-START==========");
        System.out.println(Double.MAX_VALUE * 2.0D); // 正の無限大
        System.out.println(-Double.MAX_VALUE * 2.0D); // 負の無限大
        System.out.println("==========overFlowDouble-START==========");
    }

    // 浮動小数点の範囲をオーバーフローするコード.
    private static void overFlowFloat() {
        System.out.println("==========overFlowFloat-START==========");
        System.out.println(Float.MAX_VALUE * 2.0F); // 正の無限大
        System.out.println(-Float.MAX_VALUE * 2.0F); // 負の無限大
        System.out.println("==========overFlowFloat-START==========");
    }

    // Intの範囲をオーバーフローするコード.
    private static void overFlowInt() {
        System.out.println("==========overFlowInt-START==========");
        try {
            System.out.println(Math.addExact(Integer.MAX_VALUE, 1));
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
        System.out.println("==========overFlowInt-END==========");
    }
}
