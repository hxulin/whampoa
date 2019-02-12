package cn.huangxulin.spring._09_di_setter;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class Person1 {

    private Cat1 cat1;

    public void setCat1(Cat1 cat1) {
        this.cat1 = cat1;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "cat1=" + cat1 +
                '}';
    }
}
