package cn.huangxulin.jpa.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public final class JSONUtils {

    private JSONUtils() {

    }

    /**
     * 将Java对象序列化为JSON字符串
     */
    public static String toJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
