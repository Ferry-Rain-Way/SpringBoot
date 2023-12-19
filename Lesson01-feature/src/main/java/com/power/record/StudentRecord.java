package com.power.record;


import java.net.http.HttpClient;

/**
 * 如果没有出现Record
 * 在Product Struct中检查module的JDK版本
 * Alt + insert → 生成测试类
 *  在测试类中Alt + insert → 生成测试方法
 */

public record StudentRecord(Integer id,String name,String email ,Integer age) {
    //规范构造函数是自带的,不用写,也不能写

    //紧凑型构造方法
    public StudentRecord{
        if(id<1){System.out.println(id);}
    }

    //自定义构造方法
    public StudentRecord(Integer id, String email) {
        //注意:自定义构造方法"第一行"必须调用 this() 方法进行传参,否则会报错
        this(id, null, email, null);
        System.out.println("自定义构造方法");
    }
}
