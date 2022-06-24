package sbnz.integracija.example.dto;

import lombok.Getter;
import lombok.Setter;
import sbnz.integracija.example.facts.User;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
