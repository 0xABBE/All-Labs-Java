package com.company;

import junit.framework.TestCase;
import org.junit.Test;

public class PersonTest extends TestCase {
    Person pers;
    public void setUp()
    {
        String[] str="28527;Aceline;Female;18.11.1939;D;5500".split(";");
        Department dep=new Department(0,"D");
        pers=new Person(str,dep);
    }

    public void testGetInfo() {
        String str="28527 Aceline Female 18.11.1939 D 5500";
        assertEquals(str,pers.getInfo());
    }
}