package pl.niczspeed.money_planner_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "active")
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monthlybudgetId", referencedColumnName = "id")
    private MonthlyBudget monthlyBudget;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RecurringExpense> recurringExpenseList;
}
