package com.ms.cashloan.repository;

import com.ms.cashloan.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色repository
 * 
 * @author wuketao
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
