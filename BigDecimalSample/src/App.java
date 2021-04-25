import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        calcMarumeGosa();
        calcKetaochi();
        calcJyohoOchi();
        calcUchikiriGosa();
    }

    private static void calcUchikiriGosa() {
        System.out.println("==========calcUchikiriGosa-START==========");
        System.out.println(10.0F / 3.0F); // 演算結果の無限桁数をfloatの有効桁数で打ち切る.
        System.out.println(10.0D / 3.0D); // 演算結果の無限桁数をdoubleの有効桁数で打ち切る.
        System.out.println(new BigDecimal("10.0").divide(new BigDecimal("3.0"), 2, BigDecimal.ROUND_HALF_UP)); // 小数点２桁まで計算する.
        System.out.println("==========calcUchikiriGosa-END==========");
    }

    private static void calcJyohoOchi() {
        System.out.println("==========calcJyohoOchi-START==========");
        System.out.println(1234567890.0D + 0.123456789D);// 期待値: 1.234567890123456789E9, 実行結果: 1.2345678901234567E9
        System.out.println(1234567890.0D + 0.1234567D);// doubleの有効桁数の範囲で収まるので、期待通りの計算結果になる。
        System.out.println();

        System.out.println(12345.0F + 0.1234F);// 期待値: 12345.1234, 実行結果: 12345.123
        System.out.println(12345.0F + 0.123F);// floatの有効桁数の範囲で収まるので、期待通りの計算結果になる。
        System.out.println();

        System.out.println(new BigDecimal("1234567890.0").add(new BigDecimal("0.123456789")));
        System.out.println(new BigDecimal("12345.0").add(new BigDecimal("0.1234")));

        System.out.println("==========calcJyohoOchi-END==========");
    }

    private static void calcKetaochi() {
        // float型や double型の有効桁数について
        // float型では10進数で約7桁(2進数で24桁)、double型では10進数で約16桁(2進数で53桁)となる.

        System.out.println("==========calcKetaochi-START==========");
        float d1 = 123.456789F; // 浮動小数点数で表すと、 0.1234568 * 10^3 (floatの有効桁数に収まらない数字は四捨五入.)
        float d2 = 123.455555F; // 浮動小数点数で表すと、 0.1234556 * 10^3 
        float d3 = d1 - d2; // 0.1234568 - 0.1234556 = 0.0000012 ≈ 0.12 * 10^-5
        // 0.12: 減算結果の有効桁数が2桁に減り、コンピュータの浮動小数点形式では、計算の結果失われた下位の桁を0で埋めるため、
        // 0.1200000 になり、埋めた0の部分が桁落ちして計算誤差が起きる.
        System.out.println(d3); // 期待値: 10進数では0.001234で、正規化すると1.234e-3
        System.out.println();
        System.out.println(new BigDecimal("123.456789").subtract(new BigDecimal("123.455555")).toPlainString());
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
