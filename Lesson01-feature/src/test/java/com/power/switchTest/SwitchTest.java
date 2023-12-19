package com.power.switchTest;

import com.power.switchtest.Line;
import com.power.switchtest.Rectangle;
import com.power.switchtest.Shape;
import org.junit.Test;

public class SwitchTest{

//#region   箭头表达式
    @Test
    public void testSwitch() {
        int week = 7;
        String memo = "";
        switch (week) {
            case 1 -> memo = "星期日，休息";
            case 2, 3, 4, 5, 6 -> memo = "工作日";
            case 7 -> memo = "星期六，休息";
            default -> throw new IllegalArgumentException("无效的日期：");
        }
        System.out.println("week = " + memo);//week = 星期六，休息
    }
/*
    1.在使用  -> 时,单个语句直接写,多个语句用{}包裹
    2.可以注意到以上写法中并没有使用break,这是因为新语法
           只会执行匹配的语句,没有穿透效应。
    3.在新语法中进行判断赋值也比较方便
        旧:
            int opt;
            switch (fruit) {
            case "apple": opt = 1; break;
            case "pear":
            case "mango":opt = 2; break;
            default:opt = 0;break;
            }
        新:
         String fruit = "apple";
            int opt = switch (fruit) {
                case "apple" -> 1;
                case "pear", "mango" -> 2;
                default -> 0;
            }; // 注意赋值语句要以;结束


*/
//#endregion

//#region   yield
    @Test
    public void testYield(){
        int week = 2;
    //yield 是 switch 的返回值， yield 跳出当前 switch 块
    String memo = switch (week){
            case 1: yield "星期日，休息";
            case 2,3,4,5,6: yield "工作日";
            case 7: yield "星期六，休息";
            default: yield "无效日期";
        };
        System.out.println("week = " + memo);//week = 工作日
    }
//#endregion


    @Test
    public void testSwitchRecord(){
        //创建三个Record 不能使用局部Record

        Line line = new Line(20);
        Rectangle rectangle = new Rectangle(10,20);
        Shape shape = new Shape(20,30);

        Object obj = line;

        //此处使用需要JDK19+
        int result = switch(obj) {
            case Line(int x  ) -> {
                System.out.println("线的长度为:"+ x);
                yield x;
            }
            case Rectangle(int w,int h) -> w*h;
            case Shape(int width,int height) -> {
                System.out.println("周长为:"+ 2*(width+height));
                yield width*height;
            }
            default -> 0;
        };
    }




}
