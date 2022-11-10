package pl.niczspeed.money_planner_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;

import java.time.LocalDate;


@Repository
public interface MonthlyBudgetRepository extends JpaRepository<MonthlyBudget, Integer> {

    @Query(value = "select create_date from monthlybudget where id = 1", nativeQuery = true)
    String test();

    @Query(value = "select active from monthlybudget where id = 1", nativeQuery = true)
    String getActiveToMenage();

    @Modifying
    @Query(value = "update monthlybudget set active = false where id = 1", nativeQuery = true)
    void updateStatus();

    @Query(value = "select create_date from monthlybudget where id = 1", nativeQuery = true)
    LocalDate getCreateDateToMenage();

    @Query(value = "select id from monthlybudget where id = 1", nativeQuery = true)
    String getIdToMenage();

    @Modifying
    @Query(value = "update monthlybudget set modify_date= :modifyDate, price = :price where id = 1", nativeQuery = true)
    void updatePrice(@Param("modifyDate") LocalDate modifyDate, @Param("price") double price);

    @Modifying
    @Query(value = "delete from monthlybudget where id = 1", nativeQuery = true)
    void deleteMonthlyBudget();
}
