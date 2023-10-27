package com.example.helloworld.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FIleUploadController {
    @PostMapping("/upload")
    public String upload(String username, MultipartFile photo, HttpServletRequest request) throws IOException{
        System.out.println(username);
        // print filename
        System.out.println(photo.getOriginalFilename());
        // get the file type
        System.out.println(photo.getContentType());

        // get path to store the file: dynamic path + /upload
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);
        saveFile(photo, path);

        return "upload succeed";
    }

    /*
        save the file to the path
     */
    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdir();
        }

        // combine directory(path) and filename
        File file = new File(path + '/' + photo.getOriginalFilename());

        // save photo
        photo.transferTo(file);
    }

}
