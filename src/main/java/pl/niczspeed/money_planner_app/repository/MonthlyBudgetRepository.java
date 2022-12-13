package pl.niczspeed.money_planner_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;

import java.time.LocalDate;


@Repository
public interface MonthlyBudgetRepository extends JpaRepository<MonthlyBudget, Integer> {

    @Query(value = "select active from monthlybudgets where id = :id", nativeQuery = true)
    String getActiveToMenage(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update monthlybudgets set active = false where id = :id", nativeQuery = true)
    void updateStatus(@Param("id") int id);

    @Query(value = "select createDate from monthlybudgets where id = :id", nativeQuery = true)
    LocalDate getCreateDateToMenage(@Param("id") int id);

    @Query(value = "select id from monthlybudgets where id = :id", nativeQuery = true)
    String getIdToMenage(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update monthlybudgets set modifyDate = :modifyDate, price = :price where id = :id", nativeQuery = true)
    void updatePrice(@Param("modifyDate") LocalDate modifyDate, @Param("price") double price, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update monthlybudgets set active = true, createDate = :createDate, modifyDate = :modifyDate, price = :price  where id = :id", nativeQuery = true)
    void updateMonthlyBudget(@Param("createDate") LocalDate createDate, @Param("modifyDate") LocalDate modifyDate, @Param("price") double price, @Param("id") int id);

    @Query(value = "select id from users where username = :username", nativeQuery = true)
    int getIdfromUsername(@Param("username") String username);
}
