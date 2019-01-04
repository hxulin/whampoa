package cn.huangxulin.spring._01_hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * 功能描述:
 *
 * @author hxulin
 */
class HelloWorldTest {

    // 传统方式创建对象，组装依赖关系
    @Test
    void testOld() {
        HelloWorld world = new HelloWorld();
        world.setUsername("hxulin");
        world.sayHello();
    }

    // 使用Spring框架
    @Test
    void testIoC() {
        HelloWorld world;
        // 加载Spring配置文件
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 创建Bean工厂
        BeanFactory factory = new XmlBeanFactory(resource);
        // 从Spring容器获取对象
        world = (HelloWorld) factory.getBean("helloWorld");
        world.sayHello();
    }

    // 模拟Spring容器创建对象
    @Test
    @SuppressWarnings("unchecked")
    void testIoCMock() throws Exception {
        String className = "cn.huangxulin.spring._01_hello.HelloWorld";
        HelloWorld world;

        // ------------------------------------------------------------
        // 使用反射创建对象
        Class clazz = Class.forName(className);
        Constructor con = clazz.getDeclaredConstructor();
        con.setAccessible(true);    // 设置构造器的可访问性
        world = (HelloWorld) con.newInstance();

        // 使用内省机制设置属性值
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            // HelloWorld类中所有的属性名称
            String propertyName = pd.getName();
            if ("username".equals(propertyName)) {
                // 调用username的setter方法
                pd.getWriteMethod().invoke(world, "Castle");
            }
        }

        // ------------------------------------------------------------
        world.sayHello();
    }
}
