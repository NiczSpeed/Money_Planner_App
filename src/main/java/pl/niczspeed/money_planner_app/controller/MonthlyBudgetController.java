package pl.niczspeed.money_planner_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.niczspeed.money_planner_app.dto.MonthlyBudgetDTO;
import pl.niczspeed.money_planner_app.service.MonthlyBudgetService;

import java.util.List;

import static pl.niczspeed.money_planner_app.mapper.MonthlyBudgetDTOMapper.mapMonthlyBudgetToMonthlyBudgetDto;
import static pl.niczspeed.money_planner_app.mapper.MonthlyBudgetMapper.mapToMonthlyBudget;


@RestController
public class MonthlyBudgetController {

    private final MonthlyBudgetService monthlyBudgetService;

    @Autowired
    public MonthlyBudgetController(MonthlyBudgetService monthlyBudgetService) {
        this.monthlyBudgetService = monthlyBudgetService;
    }

//    @PostMapping("/save")
//    public void save(@RequestBody MonthlyBudgetDTO value) {
//        monthlyBudgetService.save(mapToMonthlyBudget(value));
//    }


    @GetMapping("/monthlyBudgets")
    public List<MonthlyBudgetDTO> getMonthlyBudgets() {
        return mapMonthlyBudgetToMonthlyBudgetDto(monthlyBudgetService.getAll());
    }


    @PutMapping(path = "/updatePrice")
    public void updatePrice(@RequestBody MonthlyBudgetDTO std) {
        monthlyBudgetService.updatePrice(mapToMonthlyBudget(std));
    }

    @PutMapping(path = "/update") // ten endpoint musi być wykonywany co jakiś okres czasu po stronie frontu
    public void updateMonthlyBudget(@RequestBody MonthlyBudgetDTO monthlyBudgetDTO) {
        monthlyBudgetService.updateMonthlyBudget(monthlyBudgetDTO);
    }

    @PutMapping(path = "/updateStatus") // ten endpoint musi być wykonywany co jakiś okres czasu po stronie frontu
    public void updateStatus() {
        monthlyBudgetService.updateStatus();
    }

}
