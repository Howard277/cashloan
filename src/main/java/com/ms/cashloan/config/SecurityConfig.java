package com.ms.cashloan.config;

import com.ms.cashloan.bean.EnumRole;
import com.ms.cashloan.bean.Resource;
import com.ms.cashloan.bean.Role;
import com.ms.cashloan.bean.RoleResource;
import com.ms.cashloan.service.ResourceService;
import com.ms.cashloan.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

/**
 * 安全配置
 *
 * @author wuketao
 * @EnableWebSecurity 启动web安全配置
 * @EnableGlobalMethodSecurity 启动全局方法安全配置
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private RoleResourceService roleResourceService;

    /**
     * 配置URL路径访问规则 静态资源及登录页面允许任意访问 所有用户界面需要验证后方可访问 所有管理员界面要求有管理员授权
     * loginPage("/login") 配置登录页面 defaultSuccessUrl("/user")配置登录成功后的跳转页面
     * failureUrl("/login") 配置登录失败的跳转页面
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf
        http.csrf().disable();
//        http.authorizeRequests().anyRequest().authenticated();
        List<RoleResource> listRoleResource = roleResourceService.findAll();
        for (RoleResource roleresource : listRoleResource) {
            String[] roles = roleresource.getRolename().split(",");
            for (int i = 0; i < roles.length; i++) {
                http.authorizeRequests().antMatchers(roleresource.getUrl()).hasAuthority(roles[i]);
            }
        }
//		http.authorizeRequests().antMatchers("/user/**").authenticated();
        // 注意这里权限配置使用的是hasAuthority，而不是hasRole。它们的区别请进入定义中查看
//		http.authorizeRequests().antMatchers("/admin/**").hasAuthority(EnumRole.ADMIN.name());
        http.authorizeRequests().and().formLogin().loginPage("/login/login").defaultSuccessUrl("/user/index").failureUrl("/login/login");
    }

    /**
     * 配置用户授权
     * 使用自定义UserDetailsService 和 Bcrypt对密码进行加密
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //在这里，将自定义的UserDetailsService注入
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        //设置密码加密方法
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider);
    }
}
