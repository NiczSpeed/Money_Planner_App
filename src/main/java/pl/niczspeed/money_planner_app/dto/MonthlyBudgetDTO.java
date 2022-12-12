package pl.niczspeed.money_planner_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MonthlyBudgetDTO {

    private int id;

    private double price;

    private LocalDate createDate = LocalDate.now();

    private LocalDate modifyDate;

    private boolean active = true;

}
