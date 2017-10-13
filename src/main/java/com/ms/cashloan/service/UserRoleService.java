package com.ms.cashloan.service;

import com.ms.cashloan.bean.UserRole;
import com.ms.cashloan.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 用户角色服务层
 * 
 * @author wuketao
 *
 */
@Transactional
@Service
public class UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;

	/**
	 * 获取所有用户关系对象
	 * @return
	 */
	public List<UserRole> findAll() {
		return userRoleRepository.findAll();
	}
	
	public List<UserRole> findByUsername(String username)
	{
		return userRoleRepository.findByUsername(username);
	}
}
