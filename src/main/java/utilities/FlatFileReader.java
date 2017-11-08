package utilities;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opensymphony.xwork2.util.ClassLoaderUtil;
import entities.users.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains methods for reading data from flat files for
 * the bike rental platform
 *
 * @author Mike
 */
public class FlatFileReader implements Constants {

    /**
     * Method reads data from the file
     *
     * @param filename name of the flat file to read data from
     * @param type
     * @return
     */
    public synchronized static <T> List<T> readFromflatFile(String filename, Type type) {
        List<T> collections = null;

        InputStream path = ServletActionContext.getServletContext().getResourceAsStream(FILE_LOCATION + filename);
        JsonReader reader = null;
        try {
            reader = new JsonReader(new InputStreamReader(path, FILE_ENCODING));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        collections = Arrays.asList(new Gson().fromJson(reader, type));

        return collections;
    }

    /**
     * @param filename
     * @param object
     * @param type
     * @param <T>
     */
    public synchronized static <T> void writeToFile(String filename, T object, Type type) {
        List<T> collections = null;

    }
}
