package com.ptm.projectintellijexample.configuration;

import com.ptm.projectintellijexample.service.impl.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailService customUserDetailService;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth)-> auth.
                        requestMatchers("/**").permitAll().
                        requestMatchers("/admin/**").hasAuthority("ADMIN").
                        requestMatchers("/admin/**").permitAll().
                anyRequest().authenticated()).formLogin(login->login.loginPage("/admin/logon").loginProcessingUrl("/logon").
                usernameParameter("username").passwordParameter("password").
                defaultSuccessUrl("/admin", true)).logout(logout
                        -> logout.logoutUrl("admin/logout").logoutSuccessUrl("/logon").invalidateHttpSession(true));


        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer(){
        return (web)-> web.ignoring().requestMatchers("/static/**","/assets/**",
                "/admin/**", "/fe/**","/uploads/**");
    }
}
