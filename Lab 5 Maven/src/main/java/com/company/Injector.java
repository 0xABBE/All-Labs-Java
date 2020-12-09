package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Properties;

public class Injector {
    public<T> void Injector(T t)
    {
        File file = new File("Data.properties");
        Properties properties=new Properties();
        try {
            properties.load(new FileReader(file));
        }catch (IOException e)
        {
            e.printStackTrace();
        }


        Field[] fields = t.getClass().getDeclaredFields();
        for(Field field:fields)
        {
            try
            {
                if(field.getAnnotation(AutoInjectable.class)!=null)
                {
                    field.setAccessible(true);
                    String typeOfField=field.getType().getName();
                    Class cl= Class.forName(typeOfField);
                    Constructor constructor = cl.getConstructor();
                    Object inst=constructor.newInstance();
                }
            }catch(NullPointerException | ClassNotFoundException | NoSuchMethodException e) {
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


