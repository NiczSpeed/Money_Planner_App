package pl.niczspeed.money_planner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.niczspeed.money_planner_app.dto.MonthlyBudgetDTO;
import pl.niczspeed.money_planner_app.dto.UserRegistrationDTO;
import pl.niczspeed.money_planner_app.model.RecurringExpense;
import pl.niczspeed.money_planner_app.model.User;
import pl.niczspeed.money_planner_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static pl.niczspeed.money_planner_app.mapper.MonthlyBudgetMapper.mapToMonthlyBudget;
import static pl.niczspeed.money_planner_app.mapper.UserMapper.mapToUser;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getId(), registrationDTO.getUsername(), registrationDTO.getPassword(), registrationDTO.getEmail(), registrationDTO.isActive(), mapToMonthlyBudget(new MonthlyBudgetDTO()), List.of(new RecurringExpense()));
        for (String i : userRepository.allUsernames()) {
            if (i.equals(registrationDTO.getUsername())) return null;
        }
        for (String i : userRepository.allEmails()) {
            if (i.equals(registrationDTO.getEmail())) return null;
        }
        return userRepository.save(user);
    }

    public int getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.getIdfromUsername(authentication.getName());
    }

    public User getLoggedUser(){
        return userRepository.loggedUserDetails(getCurrentUserId());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
