package dao.userdao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {

    public static void main(String args[]) throws IOException {
        JSONParser parser = new JSONParser();
        String newPassword = "12345";
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src\\main\\webapp\\files\\Users.json"));
     //       JSONObject person =  jsonArray.getJSONObject(0).getJSONObject("person");

            for (Object o : jsonArray) {
                JSONObject person = (JSONObject) o;
                if("2024".equals(person.get("username"))&&"Mayank".equals(person.get("answer")))
                {
                    person.put("password", newPassword);
                    try (FileWriter file = new FileWriter("src\\main\\webapp\\files\\Users.json"))
                    {
                        file.write(jsonArray.toString());
                        System.out.println("Successfully updated json object to file...!!");
                    }
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
