package cn.huangxulin.spring._20_cglib_method_interceptor.log;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class LogAdvice implements MethodInterceptor {

    private Object target;  // 真实对象
    private LogUtil logUtil;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setLogUtil(LogUtil logUtil) {
        this.logUtil = logUtil;
    }

    // 创建代理对象
    @SuppressWarnings("unchecked")
    public <T> T getProxyObject() {
        /*Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();*/
        return (T) Enhancer.create(target.getClass(), this);
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        logUtil.writeLog(method.getDeclaringClass().getName(), method.getName());
        return method.invoke(target, args);
    }
}
