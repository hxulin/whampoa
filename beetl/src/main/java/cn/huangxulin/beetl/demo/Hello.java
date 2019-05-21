package cn.huangxulin.beetl.demo;

import cn.huangxulin.beetl.domain.User;
import cn.huangxulin.beetl.domain.Wife;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class Hello {

    private static GroupTemplate groupTemplate;

    static {
        try {

            String root = System.getProperty("user.dir") + File.separator + "beetl" + File.separator + "template";
            FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
            Configuration cfg = Configuration.defaultConfiguration();
            groupTemplate = new GroupTemplate(resourceLoader, cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符串渲染
     */
    private void test1() throws IOException {
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello, ${name}");
        t.binding("name", "beetl");
        String str = t.render();
        System.out.println(str);
    }

    /**
     * 文件模板渲染
     */
    private void test2() throws IOException {
        String root = System.getProperty("user.dir") + File.separator + "beetl" + File.separator + "template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/hello.txt");
        t.binding("userName", "Castle");
        String str = t.render();
        System.out.println(str);
    }

    /**
     * Classpath 资源模板加载器
     */
    private void test3() throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("cn/huangxulin/beetl/demo/");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/hello.txt");
        // 绑定全局变量, 这些变量能在模板的任何一个地方, 包括子模板都能访问到
        t.binding("userName", "Castle");
        String str = t.render();
        System.out.println(str);
    }

    private void test4() throws IOException {
        String root = System.getProperty("user.dir") + File.separator + "beetl" + File.separator + "template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/test4.txt");

        User user = new User();
        Wife wife = new Wife();
        user.setName("husband");
        wife.setName("wife");
        user.setWife(wife);

        /*
         * 自从2.8.0版本后，有一个特殊的变量成为root变量，当模板找不到变量的时候
         * 会寻找root变量的属性来作为变量的值，这个root变量必须绑定为"_root"
         */
        t.binding("_root", user);

        String str = t.render();
        System.out.println(str);
    }

    @Active
    private void test5() throws IOException {
        Template t = groupTemplate.getTemplate("/test5.txt");

        ArrayList list = new ArrayList<User>(){{
            add(new User("User1"));
            add(new User("User2"));
            add(new User("User3"));
        }};

        t.binding("list", list);

        String str = t.render();
        System.out.println(str);
    }



    public static void main(String[] args) {
        Class<Hello> clazz = Hello.class;
        Method[] methods = clazz.getDeclaredMethods();
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Active.class)) {
                    method.invoke(Modifier.isStatic(method.getModifiers()) ? null : clazz.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
