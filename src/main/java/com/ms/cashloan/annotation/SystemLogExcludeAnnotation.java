package com.ms.cashloan.annotation;

import java.lang.annotation.*;

/**
 * 系统日志排除注解 <br/>
 * 可以注解方法
 * 
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SystemLogExcludeAnnotation {

}
