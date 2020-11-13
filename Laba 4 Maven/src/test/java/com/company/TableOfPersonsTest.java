package com.company;

import org.junit.Test;
import junit.framework.TestCase;

public class TableOfPersonsTest extends TestCase {

    Person pers;
    TableOfPersons table1;
    public void setUp()
    {
        String[] str="28527;Aceline;Female;18.11.1939;D;5500".split(";");
        Department dep=new Department(0,"D");
        pers=new Person(str,dep);
        table1=new TableOfPersons();
        table1.addPerson(pers);
        table1.addPerson(pers);
    }

    public void testGetNumberOfPersons() {
        assertEquals(2,table1.getNumberOfPersons());
    }

}