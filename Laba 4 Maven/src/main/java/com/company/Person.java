package com.company;
/**
 * Person - класс объектов людей
 * */
public class Person {
    private final int id;
    private final String personName;
    private final String gender;
    private final String birtDate;
    private final Department dep;
    private final int salary;
    /**Constructor of this class
     * @param str - information of person
     * @param department - department of our object
     * */
    public Person(String[] str,Department department)
    {
        if (str.length!=6 || department==null)
            throw new RuntimeException("Введенных данных не достаточно, чтобы создать объект класса.");
        id=Integer.parseInt(str[0]);
        personName=str[1];
        gender=str[2];
        birtDate=str[3];
        dep=department;
        salary=Integer.parseInt(str[5]);
    }
    /** @return String - All information about our object*/
    public String getInfo()
    {
        return (Integer.toString(id)+" "
                        +personName+" "
                        +gender+" "
                        +birtDate+" "
                        +dep.getDepartmentName()+" "
                        +Integer.toString(salary));
    }
}
