package cn.huangxulin.spring._08_xml_autowired;

/**
 * 功能描述: 让 Spring 帮我创建 Person 对象，而 Person 对象还需要依赖 Dog 对象
 *
 * @author hxulin
 */
public class Person {

    private Dog dog;

    // 属性：dog
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                '}';
    }
}
