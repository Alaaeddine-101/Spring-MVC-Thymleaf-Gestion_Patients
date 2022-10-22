package GestionPatientMVC.gp.mvc.sec;

import GestionPatientMVC.gp.mvc.sec.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    // preciser comment spring security va chercher les utilisateurs(stockes en memoire, en base de donnees, gestionnaire d'utilisateur ldp...)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        // in memory authentication :
//        auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER")
//                .and().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER", "ADMIN");

        // jdbc authentication :
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
//                .authoritiesByUsernameQuery("select username as principal, role from user_role where username=?")
//                .rolePrefix("ROLE_");

        // user detail service authentication :
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // indique une page de login personnalise
      // http.formLogin().loginPage("/login");
        http.formLogin();
        // tout les requests http necessite une authentification!!
        //http.authorizeHttpRequests().anyRequest().authenticated();
        // for first 2 types:
//        http.authorizeHttpRequests().antMatchers("/").permitAll();
//        http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN");
//        http.authorizeHttpRequests().antMatchers("/user/**").hasRole("USER");
//        http.authorizeHttpRequests().antMatchers("/webjars/**").permitAll();
//        // toutes les ressources necessite une authentification, meme ci les ressources statiques
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.exceptionHandling().accessDeniedPage("/403");

        // for the UserDetailService type of authentucation
        http.authorizeHttpRequests().antMatchers("/").permitAll();
        http.authorizeHttpRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        http.authorizeHttpRequests().antMatchers("/user/**").hasAuthority("USER");
        http.authorizeHttpRequests().antMatchers("/webjars/**").permitAll();
        // toutes les ressources necessite une authentification, meme ci les ressources statiques
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
    }

}
