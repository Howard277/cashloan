package com.ms.cashloan.controller;

import com.ms.cashloan.bean.User;
import com.ms.cashloan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理员 控制器
 * @author wuketao
 *
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private UserService userService;

	/**
	 * 索引页面
	 * @return
	 */
	@RequestMapping(value={"","index"})
	public String index()
	{
		return "admin/index";
	}
	
	/**
	 * 获取所有管理员信息
	 * @return
	 */
	@RequestMapping("findAll")
	@ResponseBody
	public List<User> findAll()
	{
		return userService.findAll();
	}
}
