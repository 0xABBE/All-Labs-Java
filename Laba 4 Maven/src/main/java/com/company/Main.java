package com.company;
/**@author Evgeny Kulanin
 * @version 0.00
 * */
import java.io.IOException;
/**Main - класс программы*/
public class Main {
    /**Функция класса Main
     * @throws IOException - если что то не так с файлом для прочтения
     * @param args- параметр */
    public static void main(String[] args) throws IOException {
        String csvFilePath = "foreign_names.csv";
        Character separator =';';
        TableOfPersons table=new TableOfPersons();
        table.readFile(csvFilePath,separator);
        int numOfPersons=table.getNumberOfPersons();
        for(int i=0;i<numOfPersons;i++)
        {
            System.out.println(table.getPersonByIndex(i).getInfo());
        }
    }
}
