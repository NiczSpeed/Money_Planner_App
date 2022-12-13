package pl.niczspeed.money_planner_app.mapper;

import pl.niczspeed.money_planner_app.dto.RecurringExpenseDTO;
import pl.niczspeed.money_planner_app.model.RecurringExpense;

import java.util.List;

public class RecurringExpenseDTOMapper {

    private RecurringExpenseDTOMapper(){}

    public static List<RecurringExpenseDTO> mapRecurringExpenseToRecurringExpenseDto(List<RecurringExpense> recurringExpenses){
        return recurringExpenses.stream()
                .map(recurringExpense -> new RecurringExpenseDTO(recurringExpense.getId(), recurringExpense.getUser(), recurringExpense.getName(), recurringExpense.getDescription(), recurringExpense.getValue(), recurringExpense.getCreateDate(), recurringExpense.getModifyDate()))
                .toList();
    }

    public static  List<RecurringExpense> mapRecurringExpenseDtoToRecurringExpense(List<RecurringExpenseDTO> recurringExpenseDTOS){
        return recurringExpenseDTOS.stream()
                .map(recurringExpenseDTO -> new RecurringExpense(recurringExpenseDTO.getId(), recurringExpenseDTO.getUser(), recurringExpenseDTO.getName(), recurringExpenseDTO.getDescription(), recurringExpenseDTO.getValue(), recurringExpenseDTO.getCreateDate(), recurringExpenseDTO.getModifyDate()))
                .toList();
    }
}
