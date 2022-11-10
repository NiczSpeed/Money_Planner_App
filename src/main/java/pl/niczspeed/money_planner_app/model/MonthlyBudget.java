package pl.niczspeed.money_planner_app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MONTHLY_BUDGET")
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
