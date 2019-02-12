package cn.huangxulin.spring._07_lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能描述: Bean 的四种实例化方式
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class AppTest {

    @Test
    void testOld() {
        // 创建对象
        MyDataSource dataSource = new MyDataSource();
        // 立马对对象做初始化操作
        dataSource.open();

        dataSource.doWork();

        // 在销毁之前执行扫尾操作
        dataSource.close();
    }

    @Autowired
    private MyDataSource dataSource;

    @Test
    void testIoC() {
        dataSource.doWork();
    }
}
