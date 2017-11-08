package entities.users;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class User {

    // user's username, UL username number
    @SerializedName("username")
    private String username;
    // user's password
    @SerializedName("password")
    private String password;
    // user's first name
    @SerializedName("firstname")
    private String firstname;
    // user's last name
    @SerializedName("lastname")
    private String lastname;
    // secret question
    @SerializedName("secretQuestion")
    private String secretQuestion;

}
