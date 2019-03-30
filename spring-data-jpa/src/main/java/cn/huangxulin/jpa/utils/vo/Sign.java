package cn.huangxulin.jpa.utils.vo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述: 自定义标记注解，贴在VO的构造器上，用于JPA查询结果的封装
 *
 * @author hxulin
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sign {
    int value() default 0;
}
