package main.java.antra.deptemp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("a").password("1").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("1").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/main").access("hasAnyRole('USER','admin')")
            .antMatchers("/manageEmp", "/manageDept", "/addDept", "/addEmp").access("hasRole('ADMIN')")
            .and()
            .formLogin().loginPage("/login")
            .and()
            .exceptionHandling().accessDeniedPage("/deny");
    }
}
