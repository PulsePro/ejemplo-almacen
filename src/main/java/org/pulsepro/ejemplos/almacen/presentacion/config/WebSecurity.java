package org.pulsepro.ejemplos.almacen.presentacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class WebSecurity {
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$12$qxVXq0GaQkknpoXki2evuekSOZtg1EPkoxvZHC3lVaK2RjwMhTNnu") // user
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$8yIBKy9PnLWaYAN2ee/oKu1Wwt.kO4rMPN6E/H0.qoPBKWPJLlJo2") // admin
                .roles("USER", "ADMIN")
                .build();

        UserDetails almacen = User.builder()
                .username("almacen")
                .password("{bcrypt}$2a$12$lgunwggZulhvHYNjSQLShuwjL0M3MgB97lk36.jPnUfW6OMPduSMK") // almacen
                .roles("USER", "ALMACEN")
                .build();
        return new InMemoryUserDetailsManager(user, admin, almacen);
    }

    @Bean
    @Order(0)
    public SecurityFilterChain h2FilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(antMatcher("/h2-console/**"))
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().permitAll();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(options -> options.disable()))
                .build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(antMatcher("/api/**"))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((session) -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(antMatcher(HttpMethod.POST, "/productos/**")).hasRole("ADMIN");
                    authorize.requestMatchers(antMatcher(HttpMethod.POST, "/albaranes/**")).hasAnyRole("ADMIN", "ALMACEN");
                    authorize.anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
