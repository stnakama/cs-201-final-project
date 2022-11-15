package edu.usc.RestaurantReviews.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


 private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
  new AntPathRequestMatcher("/api/**")
 );

 AuthenticationProvider provider;
 
 @Override
 @Bean
 public AuthenticationManager authenticationManagerBean() throws Exception {
     return super.authenticationManagerBean();
 }

 public SecurityConfiguration(final AuthenticationProvider authenticationProvider) {
  super();
  this.provider = authenticationProvider;
 }

 //register authentication provider with Spring security
 @Override
 protected void configure(final AuthenticationManagerBuilder auth) {
  auth.authenticationProvider(provider);
 }

 @Override
 public void configure(final WebSecurity webSecurity) {
  webSecurity.ignoring().antMatchers("/token/**");
 }

 @Override
 public void configure(HttpSecurity http) throws Exception {
  http.sessionManagement()
   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
   .and()
   .exceptionHandling()
   .and()
   .authenticationProvider(provider)
   .addFilterBefore(authenticationFilter(), AnonymousAuthenticationFilter.class)
   .authorizeRequests()
   .requestMatchers(PROTECTED_URLS)
   .authenticated()
   .and()
   .csrf().disable()
   .formLogin().disable()
   .httpBasic().disable()
   .logout().disable();
 }

 @Bean
 AuthenticationFilter authenticationFilter() throws Exception {
  final AuthenticationFilter filter = new AuthenticationFilter(PROTECTED_URLS);
  filter.setAuthenticationManager(authenticationManager());
  //filter.setAuthenticationSuccessHandler(successHandler());
  return filter;
 }

 @Bean
 AuthenticationEntryPoint forbiddenEntryPoint() {
  return new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
 }
 

}