package com.ms.cashloan.controller;

import com.ms.cashloan.bean.EnumRole;
import com.ms.cashloan.bean.MyUserDetails;
import com.ms.cashloan.bean.User;
import com.ms.cashloan.config.MySecurityUtils;
import com.ms.cashloan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

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
	private ControllerUtils controllerUtils;

	@ResponseBody
	@RequestMapping(value = "findAll")
	public List<User> findAll() {
		return userService.findAll();
	}

	/**
	 * 用户信息主页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "", "index" })
	public ModelAndView index(ModelAndView model) {
		model.setViewName("user/index");
		controllerUtils.addCommonInfo(model);
		return model;
	}

}
