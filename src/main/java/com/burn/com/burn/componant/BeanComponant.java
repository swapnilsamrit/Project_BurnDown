package com.burn.com.burn.componant;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanComponant {
    @Bean
    public PasswordEncoder bcyptEncode(){
        return new BCryptPasswordEncoder();
    }
}
