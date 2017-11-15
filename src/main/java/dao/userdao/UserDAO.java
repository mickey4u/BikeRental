package dao.userdao;


import com.google.gson.reflect.TypeToken;
import entities.users.RentalHistory;
import entities.users.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilities.FileManager;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDaoInterface {
    Type type;


    /**
     * This method checks if a user; student/staff exist in the UL database
     *
     * @param id represent the username of the user
     * @return
     */
    public User findUser(String id) {

        type = new TypeToken<List<User>>() {
        }.getType();

        List<User> students = FileManager.readFromflatFile("Users.json", User[].class);
        for (User user : students) {
            if (user.getUsername().equals(id)) {
                System.out.print(user.getUsername());
                return user;
            }
        }

        return null;
    }

    /*
    * Fetches the Rental History based on Input parameter username
    *
    * username
    * bookingTime
    * status
    *
    * Unable to read the file correctly at the moment. Throws a null pointer.
    *
    * */
    public List<RentalHistory> viewRentalHistory(String username) {

        type = new TypeToken<List<RentalHistory>>() {
        }.getType();
        RentalHistory rhistory = new RentalHistory();
        List<RentalHistory> rentalHistory = FileManager.readFromflatFile("bookings.json", RentalHistory[].class);
        for (RentalHistory history : rentalHistory) {
            if (rhistory.username.equals(username)) {
                System.out.print(rhistory.username);
                return rentalHistory;
            }
        }

        return null;
    }

    /*
    *
    * This method writes and updates the user password to the json file
    *
    * */
    @Override
    public Boolean updateDetails(String newPassword) throws FileNotFoundException
    {
        JSONParser parser = new JSONParser();
        User users = new User();
        try {
            JSONArray jsonArray = null;
            try {
                jsonArray = (JSONArray) parser.parse(new FileReader("src\\main\\webapp\\files\\Users.json"));
                for (Object o : jsonArray) {
                    JSONObject person = (JSONObject) o;
                    if (users.getUsername().equals(person.get("username")) && users.getSecretAnswer().equals(person.get("answer"))) {
                        person.put("password", newPassword);
                        try {
                            try (FileWriter file = new FileWriter("src\\main\\webapp\\files\\Users.json")) {
                                file.write(jsonArray.toString());
                                System.out.println("Successfully updated json object to file...!!");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch(Exception e)
            {

            }
        }
        finally {
            return true;
        }
    }


    /**
     * @return
     */
    public boolean createUser(User user) {

        return false;
    }

    /*
    *
    * Fetches user details for
    * 1. password reset
    *
    * */
    public boolean getUserDetails(String username)
    {
        try
        {
            User users = new User();
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new FileReader("src\\main\\webapp\\files\\Users.json"));
            JSONObject person = new JSONObject();

            for (Object o : a)
            {
                if(username.equals(person.get("username")))
                {
                    person = (JSONObject) o;
                    users.setFirstname(String.valueOf(person.get("username")));
                    users.setUsername(String.valueOf(person.get("password")));
                    users.setSecretQuestion( String.valueOf(person.get("username")));
                    users.setSecretQuestion( String.valueOf(person.get("secretQuestion")));
                    users.setSecretAnswer( String.valueOf(person.get("secretAnswer")));
                    return true;
                }
            }

        }

        catch(Exception e)
        {
            System.out.print(e);

        }
        return false;
    }


}
