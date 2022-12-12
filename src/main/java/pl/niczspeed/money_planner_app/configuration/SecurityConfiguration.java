package pl.niczspeed.money_planner_app.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.niczspeed.money_planner_app.service.JpaUserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JpaUserDetailsServiceImpl jpaUserDetailsService;
    @Autowired
    public SecurityConfiguration(JpaUserDetailsServiceImpl jpaUserDetailsService){
        this.jpaUserDetailsService=jpaUserDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().mvcMatchers("/saveUser").permitAll()
                .mvcMatchers("/logged").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(Customizer.withDefaults())
//                .formLogin()
//                .loginPage("/login") bedzie strona do logowania
                .csrf().disable();
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) bedzie strona po wylogowaniu



        return http.build();
    }

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(jpaUserDetailsService);
        return authProvider;
    }


}
