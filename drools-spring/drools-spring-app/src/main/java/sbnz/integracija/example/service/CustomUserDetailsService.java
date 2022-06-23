package sbnz.integracija.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.exception.UserNotFoundException;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.UserRepository;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	private User user;

	public CustomUserDetailsService() {
	}


	public CustomUserDetailsService(User user) {
        this.user = user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> maybeUser = userRepository.findByUsername(username);
		if (maybeUser.isPresent()) {
			return maybeUser.get();
		} else {
			throw new UserNotFoundException(String.format("No user found with username '%s'.", username));
		}
    }
}
