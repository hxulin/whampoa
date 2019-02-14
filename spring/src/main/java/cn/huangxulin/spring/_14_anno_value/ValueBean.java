package cn.huangxulin.spring._14_anno_value;

import org.springframework.beans.factory.annotation.Value;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class ValueBean {

    @Value("${server.port}")
    private int port;

    @Override
    public String toString() {
        return "ValueBean{" +
                "port=" + port +
                '}';
    }
}
