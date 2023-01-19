package bootstrap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import service.AuthenticatedUserService;
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = AuthenticatedUserService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserDetailsService userDetailsService;

  /* @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().antMatchers("/noSecurity").permitAll()
           .anyRequest().authenticated()
           .and().formLogin().loginPage("/login").permitAll()
           .and().logout().permitAll();
      
   }*/
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   http.csrf().disable()
	   		
           .authorizeRequests()
           	.antMatchers("/addUser").anonymous()
               .anyRequest().authenticated()
               .and()
           .formLogin()
               .loginPage("/login")
               .permitAll();
	   
   }
   
   @SuppressWarnings("deprecation")
   @Bean
   public static NoOpPasswordEncoder passwordEncoder() {
   return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
   }

   @Autowired
   public void globalSecurityConfiguration(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService);
   }

}