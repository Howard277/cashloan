package com.ms.cashloan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by wuketao on 2017/10/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RoleResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String rolename;

    private String url;
}
