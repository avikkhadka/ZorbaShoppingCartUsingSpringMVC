package com.shoppingcart.config;

import com.shoppingcart.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public org.springframework.security.web.SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests()

                // accessible without any restrictions
                .requestMatchers(
                        "/user/register",
                        "/user/save",
                        "/user/login",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/static/**",
                        "/resources/**"
                ).permitAll()

                // ROLE-BASED SECURED PAGES
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/vendor/**").hasRole("VENDOR")

                // AUTHENTICATED PAGES
                .requestMatchers("/product/add").hasAnyRole("ADMIN", "VENDOR") // only admin/vendor can add product



                // AUTHENTICATED PAGES
                .requestMatchers("/product/**", "/cart/**").authenticated()

                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/product/list", true)
                .failureUrl("/user/login?error=true")
                .permitAll()


                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user/login?logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/product/access-denied")

                .and()
                .csrf().disable(); // disable temporarily during development

        return http.build();
    }
}
