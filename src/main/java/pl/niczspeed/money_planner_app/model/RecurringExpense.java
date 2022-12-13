package pl.niczspeed.money_planner_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RECCURINGEXPENSES")
public class RecurringExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonBackReference
    @ManyToOne
    private User user;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "createDate", nullable = false)
    @JsonFormat(pattern = "YYYY-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate createDate;

    @Column(name = "modifyDate")
    @JsonFormat(pattern = "YYYY-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate modifyDate;

}
