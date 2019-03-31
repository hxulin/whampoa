package cn.huangxulin.jpa.utils.vo;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: JPA查询结果映射工具类
 *
 * @author hxulin
 */
public final class ModelMap {

    private ModelMap() {

    }

    /**
     * 说明: 将JPA查询的List<Object[]>结果集封装到自定义对象中
     *
     * @param list 待处理数据
     * @param clazz 待映射对象类型，该对象的构造方法需要结合@Sign注解使用
     * @param sign 待映射对象构造器上的注解值，用于匹配不同的结果集映射
     * @param <T> 待映射对象泛型
     * @return 映射后的结果集
     *
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> mapping(List<Object[]> list, Class<T> clazz, int sign) {
        if (list != null) {
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.isAnnotationPresent(Sign.class)) {
                    if (sign == constructor.getAnnotation(Sign.class).value()) {
                        List<Object> result = new ArrayList<>(list.size());
                        try {
                            for (Object[] data : list) {
                                result.add(constructor.newInstance(data));
                            }
                            return (List<T>) result;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            throw new RuntimeException("\"" + clazz.getName() + "\" constructor need use annotation \"" + Sign.class.getName() + "\"");
        }
        return null;
    }
    
    /**
     * 说明: 将JPA查询的List<Object[]>结果集封装到自定义对象中
     *      为默认的注解值提供一个便捷的方法，不用传递注解参数0
     */
    public static <T> List<T> mapping(List<Object[]> list, Class<T> clazz) {
        return mapping(list, clazz, 0);
    }

}
