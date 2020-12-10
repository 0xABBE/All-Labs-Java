package com.company;
/**Class Main.**/
public class Main {
    public static void main(String[] args)  {
        SomeBean cl=new SomeBean();
        (new Injector()).Injector(cl);
        cl.foo();
    }
}
