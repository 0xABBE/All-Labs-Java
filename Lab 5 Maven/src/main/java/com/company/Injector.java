package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Properties;

/**
 * Main class of this programme.
 * **/
public class Injector {
    /** This Method inject fields of object of class T
     * by properties in the Data.properties.
     * @param t - object,whose fields we want initialized.
     * @param <T> Class of object T.
     */
    public<T> void Injector(T t)
    {
        //Opening of file with properties
        File file = new File("Data.properties");
        Properties properties=new Properties();
        try {
            properties.load(new FileReader(file));
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        //Reflection: Preview of fields of class T
        Field[] fields = t.getClass().getDeclaredFields();
        for(Field field:fields)
        {
            try
            {
                //If this field has our annotation, we initialized fields
                if(field.getAnnotation(AutoInjectable.class)!=null)
                {
                    field.setAccessible(true);

                    String typeOfField=properties.getProperty(field.getType().getName());
                    Class cl= Class.forName(typeOfField);
                    Constructor constructor = cl.getDeclaredConstructor();
                    Object inst=constructor.newInstance();

                    field.set(t,inst);
                }
            } catch(NullPointerException e) {
                e.printStackTrace();
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            } catch(NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}


