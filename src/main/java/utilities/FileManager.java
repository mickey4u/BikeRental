package utilities;

import entities.booking.Booking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * This class contains methods for reading data from flat files for
 * the bike rental platform
 *
 */
public class FileManager implements Constants {

    /**
     * @param fileName represents the absolute path plus the file name
     */
    public static void writeToFile(String fileName, Booking booking) {

        try {

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            // timestamp for simulation
            out.println("Timestamp : " + new Timestamp(System.currentTimeMillis()));
            out.println(booking.toString());
            out.println();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileName represents the absolute path plus the file name
     */
    public static void writeToFile(String fileName, String message) {

        try {

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            // timestamp for simulation
            out.println("Timestamp : " + new Timestamp(System.currentTimeMillis()));
            out.println(message);
            out.println();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
