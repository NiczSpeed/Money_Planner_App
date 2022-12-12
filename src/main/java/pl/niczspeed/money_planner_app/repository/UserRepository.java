package pl.niczspeed.money_planner_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.niczspeed.money_planner_app.dto.UserRegistrationDTO;
import pl.niczspeed.money_planner_app.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    User save(UserRegistrationDTO registrationDTO);

    @Query(value = "select username from users", nativeQuery = true)
    List<String> allUsernames();

    @Query(value = "select email from users", nativeQuery = true)
    List<String> allEmails();

}
