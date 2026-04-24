package org.example.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 组件
@Component
@Scope("prototype")
public class Student {
    // 1. 补全属性（加上数据类型）
    private int id;           // 学生ID，通常用整数
    private String name;      // 学生姓名，用字符串
    private int age;          // 学生年龄，用整数



    /**
     * 学生参加考试的方法
     */
    public void exam() {
        System.out.println("========== 考试开始 ==========");
        System.out.println("学生姓名：" + name);
        System.out.println("学生年龄：" + age);
        System.out.println(name + " 正在认真答题...");
        int score = 60 + (int)(Math.random() * 40);
        System.out.println(name + " 考试完成，得分：" + score);
        System.out.println("========== 考试结束 ==========");
    }

    // 4. getter 和 setter 方法（JavaBean 核心）
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // @PostConstruct注解初始化方法
    @PostConstruct
    public void init() {
        System.out.println("Bean的初始化完成");
    }

    // @PreDestroy注解销毁方法
    @PreDestroy
    public void destroy() {
        System.out.println("bean销毁完成");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 取消注释的 toString 方法
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}