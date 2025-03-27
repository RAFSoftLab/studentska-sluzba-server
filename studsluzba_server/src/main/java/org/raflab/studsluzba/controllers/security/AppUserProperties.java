package org.raflab.studsluzba.controllers.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "app")
public class AppUserProperties {

    private List<InMemoryUser> users = new ArrayList<>();

    @Setter
    @Getter
    public static class InMemoryUser {
        private String username;
        private String password;
        private String role;
    }
}
