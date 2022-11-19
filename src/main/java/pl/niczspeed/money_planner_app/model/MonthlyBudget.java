package pl.niczspeed.money_planner_app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MONTHLYBUDGET")
public class MonthlyBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price", nullable = false)
    private double price;

    @JsonFormat(pattern = "YYYY-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "createDate", nullable = false)
    private LocalDate createDate = LocalDate.now();

    @JsonFormat(pattern = "YYYY-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "modifyDate")
    private LocalDate modifyDate;

    @Column(name = "active", nullable = false)
    private boolean active = true;


}
