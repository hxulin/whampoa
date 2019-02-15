package cn.huangxulin.spring._19_cglib_proxy.tx;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * 功能描述: 事务增强操作
 *
 * @author hxulin
 */
public class TransactionManagerAdvice implements InvocationHandler {

    private Object target;  // 真实对象，对谁做增强

    private TransactionManager txManager;  // 事务管理器

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 创建一个代理对象
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());  // 将继承于哪一个类，去做增强
        enhancer.setCallback(this);  // 设置增强的对象
        return (T) enhancer.create(); // 代理对象
    }

    /**
     * 如何为真实对象做增强的具体操作
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object result = null;
        txManager.begin();
        try {
            result = method.invoke(target, args);  // 调用真实对象的方法
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
