package sbnz.integracija.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.UserDTO;
import sbnz.integracija.example.exception.InvalidArgumentException;
import sbnz.integracija.example.exception.UserNotFoundException;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.UserRepository;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

	public UserDTO signUp(UserDTO userDTO) {
		if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
			throw new InvalidArgumentException(String.format("Username '%s' already exists!", userDTO.getUsername()));
		};
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		userRepository.saveAndFlush(user);
		return new UserDTO(user);
	}
}
