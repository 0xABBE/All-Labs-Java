package com.company;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
/**
 * Главный класс программы,создает список, в котором хранит все объекты класса Person
 * */
public class TableOfPersons {
    private final List<Person> lst;
    /**Constructor of this class*/
    public TableOfPersons()
    {
        lst=new ArrayList<>();
    }
    /**@return Person - objects from this table
     * @param index - index of output object*/
    public Person getPersonByIndex(int index)
    {
        return lst.get(index);
    }
    /**@return integer number - number of objects inside the table */
    public int getNumberOfPersons()
    {
        return lst.size();
    }
    /**Добавляет в список персону
     * @param pers Наша персона.*/
    public void addPerson(Person pers)
    {
        lst.add(pers);
    }

    /**
     * Главный класс программы
     * Считывает данные из файла и заполняет ими таблицу
     * @param csvFilePath - строка, содержащая название файла, который нужно прочесть.
     * @param separator - параметр, разделяющий считанную строку из файла на несколько подстрок.
     * @throws IOException - if this file not found or this file is empty */
    public void readFile(String csvFilePath,Character separator) throws IOException {
        Map<String,Department> deps=new HashMap<>();
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in), separator)) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] nextLine;
            Department depart;
            Person pers;
            nextLine=reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if(!deps.containsKey(nextLine[4])) {
                    depart= new Department(deps.size(), nextLine[4]);
                    deps.put(nextLine[4],depart);
                }
                pers=new Person(nextLine,deps.get(nextLine[4]));
                lst.add(pers);
            }
        }
    }
}
