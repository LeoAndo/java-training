import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        calcMarumeGosa();
        calcKetaochi();
    }

    private static void calcKetaochi() {
        // float型や double型の有効桁数について
        // float型では10進数で約7桁(2進数で24桁)、double型では10進数で約16桁(2進数で53桁)となる.

        System.out.println("==========calcKetaochi-START==========");
        float d1 = 316.229347152F; // ≈ √(100001) 浮動小数点で表すと、 0.3162293 * 10^3
        float d2 = 316.227766017F; // ≈ √(100000) 浮動小数点で表すと、 0.3162278 * 10^3 (floatの有効桁数に収まらない数字は四捨五入.)
        float d3 = d1 - d2; // (0.3162293 * 10^3) - (0.3162278 * 10^3) = 0.0015 ≈ 0.15 * 10^-2
        // 0.15: 減算結果の有効桁数が2桁に減り、コンピュータの浮動小数点形式では、
        // 計算の結果失われた下位の桁を0で埋めるため、0.1500000 になり、埋めた0の部分が桁落ちして計算の誤差が起きる.
        System.out.println(d3); // 期待値: 10進数では0.001581135で、正規化すると1.581135e-3
        System.out.println();
        BigDecimal b = new BigDecimal("316.229347152");
        BigDecimal b2 = new BigDecimal("316.227766017");
        System.out.println(b.subtract(b2).toPlainString()); // 期待値: 10進数では0.001581135で、正規化すると1.581135e-3
        System.out.println();

        double d4 = 0.123456789012345D; // → 1.23456789012345e-1
        double d5 = 0.123456789012344D; // → 1.23456789012344e-1
        double d6 = d4 - d5;
        System.out.println(d6); // 期待値: 1e-15, 桁落ちで計算結果が期待値にならない.
        System.out.println();
        BigDecimal b3 = new BigDecimal("0.123456789012345");
        BigDecimal b4 = new BigDecimal("0.123456789012344");
        System.out.println(b3.subtract(b4).toPlainString()); // 期待値: 10進数では0.000000000000001で、正規化すると1e-15

        System.out.println("==========calcKetaochi-END==========");
    }

    private static void calcMarumeGosa() {
        System.out.println("==========calcMarumeGosa-START==========");
        System.out.println(0.5D + 0.5D + 0.5D + 0.5D + 0.5D + 0.5D); // 0.5は2進数への変換で循環小数にならないので、計算結果が期待値通りになる。
        System.out.println(0.5F + 0.5F + 0.5F + 0.5F + 0.5F + 0.5F);
        System.out.println();

        System.out.println(0.3D + 0.3D + 0.3D); // 0.3は2進数への変換で循環小数になるので、丸め誤差で計算結果が期待値通りにならない。
        System.out.println(0.3F + 0.3F + 0.3F);
        System.out.println();

        BigDecimal data = new BigDecimal("0.3"); // 小数点の計算は、BigDecimalを使うと誤差が出ないので良い！
        System.out.println(data.add(data).add(data));
        System.out.println("==========calcMarumeGosa-END==========");
    }
}
