package pl.niczspeed.money_planner_app.mapper;

import pl.niczspeed.money_planner_app.dto.UserRegistrationDTO;
import pl.niczspeed.money_planner_app.model.User;

import static pl.niczspeed.money_planner_app.mapper.MonthlyBudgetMapper.mapToMonthlyBudget;
import static pl.niczspeed.money_planner_app.mapper.RecurringExpenseDTOMapper.mapRecurringExpenseDtoToRecurringExpense;

public class UserMapper {

    private UserMapper(){}

    public static User mapToUser(UserRegistrationDTO userRegisterDTO){
        return User.builder()
                .id(userRegisterDTO.getId())
                .username(userRegisterDTO.getUsername())
                .password(userRegisterDTO.getPassword())
                .email(userRegisterDTO.getEmail())
                .active(userRegisterDTO.isActive())
                .monthlyBudget(mapToMonthlyBudget(userRegisterDTO.getMonthlyBudgetDTO()))
                .recurringExpenseList(mapRecurringExpenseDtoToRecurringExpense(userRegisterDTO.getRecurringExpenseDTOS()))
                .build();
    }

}
