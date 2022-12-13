package pl.niczspeed.money_planner_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.niczspeed.money_planner_app.dto.RecurringExpenseDTO;
import pl.niczspeed.money_planner_app.service.RecurringExpenseService;

@RestController
public class RecurringExpenseController {

    private final RecurringExpenseService recurringExpenseService;

    @Autowired
    public RecurringExpenseController(RecurringExpenseService recurringExpenseService){
        this.recurringExpenseService = recurringExpenseService;
    }

    @PostMapping(path = "/saveRecurring")
    public void saveRecurring(@RequestBody RecurringExpenseDTO recurringExpenseDTO){
        recurringExpenseService.save(recurringExpenseDTO);
    }

    @PutMapping(path = "/updateRecurring")
    public void updateRecurringExpense(@RequestBody RecurringExpenseDTO recurringExpenseDTO){
        recurringExpenseService.updateRecurringExpense(recurringExpenseDTO);
    }

}
