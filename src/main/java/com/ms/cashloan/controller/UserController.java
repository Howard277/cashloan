package com.ms.cashloan.controller;

import com.ms.cashloan.bean.EnumRole;
import com.ms.cashloan.bean.User;
import com.ms.cashloan.config.MySecurityUtils;
import com.ms.cashloan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户控制类
 * 
 * @author wuketao
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MySecurityUtils securityUtils;

	@ResponseBody
	@RequestMapping(value = "findAll")
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = { "", "index" })
	public String index(Model model) {
		//获取用户名
		UserDetails userdetails = securityUtils.getUserDetails();
		String userName = userdetails.getUsername();
		//判断是否拥有管理员角色
		boolean isadminrole = securityUtils.containRole(EnumRole.ADMIN);
		
		model.addAttribute("username", userName);
		model.addAttribute("isadminrole", isadminrole);
		return "user/index";
	}

}
