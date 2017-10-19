package com.ms.cashloan.service;

import com.ms.cashloan.bean.Resource;
import com.ms.cashloan.repository.ResourceRepository;
import com.ms.cashloan.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wuketao on 2017/10/19.
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
}
