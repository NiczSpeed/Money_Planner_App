package pl.niczspeed.money_planner_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.niczspeed.money_planner_app.model.RecurringExpense;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationDTO {

    private int id;

    private String username;

    private String password;

    private String email;

    private boolean active = true;

    private MonthlyBudgetDTO monthlyBudgetDTO;

    private List<RecurringExpenseDTO> recurringExpenseDTOS;

}
