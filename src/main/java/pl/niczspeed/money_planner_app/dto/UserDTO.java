package pl.niczspeed.money_planner_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private int id;

    private String username;

    private String password;

    private String email;

    private boolean active = true;

    private MonthlyBudget monthlyBudget;


}
