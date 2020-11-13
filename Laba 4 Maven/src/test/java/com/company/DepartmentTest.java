package com.company;

import junit.framework.TestCase;
import org.junit.*;

public class DepartmentTest extends TestCase {
    @Test
    public void testOfGetIndex()
    {
        Department dep=new Department(0,"NameOfDep");
        assertEquals(0,dep.getDepartmentID());
    }
    @Test
    public void testOfGetName()
    {
        Department dep=new Department(0,"NameOfDep");
        assertEquals("NameOfDep",dep.getDepartmentName());
    }
}