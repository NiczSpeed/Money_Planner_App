package pl.niczspeed.money_planner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.niczspeed.money_planner_app.dto.RecurringExpenseDTO;
import pl.niczspeed.money_planner_app.repository.RecurringExpenseRepository;

import static pl.niczspeed.money_planner_app.mapper.RecurringExpenseMapper.mapToRecurringExpense;
@Service
public class RecurringExpenseService {

    @Autowired
    private RecurringExpenseRepository recurringExpenseRepository;

    @Autowired
    private UserService userService;

    public void save(RecurringExpenseDTO recurringExpenseDTO){
        recurringExpenseDTO.setUser(userService.getLoggedUser());
        recurringExpenseRepository.save(mapToRecurringExpense(recurringExpenseDTO));
    }

}
