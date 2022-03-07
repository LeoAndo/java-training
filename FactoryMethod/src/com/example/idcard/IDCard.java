package com.example.idcard;

import com.example.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    IDCard(String owner, int serial) {
        System.out.println(owner + "のカードを作ります。" + "通し番号: " + serial);
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(this + "を使います。");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + " : " + serial + "]";
    }

    public String getOwner() {
        return owner;
    }
}