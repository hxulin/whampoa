package cn.huangxulin.spring._01_hello;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class HelloWorld {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void sayHello() {
        System.out.println("欢迎来到Spring帝国，你好，" + username);
    }
}
