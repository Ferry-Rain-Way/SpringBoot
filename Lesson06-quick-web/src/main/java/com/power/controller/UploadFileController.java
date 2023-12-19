package com.power.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



/**
 * 需要注意的是,Spring Boot 中默认上传的文件大小限制为1M
 * 如果需要上传大小超过1M需要早application文件中配置
 * 且在上传大文件时,不光要考虑SpringBoot 的文件大小限制,还需要考虑Tomcat的上传大小限制
 */


@Controller
public class UploadFileController {
    @RequestMapping("/files")
    public String upLoadFile(
            @RequestParam("upfile")
            MultipartFile mFile) {
        try {
            if (!mFile.isEmpty()) {
                //获取上传文件的参数进行封装
                Map<String, Object> fileInfoMap = new HashMap<>();
                fileInfoMap.put("上传文件参数名", mFile.getName());
                fileInfoMap.put("内容类型", mFile.getContentType());

                //获取文件的原始名称(但由于可能没有,所以设置一个固定值)
                String ext = "unknown";
                String oriFileName = mFile.getOriginalFilename();
                //判断是否存在文件名
                assert oriFileName != null;
                if (oriFileName.contains(".")) {
                    //存在获取源文件的文件名后缀
                    //此处是直接将文件名称中的后缀做为文件的类型,但是实际的开发中并不会这样做
                    //实际开发中会读取文件的字节,从字节中读取文件的信息(真正的文件类型)
                    ext = oriFileName.substring(oriFileName.indexOf("."));
                }

                //创建新的文件名
                String newfileName = UUID.randomUUID().toString() + ext;
                fileInfoMap.put("上传后文件的名称", newfileName);

                //上传文件存放的文件夹
                //注意: 文件夹必须存在,最后一个"\\"不能少
                String folderPath = "C:\\Users\\34838\\Desktop\\hello\\";
                String filePath = folderPath + newfileName;
                fileInfoMap.put("上传文件路径",filePath);
                System.out.println(fileInfoMap);
                mFile.transferTo(new File(filePath));

            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return "index";

    }
}