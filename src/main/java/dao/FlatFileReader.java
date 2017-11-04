package dao;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * This class contains methods for reading data from flat files for
 * the bike rental platform
 *
 * @author Mike
 */
public class FlatFileReader {

    /**
     * Method reads data from the file
     *
     * @param filename name of the flat file to read data from
     * @param type
     * @return
     */
    public static <T> List<T> readFromflatFile(String filename, Type type) {
        List<T> collections = null;
        try {
            JsonReader reader = new JsonReader(new FileReader("src/" + filename));
            collections = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return collections;
    }
}
