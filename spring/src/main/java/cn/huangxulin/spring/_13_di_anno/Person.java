package cn.huangxulin.spring._13_di_anno;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class Person {

    private Cat c1;

    @Autowired
    public void setC1(Cat c1) {
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "c1=" + c1 +
                '}';
    }
}
