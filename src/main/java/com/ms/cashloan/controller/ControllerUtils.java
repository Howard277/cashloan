package com.ms.cashloan.controller;

import com.ms.cashloan.bean.EnumRole;
import com.ms.cashloan.bean.MyUserDetails;
import com.ms.cashloan.config.MySecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wuketao on 2017/10/18.
 */
@Component
public class ControllerUtils {
    @Autowired
    private MySecurityUtils securityUtils;

    /**
     * 添加通用信息
     * @param mav
     */
    public void addCommonInfo(ModelAndView mav){
        MyUserDetails userdetails = (MyUserDetails)securityUtils.getUserDetails();
        if(null!=userdetails) {
            //判断是否拥有管理员角色
            boolean isadminrole = securityUtils.containRole(EnumRole.ADMIN);
            //添加当前用户 真实姓名
            mav.addObject("name", userdetails.getRealname());
        }
    }
}
