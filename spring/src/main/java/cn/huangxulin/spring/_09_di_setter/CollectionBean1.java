package cn.huangxulin.spring._09_di_setter;

import java.util.*;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class CollectionBean1 {

    private Set<String> set;

    private List<String> list;

    private String[] array;

    private Map<String, String> map;

    private Properties prop;

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProp(Properties prop) {
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
