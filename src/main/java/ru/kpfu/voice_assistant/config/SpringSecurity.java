package ru.kpfu.voice_assistant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    private static final String[] PERMIT_ALL = {
        "/auth/**",
        "/swagger-ui/**",
        "/swagger-resources/*",
        "/v3/api-docs/**",
        "/login",
        "/confirm",
        "/register",
        "/css/**",
        "/scripts/**",
        "/images/**",
        "/home",
        "/faq"

    };

    private static final String[] AUTHORIZED = {
        "/save-domains",
        "/save-domain",
        "/get-domains",
        "/save-page",
        "/get-pages/**",
        "/save-pages/**",
        "/test-widget",
        "/recognize-audio",
        "/tokens",
        "/get-tokens",
        "/history",
        "/get-language-codes",
        "/test-history"
    };

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((authorize) ->
                authorize.requestMatchers(PERMIT_ALL).permitAll()
                    .requestMatchers(AUTHORIZED).authenticated()
            ).formLogin(
                form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
            ).logout(
                logout -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .permitAll()
            );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
