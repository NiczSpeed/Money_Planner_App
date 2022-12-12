package pl.niczspeed.money_planner_app.mapper;

import pl.niczspeed.money_planner_app.dto.MonthlyBudgetDTO;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;

import java.util.List;

public class MonthlyBudgetDTOMapper {

    public static List<MonthlyBudgetDTO> mapMonthlyBudgetToMonthlyBudgetDto(List<MonthlyBudget> monthlyBudgets) {
        return monthlyBudgets.stream()
                .map(monthlyBudget -> new MonthlyBudgetDTO(monthlyBudget.getId(), monthlyBudget.getPrice(), monthlyBudget.getCreateDate(), monthlyBudget.getModifyDate(), monthlyBudget.isActive()))
                .toList();
    }

}
