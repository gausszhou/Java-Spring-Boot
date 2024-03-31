package com.example.javaspringboot.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class FileController {

    private static final String UPLOADER_FOLDER = System.getProperty("user.dir") + "/target/upload/";

    @PostMapping("/file/upload")
    public String upload(@Nullable @RequestParam("name") String name, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(multipartFile.getContentType());
        long fileSize =  multipartFile.getSize();
        System.out.println(fileSize);
        System.out.println(path);
        System.out.println(UPLOADER_FOLDER);
        saveFile(multipartFile, path);
        return "success";
    }

    private void saveFile(MultipartFile multipartFile, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            boolean mkdir = dir.mkdir();
            if(!mkdir) {
                System.out.println("文件夹创建失败" + dir);
            }
        }
        String filePath = path + multipartFile.getOriginalFilename();
        System.out.println(filePath);
        File file = new File(filePath);
        multipartFile.transferTo(file);
    }

    @GetMapping("/file/download")
    public File upload(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse resp) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        String filePath = path + name;
        System.out.println(filePath);
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        OutputStream os = resp.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        return file;
    }
}
