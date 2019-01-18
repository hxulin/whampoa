package cn.huangxulin.mp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MPTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() throws Exception {

        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
