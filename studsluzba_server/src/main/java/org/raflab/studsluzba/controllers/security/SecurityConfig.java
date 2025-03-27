package org.raflab.studsluzba.controllers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserProperties appUserProperties;

    public SecurityConfig(AppUserProperties appUserProperties) {
        this.appUserProperties = appUserProperties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/professor/**").hasAnyRole("SUPER_ADMIN", "PROFESOR")
                .antMatchers("/api/assistant/**").hasAnyRole("SUPER_ADMIN", "PROFESOR", "SARADNIK")
                .antMatchers("/api/student/**").hasAnyRole("SUPER_ADMIN", "PROFESOR", "SARADNIK", "STUDENT")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        for (AppUserProperties.InMemoryUser user : appUserProperties.getUsers()) {
            UserDetails userDetails = User.withUsername(user.getUsername())
                    .password(passwordEncoder().encode(user.getPassword()))
                    .roles(user.getRole())
                    .build();
            manager.createUser(userDetails);
        }

        auth.userDetailsService(manager).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
