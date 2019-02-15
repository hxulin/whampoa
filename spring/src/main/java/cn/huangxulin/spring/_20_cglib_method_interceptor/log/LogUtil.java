package cn.huangxulin.spring._20_cglib_method_interceptor.log;

import java.util.Date;

/**
 * 功能描述: 在 service 方法调用之前，做日志记录
 *
 * @author hxulin
 */
public class LogUtil {

    @SuppressWarnings("deprecation")
    public void writeLog(String className, String methodName) {
        System.out.println(new Date().toLocaleString() + "调用了" + className + "类中的" + methodName + "方法");
    }
}
