package com.power.formatter;

import com.power.pojo.DeviceInfo;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;

public class DeviceFormatter implements Formatter<DeviceInfo> {

    /**
     * 从String 转换为DeviceInfo
     * @param text
     * @param locale
     * @return
     * @throws ParseException
     */
    @Override
    public DeviceInfo parse(String text, Locale locale) throws ParseException {

        System.out.println("Local = "+locale);
        DeviceInfo  info = null;

        //text存在且有数据
        if (StringUtils.hasLength(text)) {
            //拆分数据
            String[] items = text.split(",");
            //创建对象//存入数据
            info = new DeviceInfo(items[0],items[1],items[2],items[3],items[4]);
        }

        //返回实例
        return info;
    }

    /**
     * 从DeviceInfo 转换为String
     * @param object
     * @param locale
     * @return
     */
    @Override
    public String print(DeviceInfo object, Locale locale) {
        return "测试";
    }
}
