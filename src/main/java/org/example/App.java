package org.example;

import org.example.bean.Student;
import org.example.bean.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // 第一种方式, xml 的方式, 获取容器, 通过类路径寻找xml文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        System.out.println(context.getBean("student"));

        // 第二种方式, 注解方式
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.bean");
//        System.out.println(context.getBean(Student.class));
//        System.out.println(context.getBean(Student.class));
        // 了解生命周期的方法
//        ((AbstractApplicationContext)context).close();
        // 2.2种, 注解方式, 加入annotation-api依赖, @PostConstract 初始化, @ProDestroy销毁

        // 默认是单例, 多次获取 Bean 也是同一个. 多例, 每次获取Bean 都会创建一个新的
        // 作用域: 1.通过xml
        // 2. 通过注解 @scope

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
        teacher.manageExam();
    }
}
