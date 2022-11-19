package pl.niczspeed.money_planner_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class  MoneyPlannerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyPlannerAppApplication.class, args);
    }

}
