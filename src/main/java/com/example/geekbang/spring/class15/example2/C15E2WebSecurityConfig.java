package com.example.geekbang.spring.class15.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Objects;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：ROLE_ 前缀与角色
 * 权限控制类 模拟授权时的角色相关控制
 * ROLE_ 前缀在 Spring Security 前缀中非常重要。
 * @author: gao wei
 * @create: 2022-02-07 21:54
 */

//@Configuration
//public class C15E2WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return Objects.equals(charSequence.toString(), s);
//            }
//        };
//    }
//
//    /**
//     * @description
//     * 用户 fujian：角色为 USER
//     * 用户 admin1：角色为 ADMIN
//     * 用户 admin2：角色为 ADMIN   注意在给admin1，2添加角色的时候用了两种方式
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("fujian").password("pass").roles("USER")
//                .and()
//                .withUser("admin1").password("pass").roles("ADMIN")
//                .and()
//                .withUser(new UserDetails() {
//                    @Override
//                    public Collection getAuthorities() {
//                        /*
//                         *问题复现:将ROLE_ADMIN改为ADMIN后
//                         * admin1 可以登录，而 admin2 设置了同样的角色却不可以登陆
//                         * 问题修正
//                         * ROLE_ 前缀在 Spring Security 前缀中非常 重要 在添加 admin2 时，给角色添加上 ROLE_ 前缀即可
//                         */
//                        //return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
//                        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//                    } //省略其他非关键“实现”方法
//
//                    @Override
//                    public String getPassword() {
//                        return "pass";
//                    }
//
//                    @Override
//                    public String getUsername() {
//                        return "admin2";
//                    }
//
//                    @Override
//                    public boolean isAccountNonExpired() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isAccountNonLocked() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isCredentialsNonExpired() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isEnabled() {
//                        return false;
//                    }
//                });
//    }
//
//    // 配置 URL 对应的访问权限
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginProcessingUrl("/login").permitAll()
//                .and()
//                .csrf().disable();
//    }
//}
