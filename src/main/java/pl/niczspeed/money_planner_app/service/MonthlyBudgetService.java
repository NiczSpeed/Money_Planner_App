package pl.niczspeed.money_planner_app.service;

import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;
import pl.niczspeed.money_planner_app.repository.MonthlyBudgetRepository;

import java.time.LocalDate;

@Service
@Transactional
public class MonthlyBudgetService {

    @Autowired
    private MonthlyBudgetRepository monthlyBudgetRepository;

    public void save(MonthlyBudget std) {
        if (monthlyBudgetRepository.getIdToMenage() == null) monthlyBudgetRepository.save(std);

        else if (!monthlyBudgetRepository.getIdToMenage().equals("1")) monthlyBudgetRepository.save(std);

    }

    public String test() {
        if (monthlyBudgetRepository.test() == null) return "null";
        else return monthlyBudgetRepository.test();
    }

    public boolean dateCheck() {
        return LocalDate.now().getMonth().equals(monthlyBudgetRepository.getCreateDateToMenage().getMonth());
    }

    public void updateStatus() {
        monthlyBudgetRepository.updateStatus();
    }

    public void updatePrice(MonthlyBudget std) {
        LocalDate modifyDate = LocalDate.now();
        double price = std.getPrice();
        monthlyBudgetRepository.updatePrice(modifyDate, price);
    }

    public boolean checkTableIsEmpty(){
        if(monthlyBudgetRepository.getIdToMenage() == null) return true;
        else return false;
    }

    public void deleteMonthlyBudget(){
        if(monthlyBudgetRepository.getActiveToMenage().equals("false"))monthlyBudgetRepository.deleteMonthlyBudget();
    }
}
