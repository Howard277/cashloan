package com.ms.cashloan.repository;

import com.ms.cashloan.bean.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
/**
 * Created by wuketao on 2017/10/19.
 */
@Repository
public interface RoleResourceRepository extends JpaRepository<RoleResource,Long> {
    List<RoleResource> findByRolename(String rolename);
}
