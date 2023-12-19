package com.power.record;

import junit.framework.TestCase;

public class StudentRecordTest extends TestCase {
    public void test01() {
        //创建Record对象
        StudentRecord stu1 = new StudentRecord(20111022, "张三", "12306@qq.com", 23);
        System.out.println(stu1);

        System.out.println(stu1.id());
        //没有set方法,值在第一次赋值后就不在可变
    }

    //局部使用Record
    public void testLocalRecord(){
        //定义 Java Record
        record SaleRecord(String saleId,String productName,Double money){};
        //创建 Local Record
        SaleRecord saleRecord = new SaleRecord("S22020301", "手机", 3000.0);
        //使用 SaleRecord
        System.out.println("销售记录 = " + saleRecord.toString());
    }

    //嵌套使用Record

}