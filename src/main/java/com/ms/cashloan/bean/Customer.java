package com.ms.cashloan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户信息
 * Created by wuketao on 2017/10/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String cardid;

    private Date birthday;

    @Enumerated(value = EnumType.STRING)
    private SexEnum sex;

    private String homeaddress;

    private String phonenumber;

    private String wechatname;

    private String qqnumber;
}
