package pl.niczspeed.money_planner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.niczspeed.money_planner_app.model.User;
import pl.niczspeed.money_planner_app.repository.UserRepository;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
