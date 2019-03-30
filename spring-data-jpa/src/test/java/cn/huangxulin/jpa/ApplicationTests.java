package cn.huangxulin.jpa;

import cn.huangxulin.jpa.service.UserService;
import cn.huangxulin.jpa.utils.json.JSONUtils;
import cn.huangxulin.jpa.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void testQuery() {
        List<UserVO> result = userService.query();
        String json = JSONUtils.toJson(result);
        logger.info(json);
    }

    @Test
    public void testQuery1() {
        List<UserVO> result = userService.query1();
        String json = JSONUtils.toJson(result);
        logger.info(json);
    }

    @Test
    public void testQuery2() {
        List<UserVO> result = userService.query2();
        String json = JSONUtils.toJson(result);
        logger.info(json);
    }

}
