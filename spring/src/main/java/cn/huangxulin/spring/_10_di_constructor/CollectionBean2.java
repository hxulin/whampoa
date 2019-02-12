package cn.huangxulin.spring._10_di_constructor;

import java.util.*;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class CollectionBean2 {

    private Set<String> set;

    private List<String> list;

    private String[] array;

    private Map<String, String> map;

    private Properties prop;

    public CollectionBean2(Set<String> set, List<String> list, String[] array, Map<String, String> map, Properties prop) {
        this.set = set;
        this.list = list;
        this.array = array;
        this.map = map;
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "CollectionBean1{" +
                "set=" + set +
                ", list=" + list +
                ", array=" + Arrays.toString(array) +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }
}
