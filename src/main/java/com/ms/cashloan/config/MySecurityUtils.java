package com.ms.cashloan.config;

import com.ms.cashloan.bean.EnumRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Security工具类
 * 
 * @author wuketao
 *
 */
@Component
public class MySecurityUtils {
	/**
	 * 拥有ADMIN权限
	 */
	public static final String hasAuthorityADMIN = "hasAuthority('ADMIN')";

	/**
	 * 用户是否登录
	 * 
	 * @return
	 */
	public boolean isAuthentication() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if ("anonymousUser".equals(principal)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 获取用户详细数据
	 * 
	 * @return
	 */
	public UserDetails getUserDetails() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return (UserDetails) principal;
		} else {
			return null;
		}
	}

	/**
	 * 清除登录信息上下文
	 */
	public void clearContext() {
		SecurityContextHolder.clearContext();
	}

	/**
	 * 判断是否包含某个角色
	 * 
	 * @param role
	 * @return
	 */
	public boolean containRole(EnumRole role) {
		UserDetails userDetails = getUserDetails();
		if (null != userDetails) {
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				if (grantedAuthority.getAuthority().equals(role.toString())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取所有授权
	 * 
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthority() {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		return authorities;
	}
}
