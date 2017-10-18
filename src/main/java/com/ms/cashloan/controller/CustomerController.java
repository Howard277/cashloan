package com.ms.cashloan.controller;

import com.ms.cashloan.bean.Customer;
import com.ms.cashloan.bean.DataPage;
import com.ms.cashloan.bean.SexEnum;
import com.ms.cashloan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

/**
 * Created by wuketao on 2017/10/17.
 */
@Controller
@RequestMapping(path="customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * 客户列表视图
     * @return
     */
    @RequestMapping(path="listview",method = RequestMethod.GET)
    public ModelAndView listView(){
        ModelAndView mav = new ModelAndView("/customer/listview");
        controllerUtils.addCommonInfo(mav);
        return mav;
    }

    @RequestMapping(path="listdata",produces = "application/json")
    @ResponseBody
    public DataPage<Customer> listData(@RequestParam Integer page,@RequestParam Integer limit){
        DataPage<Customer> dataPage = new DataPage<Customer>();
        dataPage.setCode(0);
        dataPage.setMsg("");
        Pageable pageable = new PageRequest(page,limit);
        //通过分页信息获取数据
        Page<Customer> pageresult = customerService.findAllByPage(pageable);
        //解析返回结果，获取单页数据及总数据量
        dataPage.setCount(new Long(pageresult.getTotalElements()).intValue());
        dataPage.setData(pageresult.getContent());
        return dataPage;
    }

    /**
     * 添加用户 视图
     * @return
     */
    @RequestMapping(path="addview",method = RequestMethod.GET)
    public ModelAndView addView(){
        ModelAndView mav = new ModelAndView("/customer/addview");
        controllerUtils.addCommonInfo(mav);

        return mav;
    }

    @RequestMapping(path="save",method = RequestMethod.POST)
    @ResponseBody
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
}
