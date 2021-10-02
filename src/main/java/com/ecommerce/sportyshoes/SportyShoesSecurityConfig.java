//package com.ecommerce.sportyshoes;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//public class SportyShoesSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().
//        disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.OPTIONS, "/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic();
//    }
//}
