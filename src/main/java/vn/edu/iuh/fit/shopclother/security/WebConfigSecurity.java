package vn.edu.iuh.fit.shopclother.security;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.edu.iuh.fit.shopclother.entity.Account;
import vn.edu.iuh.fit.shopclother.services.AccountService;
import vn.edu.iuh.fit.shopclother.services.CookieService;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;

    @Autowired
    CookieService cookieService;

    @Autowired
    BCryptPasswordEncoder pe;

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    HttpSession session;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userName -> {
            try {
                Account user = accountService.findAccountById(userName);
                String password = pe.encode(user.getPassword());
//                String[] roles = user.getAuthoritiesList().stream().map(er -> er.getRole().getId())
//                        .toList().toArray(new String[0]);
                String[] roles = user.getAuthoritiesList().stream().map(er -> er.getRole().getRoleName())
                        .collect(Collectors.toList()).toArray(new String[0]);
                System.out.println("roles: " + Arrays.toString(roles));


                Map<String, Object> authentication = new HashMap<>();
                authentication.put("user", user);
                byte[] token = (userName + ":" + user.getPassword()).getBytes();
                authentication.put("token", "Basic " + Base64.getEncoder().encodeToString(token));
                session.setAttribute("authentication", authentication);

                cookieService.add("userName", user.getUserName(), 1);

                return User.withUsername(userName)
                        .password(password)
                        .roles(roles).build();
            } catch (NoSuchElementException e) {
                throw new UsernameNotFoundException(userName + " not found!");
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); // CSRF cam truy cap bang yeu cau gia lap
        http.cors().disable(); // CORS cam chia se tai nguyen ben trong

        http.authorizeRequests()
                .antMatchers("/order/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
        ;

        http.formLogin().loginPage("/security/login")
                .defaultSuccessUrl("/home/index")
                .usernameParameter("userName")
                .passwordParameter("password");
    }
}

