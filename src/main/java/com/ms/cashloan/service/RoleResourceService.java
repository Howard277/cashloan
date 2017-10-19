package com.ms.cashloan.service;

import com.ms.cashloan.bean.RoleResource;
import com.ms.cashloan.repository.RoleResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
/**
 * Created by wuketao on 2017/10/19.
 */
@Service
public class RoleResourceService {

    @Autowired
    private RoleResourceRepository roleResourceRepository;

    public List<RoleResource> findAll(){
        return roleResourceRepository.findAll();
    }
}
