package com.week3.empmgmtsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // For simplicity, we're returning a static username.
        // In a real application, you would retrieve the logged-in user.
        return Optional.of("System");
    }
}