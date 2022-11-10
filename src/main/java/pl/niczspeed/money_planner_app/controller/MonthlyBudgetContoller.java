package pl.niczspeed.money_planner_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.niczspeed.money_planner_app.model.MonthlyBudget;
import pl.niczspeed.money_planner_app.service.MonthlyBudgetService;

@RestController
public class MonthlyBudgetContoller {

    private final MonthlyBudgetService monthlyBudgetService;

    @Autowired
    public MonthlyBudgetContoller(MonthlyBudgetService monthlyBudgetService) {
        this.monthlyBudgetService = monthlyBudgetService;
    }

    @PostMapping("/save")
    public void save(@RequestBody MonthlyBudget value) {
        monthlyBudgetService.save(value);
    }

    @GetMapping("/test")
    public String test(){
        return monthlyBudgetService.test();
    }

    @PutMapping(path = "/save")
    public void updateStatus(){
        if(!monthlyBudgetService.dateCheck())monthlyBudgetService.updateStatus();
    }

    @PutMapping(path = "/updatePrice")
    public void updatePrice(@RequestBody MonthlyBudget std){
        monthlyBudgetService.updatePrice(std);
    }

    @GetMapping(path = "/checkTableIsEmpty")
    public boolean checkTableIsEmpty(){
        return monthlyBudgetService.checkTableIsEmpty();
    }

    @DeleteMapping(path = "/delete")
    public void deleteMonthlyBudget(){
        monthlyBudgetService.deleteMonthlyBudget();
    }
}
