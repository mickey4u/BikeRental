package dao.userdao;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import entities.users.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Test {

    public static void main(String args[]) throws IOException, ParseException {
        try
        {
            User users = new User();
            JSONParser parser = new JSONParser();
            File absolute = new File("/Users.json");
            Test.class.getResourceAsStream("/Users.json");
            JSONArray a = (JSONArray) parser.parse(new FileReader("src\\main\\webapp\\files\\Users.json"));

            for (Object o : a) {
                JSONObject person = (JSONObject) o;
                users.setFirstname(String.valueOf(person.get("username")));
                users.setUsername(String.valueOf(person.get("password")));
                users.setSecretQuestion( String.valueOf(person.get("username")));
            }
        }

            catch(Exception e)
            {
                System.out.print(e);

            }
}}

