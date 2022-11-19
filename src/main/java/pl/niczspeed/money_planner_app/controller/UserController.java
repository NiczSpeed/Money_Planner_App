package pl.niczspeed.money_planner_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pl.niczspeed.money_planner_app.model.User;
import pl.niczspeed.money_planner_app.service.UserService;

import java.util.List;

public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
