package utilities;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import entities.booking.Booking;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains methods for reading data from flat files for
 * the bike rental platform
 *
 * @author Mike
 */
public class FileManager implements Constants {

    private static Gson gson;

    /**
     * @param fileName represents the absolute path plus the file name
     */
    public static void writeToFile(String fileName, Booking booking) {

        try {

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            // timestamp for simulation
            out.println("Timestamp" + new Timestamp(System.currentTimeMillis()));
            out.println("Timestamp" + booking.toString());
            out.println();
            out.println();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
     * @param data
     * @param <T>
     */
    public synchronized static <T> void writeToFile(String filename, List<T> data) {

        gson = new Gson();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream path = classLoader.getResourceAsStream("Users.json");
        // file to write data to
        File fileToWrite = new File("C:\\Users\\Molly\\Desktop\\Files\\Users.json");

        try {
            // check if the file to write to exist, else create one
            if (!fileToWrite.exists()) {
                fileToWrite.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(fileToWrite, true);
            fileWriter.write(gson.toJson(data) + gson.toJson(data));
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
