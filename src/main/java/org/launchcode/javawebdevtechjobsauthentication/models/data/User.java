package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
    public String getUsername() {
        return username;
    }
//    public boolean isMatchingPassword(String password) {
//        String candidateHash = encoder.encode(password);
//        return candidateHash.equals(pwHash);
//    }

}
