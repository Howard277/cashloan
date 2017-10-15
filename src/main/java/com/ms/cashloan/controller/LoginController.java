package com.ms.cashloan.controller;

import com.ms.cashloan.config.MySecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"","login"})
public class LoginController {
	@Autowired
	private MySecurityUtils mySecurityUtils;

	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value={"","login"})
	public String login() {
		return "/login/login";
	}

	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value={"logout"})
	public String logout() {
		//删除登录上下文
		mySecurityUtils.clearContext();
		return "/login/login";
	}
}
