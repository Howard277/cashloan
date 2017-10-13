package com.ms.cashloan.repository;

import com.ms.cashloan.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色关联repository
 * 
 * @author wuketao
 *
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	@Query("select d from UserRole d where d.username = :username")
	public List<UserRole> findByUsername(@Param("username") String username);
}
