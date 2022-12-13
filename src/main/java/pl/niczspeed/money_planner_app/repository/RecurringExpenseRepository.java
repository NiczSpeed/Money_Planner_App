package pl.niczspeed.money_planner_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niczspeed.money_planner_app.model.RecurringExpense;

@Repository
public interface RecurringExpenseRepository extends JpaRepository<RecurringExpense, Integer> {
}
