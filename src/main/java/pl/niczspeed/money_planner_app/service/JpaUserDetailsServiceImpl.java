package pl.niczspeed.money_planner_app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.niczspeed.money_planner_app.model.MyUserDetails;
import pl.niczspeed.money_planner_app.repository.JpaUserDetailsService;
import pl.niczspeed.money_planner_app.repository.UserRepository;


@Service
public class JpaUserDetailsServiceImpl implements JpaUserDetailsService {

    private final UserRepository userRepository;


    public JpaUserDetailsServiceImpl( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }



}
