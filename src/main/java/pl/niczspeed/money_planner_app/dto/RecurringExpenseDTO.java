package pl.niczspeed.money_planner_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.niczspeed.money_planner_app.model.User;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecurringExpenseDTO {

    private int id;

    @ManyToOne
    private User user;

    private String name;

    private String description;

    private double value;

    private LocalDate createDate = LocalDate.now();

    private LocalDate modifyDate;

}
