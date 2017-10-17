package com.ms.cashloan.repository;

import com.ms.cashloan.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 客户仓库接口
 * Created by wuketao on 2017/10/17.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
