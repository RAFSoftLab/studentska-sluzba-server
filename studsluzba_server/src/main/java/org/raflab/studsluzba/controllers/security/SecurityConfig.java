package org.raflab.studsluzba.controllers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // nova anotacija umesto @EnableGlobalMethodSecurity
public class SecurityConfig {

    private final AppUserProperties appUserProperties;

    public SecurityConfig(AppUserProperties appUserProperties) {
        this.appUserProperties = appUserProperties;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/admin/**").hasRole("SUPER_ADMIN")
                        .requestMatchers("/api/professor/**").hasAnyRole("SUPER_ADMIN", "PROFESOR")
                        .requestMatchers("/api/assistant/**").hasAnyRole("SUPER_ADMIN", "PROFESOR", "SARADNIK")
                        .requestMatchers("/api/student/**").hasAnyRole("SUPER_ADMIN", "PROFESOR", "SARADNIK", "STUDENT")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        for (AppUserProperties.InMemoryUser user : appUserProperties.getUsers()) {
            UserDetails userDetails = User.withUsername(user.getUsername())
                    .password(passwordEncoder().encode(user.getPassword()))
                    .roles(user.getRole())
                    .build();
            manager.createUser(userDetails);
        }

        return manager;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
