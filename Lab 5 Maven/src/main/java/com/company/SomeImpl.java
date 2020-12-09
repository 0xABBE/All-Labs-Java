package com.company;

public class SomeImpl implements SomeInterface {
    private int name;
    @Override
    public void doSomething() {
        System.out.println("A");
    }
    public SomeImpl(int name){
        this.name = name;
    };
}
