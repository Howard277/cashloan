package com.ms.cashloan.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解 <br/>
 * 可以注解类、方法
 * 
 * @author Administrator
 *
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SystemLogAnnotation {

}
