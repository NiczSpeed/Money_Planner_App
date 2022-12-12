package pl.niczspeed.money_planner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.niczspeed.money_planner_app.dto.MonthlyBudgetDTO;
import pl.niczspeed.money_planner_app.dto.UserRegistrationDTO;
import pl.niczspeed.money_planner_app.model.RecurringExpense;
import pl.niczspeed.money_planner_app.model.User;
import pl.niczspeed.money_planner_app.repository.UserRepository;

import java.util.List;
import static pl.niczspeed.money_planner_app.mapper.MonthlyBudgetMapper.mapToMonthlyBudget;

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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
