package sbnz.integracija.example.facts;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserTokenState {
	
    private String accessToken;
    private Long expiresIn;

    private String username;


    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
        this.username = null;
    }

    public UserTokenState(String accessToken, long expiresIn, String username) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.username = username;
    }

}