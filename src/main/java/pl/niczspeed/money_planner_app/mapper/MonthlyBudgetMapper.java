package pl.niczspeed.money_planner_app.mapper;

import pl.niczspeed.money_planner_app.dto.MonthlyBudgetDTO;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;

public class MonthlyBudgetMapper {

    private MonthlyBudgetMapper(){}

    public static MonthlyBudget mapToMonthlyBudget(MonthlyBudgetDTO monthlyBudgetDTO){
        return MonthlyBudget.builder()
                .id(monthlyBudgetDTO.getId())
                .price(monthlyBudgetDTO.getPrice())
                .createDate(monthlyBudgetDTO.getCreateDate())
                .modifyDate(monthlyBudgetDTO.getModifyDate())
                .active(monthlyBudgetDTO.isActive())
                .build();
    }

}
