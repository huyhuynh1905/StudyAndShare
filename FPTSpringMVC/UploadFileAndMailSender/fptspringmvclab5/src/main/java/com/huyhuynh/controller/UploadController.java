package com.huyhuynh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * @project: fptspringmvclab5
 * @author: HuyHuynh on 15/05/2020
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    ServletContext context;

    @RequestMapping("/uploadfile")
    public String upload(ModelMap modelMap, @RequestParam("image") MultipartFile image){
        if (image.isEmpty()){
            modelMap.addAttribute("mess","Vui lòng chọn file!");
        } else {
            try {
                File file = new File("C:\\Users\\HuyHuynh\\IdeaProjects\\fptspringmvclab5\\src\\main\\webapp\\WEB-INF\\views\\images\\"+image.getOriginalFilename());
                image.transferTo(file);

                modelMap.addAttribute("name",image.getOriginalFilename());
                modelMap.addAttribute("type",image.getContentType());
                modelMap.addAttribute("size",image.getSize());
                return "/uploadsuccess";
            } catch (IOException e) {
                modelMap.addAttribute("mess",e.toString());
            }
        }
        return "/demoupload";
    }
}
