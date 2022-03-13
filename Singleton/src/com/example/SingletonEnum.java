package com.example;

public enum SingletonEnum {
    INSTANCE;
    public void hello(){
        System.out.println("Singleton with Enum");
    }
}
