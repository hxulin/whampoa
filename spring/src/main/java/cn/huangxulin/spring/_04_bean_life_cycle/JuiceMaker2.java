package cn.huangxulin.spring._04_bean_life_cycle;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Data
public class JuiceMaker2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String beverageShop;

    private Source source;

    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    public void myDestroy() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }

    public String makeJuice() {
        return "这是一杯由" + beverageShop + "饮品店, 提供的" + source.getSize() + source.getSugar() + source.getFruit();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 BeanNameAware 接口的 setBeanName 方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 BeanFactoryAware 接口的 setBeanFactory 方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 ApplicationContextAware 接口的 setApplicationContext 方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用 InitializingBean 接口的 afterPropertiesSet 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用接口 DisposableBean 的 destroy 方法");
    }

}
