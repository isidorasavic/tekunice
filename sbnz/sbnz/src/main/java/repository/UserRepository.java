package repository;

import java.util.List;
import java.util.Optional;

import model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findById(long id);

	  Optional<User> findByUsername(String username);

	  @Query("SELECT u.username FROM User u")
	  List<String> getUsernames();


	}
