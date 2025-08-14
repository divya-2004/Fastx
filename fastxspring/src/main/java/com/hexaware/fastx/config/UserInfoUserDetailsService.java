package com.hexaware.fastx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.Administrator;
import com.hexaware.fastx.entity.BusOperator;
import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.repository.AdministratorRepository;
import com.hexaware.fastx.repository.BusOperatorRepository;
import com.hexaware.fastx.repository.UserRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private BusOperatorRepository operatorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Check Admin first
        Administrator admin = adminRepository.findByEmail(email).orElse(null);
        if (admin != null) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(admin.getEmail())
                    .password(admin.getPassword())
                    .authorities("Admin")
                    .build();
        }

        // Check Operator
        BusOperator operator = operatorRepository.findByEmail(email).orElse(null);
        if (operator != null) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(operator.getEmail())
                    .password(operator.getPassword())
                    .authorities("Operator")
                    .build();
        }

        // Check User
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("User")
                .build();
    }
}