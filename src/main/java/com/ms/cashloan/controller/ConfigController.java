package com.ms.cashloan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 配置信息 控制器
 * @author wuketao
 *
 */
@Controller
@RequestMapping("config")
public class ConfigController {
	
	@RequestMapping(value={"","index"})
	public String index()
	{
		return "config/index";
	}
}
