package main;

import sort.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurator {
    public static Sort getSort() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            String filename = "config.properties";
            input = Repository.class.getClassLoader().getResourceAsStream(filename);
            prop.load(input);

            String sortType = prop.getProperty("sorter");
            switch (sortType) {
                case "bubble":
                    return new BubbleSort();
                case "insertion":
                    return new InsertionSort();
                case "shaker":
                    return new ShakerSort();
                default:
                    throw new Exception("Wrong sort type: " + sortType);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
