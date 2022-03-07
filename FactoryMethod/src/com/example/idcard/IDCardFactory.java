package com.example.idcard;

import com.example.framework.Factory;
import com.example.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "を登録しました。");
    }
}