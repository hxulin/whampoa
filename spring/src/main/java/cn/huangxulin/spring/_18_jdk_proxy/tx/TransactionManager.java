package cn.huangxulin.spring._18_jdk_proxy.tx;

import org.springframework.stereotype.Component;

/**
 * 功能描述: 模拟事务管理器
 *
 * @author hxulin
 */
@Component
public class TransactionManager {

    public void begin() {
        System.out.println("开启事务");
    }

    public void commit() {
        System.out.println("提交事务");
    }

    public void rollback() {
        System.out.println("回滚事务");
    }

}
