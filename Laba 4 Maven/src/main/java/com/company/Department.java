package com.company;
/**
 * Класс  создающий объект подразделения
 * */
public class Department {
    /**
     * Поля класса
     * depID - генерируется программой
     * depName - название подразделения
     * */
    private final int depID;
    private final String depName;
    /**
     * Constructor of this class
     * @param ID - Id of our object
     * @param Name - Name of our department
     * */
    public Department(int ID,String Name)
    {
        depID=ID;
        depName=Name;
    }
    /**
     * @return depID - integer number
     * */
    public int getDepartmentID()
    {
        return depID;
    }
    /**
     * @return depName - String
     * */
    public String getDepartmentName()
    {
        return depName;
    }
}
