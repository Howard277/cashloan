package com.ms.cashloan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户
 * @author wuketao
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户有效定义 false为不可用  true为可用
	 * 在mysql中使用tinyint定义该列，0表示false 1表示true。
	 * 当数据库中为0时，用户无法登录。
	 */
	private boolean enabled;

	/**
	 * 真实姓名
	 */
	private String realname;

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}