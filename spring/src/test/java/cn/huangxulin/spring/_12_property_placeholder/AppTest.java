package cn.huangxulin.spring._12_property_placeholder;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@SpringJUnitConfig
public class AppTest {

    @Autowired
    private DataSource dataSource;


    @Test
    void test() throws Exception {

        @Cleanup
        Connection conn = dataSource.getConnection();

        @Cleanup
        PreparedStatement ps = conn.prepareStatement("SELECT `id`, `username`, `name`, `age`, `balance` FROM `user`");

        @Cleanup
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getLong("id") + ", ");
            System.out.print(rs.getString("username") + ", ");
            System.out.print(rs.getString("name") + ", ");
            System.out.print(rs.getInt("age") + ", ");
            System.out.println(rs.getBigDecimal("balance"));
        }
    }


}
