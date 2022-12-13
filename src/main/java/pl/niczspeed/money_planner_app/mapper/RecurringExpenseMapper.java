package pl.niczspeed.money_planner_app.mapper;

import pl.niczspeed.money_planner_app.dto.RecurringExpenseDTO;
import pl.niczspeed.money_planner_app.model.RecurringExpense;


public class RecurringExpenseMapper {

    private RecurringExpenseMapper(){}

    public static RecurringExpense mapToRecurringExpense(RecurringExpenseDTO recurringExpenseDTO){
        return RecurringExpense.builder()
                .id(recurringExpenseDTO.getId())
                .user(recurringExpenseDTO.getUser())
                .name(recurringExpenseDTO.getName())
                .description(recurringExpenseDTO.getDescription())
                .value(recurringExpenseDTO.getValue())
                .createDate(recurringExpenseDTO.getCreateDate())
                .modifyDate(recurringExpenseDTO.getModifyDate())
                .build();
    }

}
