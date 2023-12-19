package com.springboot.fileupload.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Version 1.0
 * @ClassName : FileUploadController
 * @Author : GUO_HONG_YU
 * @Description: 使用MultipartFile文件上传
 */
@Controller
public class FileUploadController {
    @PostMapping("/files")
    public String uploadFile(@RequestParam("uploadFile") MultipartFile multipartFile
                           , HttpServletRequest request) throws IOException {

        //检查文件是否为空
        if (!multipartFile.isEmpty()) {
            // 获取项目的根路径
            String contextPath = request.getContextPath();
            System.out.println(contextPath);

            // 此处是获取resource文件夹的路径
            String projectRootPath = ClassLoader.getSystemResource("")
                    .toString().replaceAll("/target/classes/|file:/","");
            // 拼接resource的路径和文件名构成新的路径
            String path = projectRootPath+ "/src/main/resources/dest/"+ multipartFile.getOriginalFilename();

            System.out.println(path);
            // 上传到服务器中的路径 含文件名
            //准备文件对象
            File file = new File(path);
            //上传文件
            multipartFile.transferTo(file);
            return "redirect:/success.html";
        }
        return "redirect:/error.html";
    }

}
