package pl.niczspeed.money_planner_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.niczspeed.money_planner_app.model.RecurringExpense;

import java.time.LocalDate;

@Repository
public interface RecurringExpenseRepository extends JpaRepository<RecurringExpense, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update reccuringexpenses set name = :name, description = :description, value = :value, modifyDate = :modifyDate where id = :id", nativeQuery = true)
    void updateRecurringExpense(@Param("name") String name, @Param("description") String description, @Param("value") double value, @Param("modifyDate") LocalDate modifyDate, @Param("id") int id);

}
