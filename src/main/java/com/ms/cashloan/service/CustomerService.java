package com.ms.cashloan.service;

import com.ms.cashloan.bean.Customer;
import com.ms.cashloan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * 客户服务类
 * Created by wuketao on 2017/10/17.
 */
@Transactional
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * 获取全部数据
     *
     * @return
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * 获取分页数据
     * @param pageable
     * @return
     */
    public Page<Customer> findAllByPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    /**
     * 保存客户
     * @param customer
     * @return
     */
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
}
