package com.eazybytes.config;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EazyBankUserDetailsManager implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for user : " + email);
        }
        Customer customer = customers.get(0);
        userName = customer.getEmail();
        password = customer.getPwd();
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.getRole()));

        return new User(userName, password, authorities);
    }
}
