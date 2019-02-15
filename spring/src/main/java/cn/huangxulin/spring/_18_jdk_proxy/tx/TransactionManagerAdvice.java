package cn.huangxulin.spring._18_jdk_proxy.tx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 类加载器，一般使用真实对象的类加载器
                target.getClass().getInterfaces(),  // 真实对象所实现的接口 （JDK 动态代理必须要求真实对象有接口）
                this);  // 如何做事务增强的对象
    }

    /**
     * 如何为真实对象做增强的具体操作
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        // 不能直接打印代理对象，会出现栈溢出：java.lang.StackOverflowError
        // 原因：打印对象会调用对象的 toString 方法，toString 方法被代理增强，出现无限递归
        // System.out.println(proxy);

        // System.out.println(proxy.getClass());
        // System.out.println(method);
        // System.out.println(java.util.Arrays.toString(args));

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
