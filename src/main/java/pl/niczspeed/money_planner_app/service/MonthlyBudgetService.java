package pl.niczspeed.money_planner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;
import pl.niczspeed.money_planner_app.repository.MonthlyBudgetRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
@Transactional
public class MonthlyBudgetService {

    @Autowired
    private MonthlyBudgetRepository monthlyBudgetRepository;

    public void save(MonthlyBudget std) {
        if (monthlyBudgetRepository.getIdToMenage() == null || !monthlyBudgetRepository.getIdToMenage().equals("1"))
            monthlyBudgetRepository.save(std);
    }

    public String test() {
        if (monthlyBudgetRepository.test() == null) return "null";
        else return monthlyBudgetRepository.test();
    }

    public boolean dateCheck() {
        if (checkTableIsEmpty()) return true;
        else return LocalDate.now().getMonth().equals(monthlyBudgetRepository.getCreateDateToMenage().getMonth());
    }

    @PostConstruct
    @Scheduled(cron = "0 0 */1 * * *")
    public void updateStatus() {
        if (!dateCheck()) monthlyBudgetRepository.updateStatus();
    }

    public void updatePrice(MonthlyBudget std) {
        LocalDate modifyDate = LocalDate.now();
        double price = std.getPrice();
        monthlyBudgetRepository.updatePrice(modifyDate, price);
    }

    public boolean checkTableIsEmpty() {
        return monthlyBudgetRepository.getIdToMenage() == null;
    }

    public void deleteMonthlyBudget() {
        if (monthlyBudgetRepository.getActiveToMenage().equals("false")) monthlyBudgetRepository.deleteMonthlyBudget();
    }
}
