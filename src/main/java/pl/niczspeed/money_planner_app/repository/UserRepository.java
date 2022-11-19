package pl.niczspeed.money_planner_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niczspeed.money_planner_app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
