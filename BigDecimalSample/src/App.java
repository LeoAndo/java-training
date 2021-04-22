import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        calcDouble();
    }

    private static void calcDouble() {
        System.out.println(0.5D + 0.5D + 0.5D + 0.5D + 0.5D + 0.5D); // 0.5は2進数への変換で循環小数にならないので、計算結果が期待値通りになる。
        System.out.println(0.3D + 0.3D + 0.3D); // 0.3は2進数への変換で循環小数になるので、計算結果が期待値通りにならない。
        BigDecimal data = new BigDecimal("0.3"); // 小数点の計算は、BigDecimalを使うと誤差が出ないので良い！
        System.out.println(data.add(data).add(data));
    }
}
