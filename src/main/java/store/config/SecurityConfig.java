package store.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import store.model.Role;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String CONSUMER = Role.RoleName.CONSUMER.name();
    private static final String SELLER = Role.RoleName.SELLER.name();
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/registration").permitAll()
                .antMatchers(HttpMethod.GET,"/perfumes").hasAnyRole(CONSUMER, SELLER)
                .antMatchers(HttpMethod.POST, "/perfumes").hasRole(SELLER)
                .antMatchers(HttpMethod.GET, "/users/by-email").hasRole(SELLER)
                .antMatchers(HttpMethod.GET, "/orders", "/baskets/by-user").hasRole(CONSUMER)
                .antMatchers(HttpMethod.POST,"/orders/complete").hasRole(CONSUMER)
                .antMatchers(HttpMethod.PUT,"/baskets/perfumes").hasRole(CONSUMER)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
