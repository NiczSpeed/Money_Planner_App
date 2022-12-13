package pl.niczspeed.money_planner_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.niczspeed.money_planner_app.dto.UserRegistrationDTO;
import pl.niczspeed.money_planner_app.model.User;
import pl.niczspeed.money_planner_app.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public void save(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        userRegistrationDTO.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        userService.save(userRegistrationDTO);
    }

    @GetMapping(path = "/User")
    public Optional<User> getLoggedUser(){
        return userService.getLoggedUser();
    }

    @GetMapping("/")
    public String hey(){
        return "Brawo doatrles tu <3 tzn ze jestes zalogowany <3";
    }

}
