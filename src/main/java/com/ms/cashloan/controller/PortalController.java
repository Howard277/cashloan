package com.ms.cashloan.controller;

import com.ms.cashloan.bean.EnumRole;
import com.ms.cashloan.config.MySecurityUtils;
import com.ms.cashloan.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入口控制器
 *
 * @author wuketao
 */
@Controller
@RequestMapping(path = "/")
public class PortalController {
    @Autowired
    private MySecurityUtils securityUtils;
    @Autowired
    private UserRoleService userroleService;

    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        // 用户是否登录
        boolean isauth = securityUtils.isAuthentication();
        // 获取用户名
        String userName = null;
        // 判断是否拥有管理员角色
        boolean isadminrole = false;
        if (isauth) {
            UserDetails userdetails = securityUtils.getUserDetails();
            userName = userdetails.getUsername();
            isadminrole = securityUtils.containRole(EnumRole.ADMIN);
        }

        model.addAttribute("isauth", isauth);
        model.addAttribute("username", userName);
        model.addAttribute("isadminrole", isadminrole);
        return "index";
    }
}
