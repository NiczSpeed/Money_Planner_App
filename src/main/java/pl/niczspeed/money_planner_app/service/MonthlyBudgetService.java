package pl.niczspeed.money_planner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.niczspeed.money_planner_app.dto.MonthlyBudgetDTO;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;
import pl.niczspeed.money_planner_app.repository.MonthlyBudgetRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MonthlyBudgetService {

    @Autowired
    private MonthlyBudgetRepository monthlyBudgetRepository;

    public List<MonthlyBudget> getAll() {
        return monthlyBudgetRepository.findAll();
    }

    public void save(MonthlyBudget std) {
        if (isUserAuthenticated() && !checkTableIsEmpty()) monthlyBudgetRepository.save(std);
    }

    public boolean dateCheck() {
        if (isUserAuthenticated()) {
            if (checkTableIsEmpty()) return true;
            else
                return LocalDate.now().getMonth().equals(monthlyBudgetRepository.getCreateDateToMenage(getCurrentUserId()).getMonth());
        } else return true;
    }

    public void updateStatus() {
        if (isUserAuthenticated() && !dateCheck()) monthlyBudgetRepository.updateStatus(getCurrentUserId());
    }

    public void updatePrice(MonthlyBudget std) {
        if (isUserAuthenticated()) {
            LocalDate modifyDate = LocalDate.now();
            double price = std.getPrice();
            monthlyBudgetRepository.updatePrice(modifyDate, price, getCurrentUserId());
        }
    }

    public boolean checkTableIsEmpty() {
        if (isUserAuthenticated()) {
            return monthlyBudgetRepository.getIdToMenage(getCurrentUserId()) == null;
        } else return true;
    }

    public void updateMonthlyBudget(MonthlyBudgetDTO monthlyBudgetDTO) {
        if (isUserAuthenticated() && monthlyBudgetRepository.getActiveToMenage(getCurrentUserId()).equals("false")) {
            monthlyBudgetRepository.updateMonthlyBudget(LocalDate.now(), null, monthlyBudgetDTO.getPrice(), getCurrentUserId());
        }
    }

    public int getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return monthlyBudgetRepository.getIdfromUsername(authentication.getName());
    }


    public boolean isUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && !("anonymousUser").equals(authentication.getName());
    }

}
