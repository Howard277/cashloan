package com.ms.cashloan.bean;

/**
 * 性别枚举
 * Created by wuketao on 2017/10/17.
 */
public enum SexEnum {
    MAN("男"), WOMAN("女");
    private String desc;

    private SexEnum(String desc) {
        this.desc = desc;
    }
}
