package entities.users;

import java.util.Optional;

/**
 *
 */
public class Admin implements IUser{

    // quick fix, we need to do the multi classification
    String id;
    String password;

    @Override
    public Optional<String> getId() {
        return Optional.of(id);
    }

    @Override
    public Optional<String> getPassword() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
