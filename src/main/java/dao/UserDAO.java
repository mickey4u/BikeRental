package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.users.User;
import models.DummyUser;


import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class UserDAO {

    /**
     * This method checks if a user; student/staff exist in the UL database
     *
     * @param id represent the id of the user
     * @return
     */


    public boolean userExist(String id) {

        boolean found = false;

        try {
            Type type = new TypeToken<List<DummyUser>>() {
            }.getType();
            JsonReader reader = new JsonReader(new FileReader("src/ulstaff.json"));
            List<DummyUser> students = new Gson().fromJson(reader, type);
            for (DummyUser user : students) {
                if (user.getId().equals(id)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
