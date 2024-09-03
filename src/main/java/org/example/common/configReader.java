package org.example.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    Properties properties;
    public configReader(){

       try {
           properties = new Properties();
           properties.load(new FileInputStream("src/test/resources/config.properties"));
       } catch (Exception e) {
           throw new RuntimeException(e);
       }


    }
    public String getProperty(String key){

        return properties.getProperty(key);
    }
}
