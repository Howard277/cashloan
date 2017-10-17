package com.ms.cashloan.bean;

import lombok.Data;
import java.util.*;

/**
 * Created by wuketao on 2017/10/17.
 */
@Data
public class DataPage<T> {
    private Integer code;

    private String msg;

    private Integer count;

    private List<T> data;
}
