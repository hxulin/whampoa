package cn.huangxulin.spring._05_create_bean._04_factory_bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 功能描述: 实现 FactoryBean 接口
 *
 * 该方法可以理解为实例工厂的变种，以接口中的 getObject 方法来规范 factory-method 的方法名
 *
 * @author hxulin
 */
public class Cat4Factory implements FactoryBean<Cat4> {

    // 相当于实例工厂的 factory-method
    @Override
    public Cat4 getObject() throws Exception {
        Cat4 c4 = new Cat4();
        // TODO
        return c4;
    }

    @Override
    public Class<?> getObjectType() {
        return Cat4.class;
    }
}
